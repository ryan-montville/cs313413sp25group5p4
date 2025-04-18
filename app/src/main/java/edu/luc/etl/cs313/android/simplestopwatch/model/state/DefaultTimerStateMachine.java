package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.common.StopwatchModelListener;
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
        listener.onStateUpdate(state.getId());
    }

    private StopwatchModelListener listener;

    @Override
    public void setModelListener(final StopwatchModelListener listener) {
        this.listener = listener;
    }

    //@Override public synchronized void onStartStop() { state.onStartStop(); } //old button
    public synchronized void onButtonClicked() { state.onButtonClicked(); }

    @Override public synchronized void onTick() { state.onTick(); }

    @Override public void updateUIRuntime() { listener.onTimeUpdate(timeModel.getRuntime()); }
    //@Override public void updateUILaptime() { listener.onTimeUpdate(timeModel.getLaptime()); }

    // known states
    private final TimerState STOPPED = new StoppedState(this);
    private final TimerState RUNNING = new RunningState(this);
    private final TimerState COUNTDOWN_DELAY = new CountdownState(this);

    // transitions
    @Override public void toRunningState()    { setState(RUNNING); }
    @Override public void toStoppedState()    { setState(STOPPED); }

    @Override public void toCountdownState() { setState(COUNTDOWN_DELAY); }

    // actions
    @Override public void actionInit()       { toStoppedState(); actionReset(); }
    @Override public void actionReset()      { timeModel.resetRuntime(); actionUpdateView(); }
    @Override public void actionAdd()        {  }
    @Override public void actionStart()      { clockModel.start(); }
    @Override public void actionStop()       { clockModel.stop(); }
    @Override public void actionDec()        { timeModel.incRuntime(); actionUpdateView(); }
    @Override public void actionUpdateView() { state.updateView(); }
}
