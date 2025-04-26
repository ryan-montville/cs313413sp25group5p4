package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

/* This file deals with the state when the timer is stopepd at zero
 * allows incrementing time before starting countdown 
*/

class StoppedState implements TimerState {

    public StoppedState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;

    @Override
    public void onButtonClicked() {
        // the start of a 3 second countdown delay and add 1 second to timer
        sm.actionStart();
        sm.actionResetThreeSecondCountdown();
        sm.actionAdd();
        sm.toCountdownDelayState();
    }

    @Override
    public void onTick() {
        // should never receive ticks while stopped
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
