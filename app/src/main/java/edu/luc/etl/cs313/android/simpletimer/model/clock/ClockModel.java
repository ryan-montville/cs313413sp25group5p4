package edu.luc.etl.cs313.android.simpletimer.model.clock;

import edu.luc.etl.cs313.android.simpletimer.common.Startable;
import edu.luc.etl.cs313.android.simpletimer.common.Stoppable;

/**
 * The active model of the internal clock that periodically emits tick events.
 *
 * @author laufer
 */
public interface ClockModel extends Startable, Stoppable, TickSource { }
