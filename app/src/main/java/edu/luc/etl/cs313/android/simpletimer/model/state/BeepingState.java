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

    @Override
    public void updateView() { sm.updateUIRuntime(); }

    @Override
    public int getId() {
        return R.string.BEEPING;
    }

    @Override
    public void onButtonClicked() {
        sm.actionStop();
        sm.toStoppedState();
    }
    @Override
    public void onTick() {
        System.out.println("Beeping state onTick");
        sm.actionBeep();
        sm.toBeepingState();
    }
}
