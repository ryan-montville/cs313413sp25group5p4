package edu.luc.etl.cs313.android.simpletimer.test.model;

import org.junit.After;
import org.junit.Before;

import edu.luc.etl.cs313.android.simpletimer.model.clock.DefaultClockModel;

/**
 * Concrete testcase subclass for the default clock model implementation.
 *
 * @author laufer
 * @see http://xunitpatterns.com/Testcase%20Superclass.html
 */
public class DefaultClockModelTest extends AbstractClockModelTest {

    @Before
    public void setUp() throws Exception {
        setModel(new DefaultClockModel());
    }

    @After
    public void tearDown() throws Exception {
        setModel(null);
    }
}
