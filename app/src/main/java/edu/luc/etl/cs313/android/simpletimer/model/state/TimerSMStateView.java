package edu.luc.etl.cs313.android.simpletimer.model.state;

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
    void toCountdownDelayState();
    void toBeepingState();

    // actions
    void actionInit();
    void actionReset();
    void actionAdd(); //to add seconds
    void actionStart();
    void actionStop();
    void actionDec();
    void actionUpdateView();
    void actionResetThreeSecondCountdown(); //reset countdown for starting timer
    void actionDecThreeSecondCountdown(); //lower countdown by 1
    // state-dependent UI updates
    void updateUIRuntime();
    Context getContext();
}
