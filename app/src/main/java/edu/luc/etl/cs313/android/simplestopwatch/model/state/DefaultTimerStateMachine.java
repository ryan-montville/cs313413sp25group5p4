package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.TimerModelListener;
import edu.luc.etl.cs313.android.simplestopwatch.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simplestopwatch.model.time.TimeModel;

/**
 * An implementation of the state machine for the stopwatch.
 *
 * @author laufer
 */
public class DefaultTimerStateMachine implements TimerStateMachine {
    private final TimeModel timeModel;
    private final ClockModel clockModel;
    private TimerState state;

    public DefaultTimerStateMachine(final TimeModel timeModel, final ClockModel clockModel) {
        this.timeModel = timeModel;
        this.clockModel = clockModel;
    }

    protected void setState(final TimerState state) {
        this.state = state;
        listener.onStateUpdate(state.getId()); //notifies UI of the state change
    }

    private StopwatchModelListener listener;

    @Override
    public void setModelListener(final StopwatchModelListener listener) {
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
    @Override public void actionAdd()        { timeModel.incRuntime(); actionUpdateView(); } 
    @Override public void actionStart()      { clockModel.start(); }
    @Override public void actionStop()       { clockModel.stop(); }
    @Override public void actionDec()        {
        timeModel.decRuntime();
        if (timeModel.isTimeZero()) {
            toBeepingState();
            clockModel.stop();
        }
        actionUpdateView();
    }
    @Override public void actionUpdateView() { state.updateView(); }

    @Override
    public void actionResetThreeSecondCountdown() {
        timeModel.restedCountdownTime();;
    }

    @Override
    public void actionDecThreeSecondCountdown() {
        timeModel.decCountdownTime();;
        if (timeModel.isCountdownZero()) {
            toRunningState();; 
            clockModel.start();
        }
        actionUpdateView();;
    }
}
