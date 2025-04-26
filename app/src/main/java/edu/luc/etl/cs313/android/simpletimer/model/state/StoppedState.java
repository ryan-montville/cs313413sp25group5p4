package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

class StoppedState implements TimerState {

    public StoppedState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onButtonClicked() {
        sm.actionStart();
        sm.actionResetThreeSecondCountdown();
        sm.actionAdd();
        sm.toCountdownDelayState();
    }

    @Override
    public void onTick() {
        throw new UnsupportedOperationException("onTick");
    }

    @Override
    public void updateView() {
        sm.updateUIRuntime();
    }

    @Override
    public int getId() {
        return R.string.STOPPED;
    }
}
