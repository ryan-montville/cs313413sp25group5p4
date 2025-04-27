package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

public class BeepingState implements TimerState {
    /**
     * Constructor for BeepingState instance.
     *
     * @param sm The state machine view associated with this state.
     */
    public BeepingState(final TimerSMStateView sm) {
        this.sm = sm;
    }
    private final TimerSMStateView sm;

    @Override
    public void updateView() { sm.updateUIRuntime(); }

    /**
     * accessor that returns the resource ID of the string associated with the Beeping state.
     *
     * @return The resource ID for the string "BEEPING".
     **/
    @Override
    public int getId() {
        //return the ID representing the Beeping State for the UI display
        return R.string.BEEPING;
    }


    /**
    * Handles button clicks while the timer is in the beeping state.
    * Clicking the button triggers the 'stop' action and transitions the timer to the StoppedState.
    **/
    @Override
    public void onButtonClicked() {
        /* if button is pressed while beeping
         * stop clock ticking and go to stopped state
        */
        sm.actionStop();
        sm.toStoppedState();
    }
    /**
    * Handles timer tick while the timer is in the beeping state.
    * On each tick this method triggers the 'beep' action
    * and ensures the state remains in the BeepingState to continue the sound.
    **/
    @Override
    public void onTick() {
        //keep beeping each tick and stay in the Beeping state
        sm.actionBeep();
        sm.toBeepingState();
    }
}
