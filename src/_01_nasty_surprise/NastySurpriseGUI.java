package _01_nasty_surprise;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurpriseGUI implements ActionListener {
	
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton trick = new JButton();
	JButton treat = new JButton();
	JLabel picture = new JLabel();
	
	void run() {
		frame.setVisible(true);
		
		trick.setText("Trick");
		treat.setText("Treat");
		
		trick.addActionListener(this);
		treat.addActionListener(this);
		
		panel.add(trick);
		panel.add(treat);
		
		frame.add(panel);
		
		frame.pack();
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		JButton buttonPressed = (JButton) arg0.getSource();
		
		panel.remove(trick);
		panel.remove(treat);
		panel.add(picture);
		
		if (buttonPressed==trick) {
			showPictureFromTheInternet("https://www.allthingsdogs.com/wp-content/uploads/2019/05/Cute-Puppy-Names.jpg");
		}
		else {
			showPictureFromTheInternet("http://static-23.sinclairstoryline.com/resources/media/d60d4f1c-9fcc-4ae4-8058-05e885080e19-large16x9_momo2.PNG?1551379953599");
		}
	}
	
	private void showPictureFromTheInternet(String imageUrl) {
	    try {
	        URL url = new URL(imageUrl);
	        Icon icon = new ImageIcon(url);
	        JLabel imageLabel = new JLabel(icon);
	        JFrame frame = new JFrame();
	        frame.add(imageLabel);
	        frame.setVisible(true);
	        frame.pack();
	    } catch (MalformedURLException e) {
	        e.printStackTrace();
	    }
	}
}
