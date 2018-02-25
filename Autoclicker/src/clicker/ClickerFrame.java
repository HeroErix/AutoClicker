package clicker;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

public class ClickerFrame extends JFrame implements ActionListener {
	
	public static void main(String[] args) {
		ClickerFrame frame = new ClickerFrame();
		frame.setVisible(true);
	}

	private JTextField txtN;
	private JTextField txtInterval;
	private JButton btnStart;
	
	public ClickerFrame() {
		setTitle("Auto Clicker");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 150, 350, 200);
		JPanel contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Settings", TitledBorder.LEADING, 
				TitledBorder.TOP, null, null));
		panel.setBounds(10, 11, 168, 86);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNumberOfClicks = new JLabel("Number of Click(s)");
		lblNumberOfClicks.setBounds(21, 21, 94, 20);
		panel.add(lblNumberOfClicks);

		JLabel lblInterval = new JLabel("Interval");
		lblInterval.setBounds(21, 52, 94, 19);
		panel.add(lblInterval);

		txtN = new JTextField();
		txtN.setText("50");
		txtN.setBounds(119, 21, 33, 20);
		panel.add(txtN);
		txtN.setColumns(10);

		txtInterval = new JTextField();
		txtInterval.setText("100");
		txtInterval.setBounds(119, 51, 33, 20);
		panel.add(txtInterval);

		btnStart = new JButton("Start");
		btnStart.addActionListener( this );
		btnStart.setActionCommand( "Start" );
		btnStart.setBounds(188, 16, 89, 23);
		contentPane.add(btnStart);
		
		setProgressState( true );
	}
	
	void setProgressState( final boolean done ) {
		btnStart.setEnabled(done);
		txtInterval.setEditable(done);
		txtN.setEditable(done);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		if( arg0.getActionCommand().equals( "Start" ) ) {
			ClickerRobot clicker = new ClickerRobot( ClickerFrame.this,
						Integer.parseInt( "0" + txtN.getText().trim()),
						Integer.parseInt( "0" + txtInterval.getText().trim() ));
				
			JOptionPane.showMessageDialog( null, "Auto Click will start in 3 seconds.", "Warning", JOptionPane.WARNING_MESSAGE );
			ExecutorService executor = Executors.newCachedThreadPool();
			executor.execute(clicker);
		}
	}
}
