package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.R;

public class BeepingState implements TimerState {

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
