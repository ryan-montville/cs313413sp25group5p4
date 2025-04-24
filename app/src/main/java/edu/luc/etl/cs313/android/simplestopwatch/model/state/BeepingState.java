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
        //still needs to be done
        //should turn off the alarm/reset
    }

    @Override
    public void onTick() {
        //still needs to be done
        //starts alarm (?)
    }
}
