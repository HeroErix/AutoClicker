package clicker;

import java.awt.Robot;
import java.awt.event.InputEvent;

import javax.swing.JOptionPane;

public class ClickerRobot implements Runnable {
	
	int numClicks;
	private int clickInterval;
	private Robot robot;
	private ClickerFrame clickerFrame;
	int testClicks = 0;
	
	public ClickerRobot( ClickerFrame clickerFrame, int numClicks, int clickInterval ) {
		try {
			robot = new Robot();
			
			this.numClicks = numClicks;
			this.clickInterval = clickInterval;
			this.clickerFrame = clickerFrame;
		} catch( Exception e ) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		try {
			clickerFrame.setProgressState(false);
			Thread.sleep(3000);

			for( int i=0; i<numClicks; i++ ) {
				robot.mousePress(InputEvent.BUTTON1_MASK);
				robot.mouseRelease(InputEvent.BUTTON1_MASK);
				testClicks++;
				Thread.sleep(clickInterval);
			}
			
			clickerFrame.setProgressState(true);
			JOptionPane.showMessageDialog(null, "Done.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}		
	}

}
