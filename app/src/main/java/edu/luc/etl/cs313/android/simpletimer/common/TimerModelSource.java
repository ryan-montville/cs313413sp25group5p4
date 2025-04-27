package edu.luc.etl.cs313.android.simpletimer.common;

/**
 * A source of UI update events for the timer.
 * This interface is typically implemented by the model.
 *
 */
public interface TimerModelSource {
    /**
     * This registers a TimerModelListener to recevie updates from the model 
     * @param listener the listener that will recevie time and state updates
     */
    void setModelListener(TimerModelListener listener);
}
