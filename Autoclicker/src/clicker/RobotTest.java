package clicker;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

public class RobotTest {

	ClickerFrame frame = new ClickerFrame();
	ClickerRobot test = new ClickerRobot(frame, 10, 100);
	
	@Test
	public void testClicks() {
		test.run();
		assertEquals(test.testClicks,test.numClicks);
	}

	@Test
	public void testSetup() {
		frame.actionPerformed(new ActionEvent(test, 0, "Start"));
		assertNotNull(frame.clicker);
	}
}

