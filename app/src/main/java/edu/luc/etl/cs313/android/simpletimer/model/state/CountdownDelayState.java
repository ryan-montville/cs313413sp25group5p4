package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

public class CountdownDelayState implements TimerState {

    public CountdownDelayState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;
    @Override
    public void updateView() { sm.updateUIRuntime(); }

    @Override
    public int getId() {
        return R.string.THREE_SECOND_COUNTDOWN;
    }

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.actionAdd();
        sm.actionResetThreeSecondCountdown();
        sm.actionStart();
    }

    @Override
    public void onTick() {  sm.actionDecThreeSecondCountdown(); }
}
