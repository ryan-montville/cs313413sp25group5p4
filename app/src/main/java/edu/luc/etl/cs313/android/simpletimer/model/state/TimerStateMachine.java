package edu.luc.etl.cs313.android.simpletimer.model.state;

import edu.luc.etl.cs313.android.simpletimer.common.TimerModelSource;
import edu.luc.etl.cs313.android.simpletimer.common.TimerUIListener;
import edu.luc.etl.cs313.android.simpletimer.model.clock.TickListener;

/**
 * The state machine for the state-based dynamic model of the timer.
 * This interface is part of the State pattern.
 */
public interface TimerStateMachine extends TimerUIListener, TickListener, TimerModelSource, TimerSMStateView { }


