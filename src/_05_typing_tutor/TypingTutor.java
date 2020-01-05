package _05_typing_tutor;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	
	char currentLetter = generateRandomLetter();
	JFrame frame = new JFrame();
	JLabel label = new JLabel();
	
	void start() {
		frame.setTitle("Type or Die");
		
		letChan();
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		frame.add(label);
		frame.setSize(500, 500);
		frame.addKeyListener(this);
		
		frame.setVisible(true);
		frame.pack();
	}
	
	void letChan() {
		currentLetter = generateRandomLetter();
		label.setText(Character.toString(currentLetter));
	}
	
	
	char generateRandomLetter() {
	    Random r = new Random();
	    return (char) (r.nextInt(26) + 'a');
	}


	@Override
	public void keyTyped(KeyEvent e) {
		
		
	}


	@Override
	public void keyPressed(KeyEvent e) {
		System.out.print("You pressed: " + e.getKeyChar());
		if (e.getKeyChar() == currentLetter) {
			
			System.out.println(", Correct");
			frame.setBackground(Color.green);
		}
		else {
			System.out.println(", Wrong");
			frame.setBackground(Color.red);
		}
		
		frame.pack();
		
		
	}


	@Override
	public void keyReleased(KeyEvent e) {
		letChan();
		
	}
	
}
