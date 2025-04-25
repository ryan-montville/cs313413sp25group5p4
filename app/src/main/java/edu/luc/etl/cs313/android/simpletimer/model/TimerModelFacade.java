package edu.luc.etl.cs313.android.simpletimer.model;

import edu.luc.etl.cs313.android.simpletimer.common.Startable;
import edu.luc.etl.cs313.android.simpletimer.common.TimerUIListener;

/**
 * A thin model facade. Following the Facade pattern,
 * this isolates the complexity of the model from its clients (usually the adapter).
 *
 * @author laufer
 */
public interface TimerModelFacade extends Startable, TimerUIListener, StopwatchModelSource { }
