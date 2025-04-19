package edu.luc.etl.cs313.android.simplestopwatch.model;

import edu.luc.etl.cs313.android.simplestopwatch.common.Startable;
import edu.luc.etl.cs313.android.simplestopwatch.common.StopwatchModelSource;
import edu.luc.etl.cs313.android.simplestopwatch.common.TimerUIListener;

/**
 * A thin model facade. Following the Facade pattern,
 * this isolates the complexity of the model from its clients (usually the adapter).
 *
 * @author laufer
 */
public interface TimerModelFacade extends Startable, TimerUIListener, StopwatchModelSource { }
