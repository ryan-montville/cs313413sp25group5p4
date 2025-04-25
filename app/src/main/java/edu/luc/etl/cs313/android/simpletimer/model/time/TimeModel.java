package edu.luc.etl.cs313.android.simpletimer.model.time;

/**
 * The passive data model of the stopwatch.
 * It does not emit any events.
 *
 * @author laufer
 */
public interface TimeModel {
    void resetRuntime();
    void restedCountdownTime();
    void incRuntime();
    int getRuntime();
    int getCountdownTime();
    void decRuntime();

    void decCountdownTime();
    boolean isTimeZero();
    boolean isCountdownZero();
}
