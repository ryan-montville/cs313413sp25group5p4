package edu.luc.etl.cs313.android.simpletimer.model;

import edu.luc.etl.cs313.android.simpletimer.common.TimerModelListener;
import edu.luc.etl.cs313.android.simpletimer.model.clock.ClockModel;
import edu.luc.etl.cs313.android.simpletimer.model.clock.DefaultClockModel;
import edu.luc.etl.cs313.android.simpletimer.model.state.DefaultTimerStateMachine;
import edu.luc.etl.cs313.android.simpletimer.model.state.TimerStateMachine;
import edu.luc.etl.cs313.android.simpletimer.model.time.DefaultTimeModel;
import edu.luc.etl.cs313.android.simpletimer.model.time.TimeModel;

/**
 * An implementation of the model facade.
 *
 * @author laufer
 */
public class ConcreteTimerModelFacade implements TimerModelFacade {

    private final TimerStateMachine stateMachine;

    private final ClockModel clockModel;

    private final TimeModel timeModel;

    public ConcreteTimerModelFacade() {
        timeModel = new DefaultTimeModel();
        clockModel = new DefaultClockModel();
        stateMachine = new DefaultTimerStateMachine(timeModel, clockModel);
        clockModel.setTickListener(stateMachine);
    }

    @Override
    public void start() {
        stateMachine.actionInit();
    }

    @Override
    public void setModelListener(final TimerModelListener listener) {
        stateMachine.setModelListener(listener);
    }

    @Override
    public void onButtonClicked() {
        stateMachine.onButtonClicked();
    }
}
