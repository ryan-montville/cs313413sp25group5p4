package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

/**
 * The CountdownDelayState class represents the initial delay period
 * before the timer starts running. This state is entered when the user
 * initiates the start action, providing countdown.
 * It implements the TimerState interface, defining the behavior
 * of the timer during this phase.
 */
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
        sm.actionResetThreeSecondCountdown();
        sm.actionAdd();
        sm.actionStart();
    }

    @Override
    public void onTick() {  sm.actionDecThreeSecondCountdown(); }
}
