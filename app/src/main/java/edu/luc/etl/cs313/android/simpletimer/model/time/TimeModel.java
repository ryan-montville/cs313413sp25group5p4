package edu.luc.etl.cs313.android.simpletimer.model.time;

/**
 * The passive data model of the timer.
 * It does not emit any events.
 *
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
