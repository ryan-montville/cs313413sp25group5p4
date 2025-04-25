package edu.luc.etl.cs313.android.simpletimer.test.model;

import org.junit.After;
import org.junit.Before;

import edu.luc.etl.cs313.android.simpletimer.model.state.DefaultTimerStateMachine;

/**
 * Concrete testcase subclass for the default stopwatch state machine
 * implementation.
 *
 * @author laufer
 * @see http://xunitpatterns.com/Testcase%20Superclass.html
 */
public class DefaultTimerStateMachineTest extends AbstractTimerStateMachineTest {

    @Before
    public void setUp() throws Exception {
        super.setUp();
        setModel(new DefaultTimerStateMachine(getDependency(), getDependency()));
    }

    @After
    public void tearDown() {
        setModel(null);
        super.tearDown();
    }
}
