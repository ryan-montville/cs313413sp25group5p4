package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class BeepingState implements TimerState {

    public BeepingState(final TimerSMStateView sm) { this.sm = sm; }

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
        sm.actionStart();
        updateView();

    }
}
