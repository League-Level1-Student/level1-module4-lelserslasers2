package _12_slot_machine;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class SlotMachine implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel slotOne = new JLabel();
	JLabel slotTwo = new JLabel();
	JLabel slotThree = new JLabel();
	JButton spinButton = new JButton();
	Dimension slotSize = new Dimension(200,200);
	Dimension buttonSize = new Dimension(125,75);
	
	void run() {
		frame.setTitle("Slot Machine");
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		spinButton.setText("SPIN");
		spinButton.addActionListener(this);
		
		slotOne.setPreferredSize(slotSize);
		slotTwo.setPreferredSize(slotSize);
		slotThree.setPreferredSize(slotSize);
		spinButton.setPreferredSize(buttonSize);
		
		
		panel.add(slotOne);
		panel.add(slotTwo);
		panel.add(slotThree);
		panel.add(spinButton);
		frame.add(panel);
		frame.pack();
	
	}
	
	void spin() throws MalformedURLException {
		System.out.println("SPINING!");
		Random randy = new Random();
		int slotImageOne = randy.nextInt(3);
		int slotImageTwo = randy.nextInt(3);
		int slotImageThree = randy.nextInt(3);
		frame.remove(panel);
		panel = new JPanel();
		
		JLabel lemon = createLabelImage("lemon.jpg");
		JLabel lime = createLabelImage("lime.png");
		JLabel orange = createLabelImage("orange.jpeg");
		JLabel lemon2 = createLabelImage("lemon.jpg");
		JLabel lime2 = createLabelImage("lime.png");
		JLabel orange2 = createLabelImage("orange.jpeg");
		JLabel lemon3 = createLabelImage("lemon.jpg");
		JLabel lime3 = createLabelImage("lime.png");
		JLabel orange3 = createLabelImage("orange.jpeg");
		
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (slotImageOne == 0) {
			panel.add(lemon);
		}
		else if (slotImageOne == 1) {
			panel.add(lime);
		}
		else {
			panel.add(orange);
		}
		
		
		if (slotImageTwo == 0) {
			panel.add(lemon2);
		}
		else if (slotImageTwo == 1) {
			panel.add(lime2);
		}
		else {
			panel.add(orange2);
		}
		
		
		if (slotImageThree == 0) {
			panel.add(lemon3);
		}
		else if (slotImageThree == 1) {
			panel.add(lime3);
		}
		else {
			panel.add(orange3);
		}
		
		
		panel.add(spinButton);
		frame.add(panel);
		frame.pack();
		
		System.out.println("SPUN");
		if (slotImageOne == slotImageTwo && slotImageOne == slotImageThree) {
			JOptionPane.showMessageDialog(null, "YOU WIN");
		}
		else {
			JOptionPane.showMessageDialog(null, "YOU LOSE");
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			spin();
		} catch (MalformedURLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	
}
