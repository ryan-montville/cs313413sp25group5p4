package edu.luc.etl.cs313.android.simpletimer.common;

/**
 * A listener for UI update events.
 * This interface is typically implemented by the adapter, with the
 * events coming from the model.
 *
 * @author laufer
 */
public interface TimerModelListener {
    void onTimeUpdate(int timeValue);
    void onStateUpdate(int stateId);
}
