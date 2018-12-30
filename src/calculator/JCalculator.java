package calculator;

import java.awt.*;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JCalculator extends JFrame {
	JButton reset = new JButton("CE");
	JTextField display= new JTextField("");
	
	private final String[] str = {
			"7","8","9","/",
			"4","5","6","*",
			"1","2","3","-",
			".","0","=","+"};
	
	JButton[] buttons = new JButton[str.length];
	
	public JCalculator() {
		JPanel pnlHead = new JPanel(new BorderLayout());
		JPanel pnlBody = new JPanel(new GridLayout(4,4));
		
		pnlHead.add(reset, BorderLayout.EAST);
		pnlHead.add(display,BorderLayout.CENTER);
		
		for(int i=0;i<str.length;i++) {
			buttons[i]= new JButton(str[i]);
			pnlBody.add(buttons[i]);
		}
		
		getContentPane().setLayout(new BorderLayout());
		getContentPane().add("Center",pnlBody);
		getContentPane().add("North",pnlHead);	
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setSize(300,280);
		
	}
	
	void addResetActionListener(ActionListener listenerForReset) {
		reset.addActionListener(listenerForReset);
	}
	
	void addButtonsListener(ActionListener listenerForButtons) {
		for(int i =0;i<str.length;i++) {
			buttons[i].addActionListener(listenerForButtons);
		}
		
	}

}
