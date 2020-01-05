package _04_chuckle_clicker;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton buttonJoke;
	JButton buttonLine;
	
	void run() {
		
	}
	
	void MakeButtons() {
		buttonJoke = new JButton();
		buttonLine = new JButton();
		
		buttonJoke.setText("Joke");
		buttonLine.setText("Line");
		
		JOptionPane.showMessageDialog(null, "Made buttons");
		
		buttonJoke.addActionListener(this);
		buttonLine.addActionListener(this);
		
		panel.add(buttonJoke);
		panel.add(buttonLine);
		
		frame.add(panel);
		frame.setVisible(true);
		frame.pack();
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();

		/* If the buttonPressed was the leftButton.... */
		if (buttonPressed==buttonJoke) {
			JOptionPane.showMessageDialog(null, "Find a better joke for me.");
		}
		else {
			JOptionPane.showMessageDialog(null, "No U!");
		}
			
	}
	
}
