package _10_pig_latin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatin implements ActionListener {
		
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JTextField english = new JTextField(20);
	JButton translate = new JButton();
	JTextField latin = new JTextField(20);
	PigLatinTranslator plt = new PigLatinTranslator();
	
	void run()
	{
		frame.setTitle("English to Pig Latin");
		translate.setText("Translate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		translate.addActionListener(this);
		
		panel.add(english);
		panel.add(translate);
		panel.add(latin);
		frame.add(panel);
		
		frame.setVisible(true);
		frame.pack();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		latin.setText(plt.translate(english.getText()));
		
	}
}



