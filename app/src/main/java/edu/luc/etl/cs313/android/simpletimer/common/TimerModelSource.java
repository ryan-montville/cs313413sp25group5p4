package edu.luc.etl.cs313.android.simpletimer.common;

/**
 * A source of UI update events for the stopwatch.
 * This interface is typically implemented by the model.
 *
 * @author laufer
 */
public interface TimerModelSource {
    void setModelListener(TimerModelListener listener);
}
