package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

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
       sm.actionResetThreeSecondCountdown();
    }

    @Override
    public void onTick() {
       sm.actionDecThreeSecondCountdown();
       if(sm.getThreeSecondCountdown() <= 0) {
           sm.toRunningState();
       } else {
        updateView();
       }
    }
}
