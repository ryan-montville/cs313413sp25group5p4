package edu.luc.etl.cs313.android.simpletimer.model.clock;

/**
 * A source of onTick events for the timer.
 * This interface is typically implemented by the model.
 *
 */
public interface TickSource {
    void setTickListener(TickListener listener);
}
