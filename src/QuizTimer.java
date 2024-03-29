
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.*;
import java.awt.*;

public class QuizTimer extends JFrame {
	static int counter = 60;
    static Boolean isIt = false;
    static Timer timer;
    
	public QuizTimer() {
		setTitle("Timer");
		System.out.println("Timer Started!");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblTimeL = new JLabel("Time Left:");
		lblTimeL.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTimeL.setBounds(10, 11, 69, 27);
		getContentPane().add(lblTimeL);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(89, 11, 172, 27);
		getContentPane().add(lblNewLabel);
		
		timer = new Timer();
        TimerTask task = new TimerTask() {         
            public void run() {     
            	
            	// CONVERTS THE TIME TO SECONDS
            	int timet = 1 * 60; 
			    long delay = timet * 1000;
			    do
			    {
			      int minutes = timet / 60;
			      int seconds = timet % 60;
			      lblNewLabel.setText(minutes +" minute(s), " + seconds + " second(s)");
			      try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			      timet = timet - 1;
			      delay = delay - 1000;

			    }
			    while (delay != 0);
			    JOptionPane.showMessageDialog(null, "Times Up!", "Warning", JOptionPane.ERROR_MESSAGE);
			    dispose();
            }
        };
        timer.scheduleAtFixedRate(task, 1000, 1000);
		
		setSize(267, 92);
		setLocation(300, 300);
		setVisible(true);
	}
}