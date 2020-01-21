package _11_whack_a_mole;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class WhackButton implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton mole = new JButton();
	Random rand = new Random();
	int molesHit = 0;
	Date startTime;
	int misses = 0;
	
	Dimension buttonSize = new Dimension(105 ,66);
	Dimension frameSize = new Dimension(450, 450);
	
	int moleIndex;
	
	void makeButtons() 
	{
		moleIndex = rand.nextInt(24);
		
		for (int i = 0; i < 24; i++) {
			if (i == moleIndex) {
				mole.addActionListener(this);
				System.out.println(i+1);
				panel.add(mole);
			}
			else {
				JButton temp = new JButton();
				temp.setPreferredSize(buttonSize);
				temp.addActionListener(this);
				panel.add(temp);
			}
		}
	}
	
	void make() 
	{	
		frame = new JFrame();
		frame.setVisible(true);
		frame.setTitle("Whack a Button");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mole = new JButton();
		panel = new JPanel();
		mole.setText("MOLE");
		mole.setPreferredSize(buttonSize);
		
		makeButtons();
		
		frame.add(panel);
		frame.setSize(frameSize);
	}
	
	
	void speak(String words) { 
	    try { 
	        Runtime.getRuntime().exec("say " + words).waitFor();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
	
	private void endGame(Date timeAtStart, int molesWhacked) { 
	    Date timeAtEnd = new Date();
	    JOptionPane.showMessageDialog(null, "Your whack rate is "
	            + ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWhacked)
	                  + " moles per second.");
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (molesHit == 0 && misses == 0) {
			startTime = new Date();
		}
		
		if (buttonPressed == mole) {
			System.out.println("got em");
			molesHit = molesHit + 1;
			if (molesHit > 9) {
				endGame(startTime, molesHit - 1);
				speak("Game over....");
				System.exit(0);
			}
		}
		
		else {
			//speak("Ya Missed!");
			System.out.println("Ya Missed");
			misses = misses + 1;
			if (misses > 4) {
				speak("You lost.... Have a nice day..");
				System.out.println("");
				System.out.println("You lost.... Have a nice day..");
				System.exit(1);
			}
		}
		
		System.out.println("");
		System.out.println("");
		frame.dispose();
		make();
		
	}
}
