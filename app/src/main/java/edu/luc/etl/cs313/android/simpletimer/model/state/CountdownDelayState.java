package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

/* This state during the 3 second countdown before the timer */

/**
 * The CountdownDelayState class represents the initial delay period
 * before the timer starts running. This state is entered when the user
 * initiates the start action, providing countdown.
 * It implements the TimerState interface, defining the behavior
 * of the timer during this phase.
 */
public class CountdownDelayState implements TimerState {
    /**
     * Constructor for CountdownDelayState instance.
     *
     * @param sm The state machine view associated with this state.
     */
    public CountdownDelayState(final TimerSMStateView sm) {
        this.sm = sm;
    }

    private final TimerSMStateView sm;
    @Override
    public void updateView() { sm.updateUIRuntime(); }

    @Override
    public int getId() {
        return R.string.THREE_SECOND_COUNTDOWN;
    } //Return the ID representing  the 3 second countdown stat for the UI display

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.actionResetThreeSecondCountdown();
        sm.actionAdd();
        sm.actionStart();
    }

    @Override
    public void onTick() {  
        //each tick during countdown -> decrement the 3 second countdown timer
        sm.actionDecThreeSecondCountdown(); 
    }
}
