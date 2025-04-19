package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

class RunningState implements TimerState {

    public RunningState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.toStoppedState();
    }


    @Override
    public void onTick() {
        sm.actionDec();
        sm.toRunningState();
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.RUNNING;
    }
}
