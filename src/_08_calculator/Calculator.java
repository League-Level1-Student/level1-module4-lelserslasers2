package _08_calculator;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.sun.xml.internal.ws.org.objectweb.asm.Label;

public class Calculator implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JLabel output;
	JTextField leftNum;
	JTextField rightNum;
	JButton mul;
	JButton div;
	JButton add;
	JButton sub;
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		output = new JLabel();
		leftNum = new JTextField(20);
		rightNum = new JTextField(20);
		mul = new JButton("Multiply");
		div = new JButton("Divide");
		add = new JButton("Add");
		sub = new JButton("Subtract");
		
		Dimension STACK =  new Dimension(510,510);
		frame.setPreferredSize(STACK);
	
		Dimension BUTTON = new Dimension(115,20);
		mul.setPreferredSize(BUTTON);
		div.setPreferredSize(BUTTON);
		add.setPreferredSize(BUTTON);
		sub.setPreferredSize(BUTTON);
		
		
		mul.addActionListener(this);
		div.addActionListener(this);
		add.addActionListener(this);
		sub.addActionListener(this);
		
		frame.setTitle("Calculator");
		
		panel.add(leftNum);
		panel.add(rightNum);
		panel.add(add);
		panel.add(sub);
		panel.add(mul);
		panel.add(div);
		panel.add(output);
		
		frame.setVisible(true);
		frame.add(panel);
		frame.pack();
	}
	
	void mul() {
		output.setText(Integer.toString((Integer.parseInt(leftNum.getText()) * Integer.parseInt(rightNum.getText()))));
	}
	
	void div() {
		
	}
	
	void add() {
		
	}
	
	void sub() {
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == mul) {
			mul();
		}
		
	}
}
