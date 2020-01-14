package _09_latest_tweet;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class tweeter implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JTextField txtfil;
	JButton button;
	JLabel output;
	String formater;
	
	Dimension txtsize = new Dimension(250,20);
	Dimension framesize = new Dimension(510,600);
	
	void run() {
		frame = new JFrame();
		panel = new JPanel();
		txtfil = new JTextField();
		button = new JButton();
		output = new JLabel();
		
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		button.setText("Search Twitter");
		frame.setTitle("Twitter Searcher");
		
		button.addActionListener(this);
		txtfil.setPreferredSize(txtsize);
		button.setPreferredSize(txtsize);
		
		frame.setPreferredSize(framesize);
		
		panel.add(txtfil);
		panel.add(button);
		panel.add(output);
		frame.add(panel);
		
		frame.pack();
	}
	
	private String getLatestTweet(String searchingFor) {

	      Twitter twitter = new TwitterFactory().getInstance();

	      AccessToken accessToken = new AccessToken(
	            "2453751158-IVD2VGZsvwZiRKxNe3Gs2lMjg30nvSkV1xSuPFf",
	            "vBa5PjKfuMTK1LLBG51nCUI9r5d6Ph5cAHrS73spg6Nvu");

	      twitter.setOAuthConsumer("YqeZdD2hYxOKv4QOkmp0i2djN",
	            "6XUB1r8KXBvd8Pk9HHW3NgphMxHvHWBLAr5TihnckMU0ttyGST");

	      twitter.setOAuthAccessToken(accessToken);

	      Query query = new Query(searchingFor);
	      try {
	            QueryResult result = twitter.search(query);
	            return result.getTweets().get(0).getText();
	      } catch (Exception e) {
	            System.err.print(e.getMessage());
	            return "What the heck is that?";
	      }
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("Tweet, Tweet");
		output.setText("Searching...");
		frame.pack();
		
		output.setText("<html>" + getLatestTweet(txtfil.getText()) + "</html>");
		
		String hold = (getLatestTweet(txtfil.getText()));
		formater = hold;
		String lastTxtFil = txtfil.getText();
		String addedStr = "";
		txtfil.setText(formater);
		
		int stu = 25;
		
		int lengths = formater.length();
		//lengths = lengths/30;
		
		int counte = 0;
		for (int i = 0; i < lengths/stu; i = i + 1) {
			
			if (counte+stu < lengths) {
				
				
			try {
				formater = txtfil.getText(counte, stu);
			} catch (BadLocationException e1) {
				System.out.println("bruh");
				e1.printStackTrace();
			}
			
			addedStr = addedStr  + "\n" + formater;
			output.setText(addedStr);
			}
			else if (counte < lengths) {
				
				try {
					formater = txtfil.getText(counte, lengths-counte);
				} catch (BadLocationException e1) {
					System.out.println("bruh");
					e1.printStackTrace();
				}
			}
			
			counte = counte + stu;
		}
		System.out.println(formater);
		System.out.println(lengths);
		System.out.println(addedStr);
		System.out.println("");
		System.out.println(hold);
		//output.setText(formater);
		
		txtfil.setText(lastTxtFil);
		frame.pack();
		
	}
	
}
