package _07_fortune_teller;
/*
 *    Copyright (c) The League of Amazing Programmers 2013-2019
 *    Level 1
 */


import java.util.Random;

import javax.swing.JOptionPane;

public class Magic8Ball {

	// 1. Make a main method that includes all the steps below….
	void ballOEight(String question) {
		
	// 2. Make a variable that will hold a random number and put a random number into this variable using "new Random().nextInt(4)"
	int rand = new Random().nextInt(4);
	// 3. Print out this variable
	System.out.println(rand);
	// 4. Get the user to enter a question for the 8 ball
	//
	// 5. If the random number is 0
	if (rand == 0) {
	// -- tell the user "Yes"
		JOptionPane.showMessageDialog(null, "Yes, certain it is");
	}
	else if (rand == 1) {
	// 6. If the random number is 1

	// -- tell the user "No"
		JOptionPane.showMessageDialog(null, "No, it must be this way");
	}
	else if (rand == 2) {
	// 7. If the random number is 2

	// -- tell the user "Maybe you should ask Google?"
		JOptionPane.showMessageDialog(null, "Certain, I can not be, thou shoult asketh \"Google\"");
	}
	else {
	// 8. If the random number is 3

	// -- write your own answer
		JOptionPane.showMessageDialog(null, "Je ne peux pas comprendre");
	}
	}
}
