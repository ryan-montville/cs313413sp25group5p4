package edu.luc.etl.cs313.android.simpletimer.common;

/**
 * A listener for UI update events.
 * This interface is typically implemented by the adapter, with the
 * events coming from the model.
 *
 * @author laufer
 */
public interface TimerModelListener {
    void onTimeUpdate(int timeValue); // called in order to update the runtime value on the UI
    void onStateUpdate(int stateId); // updates the current state (stooped, running, beeping)
}
