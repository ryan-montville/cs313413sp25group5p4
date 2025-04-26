package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

class RunningState implements TimerState {

    public RunningState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.actionReset();
        sm.toStoppedState();
    }


    @Override
    public void onTick() {
        //every tick (1 second), decrement the timer
        sm.actionDec();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        //return the ID representing the Running state (for the UI display)
        return R.string.RUNNING;
    }
}
