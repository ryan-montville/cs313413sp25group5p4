package edu.luc.etl.cs313.android.simplestopwatch.model.state;

import edu.luc.etl.cs313.android.simplestopwatch.R;

public class CountdownDelayState implements TimerState {

    public CountdownDelayState(final StopwatchSMStateView sm) {
        this.sm = sm;
    }

    private final StopwatchSMStateView sm;
    @Override
    public void updateView() { sm.updateUIRuntime(); }

    @Override
    public int getId() {
        return R.string.THREE_SECOND_COUNTDOWN;
    }

    @Override
    public void onButtonClicked() {
        //still needs to be done
        //should restart the 3 second countdown
    }

    @Override
    public void onTick() {
        //still needs to be done
        //counts down the 3 seconds
    }
}
