package calculator;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.*;

public class Calculator {
	
	private JPanel content = new JPanel();
	private JTextField display = new JTextField();
	private GridBagLayout gb = new GridBagLayout();
	
	@SuppressWarnings("static-access")
	public Calculator() {
		content.setLayout(gb);
		Engine e = new Engine(this);
		
		//za display
		display.setFont(new Font("Calibri", Font.PLAIN, 30));
				GridBagConstraints gbc = new GridBagConstraints();
				gbc.gridx = 0;
				gbc.gridy = 0;
				gbc.gridheight = 1;
				gbc.gridwidth = 7;
				gbc.fill = gbc.BOTH;
				gbc.anchor = gbc.CENTER;
				gbc.weightx = 1.0;
				gbc.weighty = 1.0;
				
		gb.setConstraints(display, gbc);
		content.add(display);
		
		for (int i = 1; i <= 3; i++) {
			gbc = new GridBagConstraints();
			gbc.gridx = 0;
			gbc.gridwidth = 1;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.fill = gbc.BOTH;
			gbc.anchor = gbc.CENTER;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			
			JButton b = new JButton(Integer.toString(3*(i-1)+1));
			b.setBackground(Color.lightGray);
			b.setForeground(Color.black);
			b.setFont(new Font("Arial", Font.BOLD, 15));
			b.addActionListener(e);
			gb.setConstraints(b, gbc);
			content.add(b);
		}
		
		for (int i = 1; i <= 3; i++) {
			for (int j = 2; j <= 3; j++) {
				gbc = new GridBagConstraints();
				gbc.gridx = gbc.RELATIVE;
				gbc.gridwidth = 1;
				gbc.gridy = i;
				gbc.gridheight = 1;
				gbc.fill = gbc.BOTH;
				gbc.anchor = gbc.CENTER;
				gbc.weightx = 1.0;
				gbc.weighty = 1.0;
				
				JButton b = new JButton(Integer.toString(3*(i-1)+j));
				b.setBackground(Color.lightGray);
				b.setForeground(Color.black);
				b.setFont(new Font("Arial", Font.BOLD, 15));
				b.addActionListener(e);
				gb.setConstraints(b, gbc);
				content.add(b);
			}
		}
		String arr[] = new String[]{"0", ".", "="};
		String arr2[] = new String[] {"+", "-", "*", "/"};
		
		for (int i = 0; i < 3; i++) {
			gbc = new GridBagConstraints();
			gbc.gridx = i;
			gbc.gridwidth = 1;
			gbc.gridy = 4;
			gbc.gridheight = 1;
			gbc.fill = gbc.BOTH;
			gbc.anchor = gbc.CENTER;
			gbc.weightx = 1.0;
			gbc.weighty = 1.0;
			
			JButton b = new JButton(arr[i]);
			b.setBackground(Color.lightGray);
			b.setForeground(Color.black);
			b.setFont(new Font("Arial", Font.BOLD, 15));
			b.addActionListener(e);
			gb.setConstraints(b, gbc);
			content.add(b);
		}
		
		for (int i = 1; i <= 4; i++) {
			gbc = new GridBagConstraints();
			gbc.gridx = 3;
			gbc.gridwidth = 1;
			gbc.gridy = i;
			gbc.gridheight = 1;
			gbc.fill = gbc.BOTH;
			gbc.anchor = gbc.CENTER;
			gbc.weightx = 0.33;
			gbc.weighty = 1.0;
			
			JButton b = new JButton(arr2[i-1]);
			b.setBackground(Color.lightGray);
			b.setForeground(Color.black);
			b.setFont(new Font("Arial", Font.BOLD, 15));
			b.addActionListener(e);
			gb.setConstraints(b, gbc);
			content.add(b);
		}
		
		gbc = new GridBagConstraints();
		gbc.gridx = 2;
		gbc.gridwidth = 1;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.CENTER;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JButton b = new JButton("CLEAR");
		b.setBackground(Color.lightGray);
		b.setForeground(Color.black);
		b.setFont(new Font("Arial", Font.BOLD, 15));
		b.addActionListener(e);
		gb.setConstraints(b, gbc);
		content.add(b);
		
		gbc = new GridBagConstraints();
		gbc.gridx = gbc.RELATIVE;
		gbc.gridwidth = 1;
		gbc.gridy = 5;
		gbc.gridheight = 1;
		gbc.fill = gbc.BOTH;
		gbc.anchor = gbc.CENTER;
		gbc.weightx = 1.0;
		gbc.weighty = 1.0;
		
		JButton b2 = new JButton("BACK");
		b2.setBackground(Color.lightGray);
		b2.setForeground(Color.black);
		b2.setFont(new Font("Arial", Font.BOLD, 15));
		b2.addActionListener(e);
		gb.setConstraints(b2, gbc);
		content.add(b2);
		
		
		JFrame frame = new JFrame("Calculator");
		frame.setContentPane(content);
		frame.setSize(600, 300);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public String getDisplayValue() {
		return display.getText();
	}
	
	public void setDisplayValue(String value) {
		display.setText(value);
	}
	
	public static void main(String[] args) {
		new Calculator();
	}
}

