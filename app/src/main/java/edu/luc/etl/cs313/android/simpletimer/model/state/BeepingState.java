package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

        /** The BeepingState class represents the state of the timer when it is emitting a beep sound.
        * This state is entered when the timer reaches zero.
        * It implements the {@link TimerState} interface, defining the behavior of the timer in this specific state.
        */
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
    /**
     * Updates the user interface to reflect runtime.
     * This method is called periodically, to ensure the UI remains consistent.
     **/
    @Override
    public void updateView() { sm.updateUIRuntime(); }

    /**
     * accessor that returns the resource ID of the string associated with the Beeping state.
     *
     * @return The resource ID for the string "BEEPING".
     **/
    @Override
    public int getId() {
        return R.string.BEEPING;
    }


    /**
    * Handles button clicks while the timer is in the beeping state.
    * Clicking the button triggers the 'stop' action and transitions the timer to the StoppedState.
    **/
    @Override
    public void onButtonClicked() {
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
        System.out.println("Beeping state onTick");
        sm.actionBeep();
        sm.toBeepingState();
    }
}
