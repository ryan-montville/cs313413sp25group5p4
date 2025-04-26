package edu.luc.etl.cs313.android.simpletimer.model.state;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.RingtoneManager;
import android.net.Uri;

import edu.luc.etl.cs313.android.simpletimer.common.TimerModelListener;
import edu.luc.etl.cs313.android.simpletimer.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simpletimer.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaultTimerStateMachine implements TimerStateMachine {
    private final TimeModel timeModel;
    private final ClockModel clockModel;
    private TimerState state;
    private final Context context;

    public DefaultTimerStateMachine(final TimeModel timeModel, final ClockModel clockModel, final Context context) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
        this.context = context;
    }

    protected void setState(final TimerState state) {
        this.state = state;
        listener.onStateUpdate(state.getId()); //notifies UI of the state change
    }

    private TimerModelListener listener;

    @Override
    public void setModelListener(final TimerModelListener listener) {
        this.listener = listener;
    }

    //@Override public synchronized void onStartStop() { state.onStartStop(); } //old button
    public synchronized void onButtonClicked() { state.onButtonClicked(); }

    @Override public synchronized void onTick() { state.onTick(); } //assigning tick to current state

    @Override public void updateUIRuntime() { listener.onTimeUpdate(timeModel.getRuntime()); }
    //@Override public void updateUILaptime() { listener.onTimeUpdate(timeModel.getLaptime()); }

    // known states    
    //Defines all the known states used in the timer's finite state machine
    private final TimerState STOPPED = new StoppedState(this);
    private final TimerState RUNNING = new RunningState(this);
    private final TimerState COUNTDOWN_DELAY = new CountdownDelayState(this);
    private final TimerState BEEPING = new BeepingState(this);

    // transitions
    @Override public void toRunningState()    { setState(RUNNING); }
    @Override public void toStoppedState()    { setState(STOPPED); }
    @Override public void toCountdownDelayState() { setState(COUNTDOWN_DELAY ); }
    @Override public void toBeepingState()    { setState(BEEPING); }

    // actions
    @Override public void actionInit()       { toStoppedState(); actionReset(); }
    @Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
    @Override public void actionAdd()        {
        timeModel.incRuntime();
        if(timeModel.getRuntime() >= 99){
            actionBeep();
            toRunningState();
        }
        actionUpdateView();
    }
    @Override public void actionStart()      { clockModel.start(); }
    @Override public void actionStop()       { clockModel.stop(); }
    @Override public void actionDec()        {
        timeModel.decRuntime();
        if (timeModel.isTimeZero()) {
            toBeepingState();
        }
        actionUpdateView();
    }
    @Override
    public void actionBeep() {
        if (context != null) {
            final Uri defaultRingtoneUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            MediaPlayer mediaPlayer = MediaPlayer.create(context, defaultRingtoneUri);
            if (mediaPlayer != null) {
                mediaPlayer.start();
                mediaPlayer.setOnCompletionListener(mp -> mp.release()); // Release resources
            } else {
                System.out.println("TimerStateMachine: Could not create MediaPlayer for beep sound.");
            }
        } else {
            System.out.println("TimerStateMachine: Context is null, cannot play beep sound.");
        }
    }

    @Override public void actionUpdateView() { state.updateView(); }

    @Override
    public void actionResetThreeSecondCountdown() {
        timeModel.restedCountdownTime();
    }

    @Override
    public void actionDecThreeSecondCountdown() {
        timeModel.decCountdownTime();
        if (timeModel.isCountdownZero()) {
            actionBeep();
            toRunningState();
        }
        actionUpdateView();
    }
}
