package clicker;

import static org.junit.Assert.*;

import java.awt.event.ActionEvent;

import org.junit.Test;

public class RobotTest {

	@Test
	public void test() {
		ClickerFrame frame = new ClickerFrame();
		ClickerRobot test = new ClickerRobot(frame, 10, 100);
		test.run();
		assertEquals(test.testClicks,test.numClicks);
	}

}
