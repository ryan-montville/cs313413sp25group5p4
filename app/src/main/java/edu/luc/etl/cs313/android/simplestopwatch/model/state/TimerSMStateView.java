package edu.luc.etl.cs313.android.simplestopwatch.model.state;

/**
 * The restricted view states have of their surrounding state machine.
 * This is a client-specific interface in Peter Coad's terminology.
 *
 * @author laufer
 */
interface TimerSMStateView {

    // transitions
    void toRunningState();
    void toStoppedState();
    void toCountdownState();
    void toBeepingState();

    // actions
    void actionInit();
    void actionReset();
    void actionAdd(); //to add seconds
    void actionStart();
    void actionStop(); //unnecessary now? just reset
    void actionDec();
    void actionUpdateView();

    // state-dependent UI updates
    void updateUIRuntime();
}
