package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class Engine implements ActionListener {
	
	private Calculator parent;

	public Engine(Calculator parent) {
		super();
		this.parent = parent;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton clickedButton = (JButton) e.getSource();
		String clickedButtonLabel = clickedButton.getText();
		
		String displayText = parent.getDisplayValue();
		if (clickedButtonLabel == "CLEAR") parent.setDisplayValue(null);
		else if (clickedButtonLabel == "BACK") {
			StringBuilder sb = new StringBuilder();
			sb.append(displayText);
			sb.deleteCharAt(displayText.length()-1);
			displayText = sb.toString();
			parent.setDisplayValue(displayText);
		}
		else if (clickedButtonLabel != "=") parent.setDisplayValue(displayText + clickedButtonLabel);
		
		else {
			String[] s = displayText.split("");
			List<String> l = new ArrayList<>();
			int cnt = 0;
			for (int i = 0; i < s.length; i++) {
				if (displayText.charAt(i) >= '0' && displayText.charAt(i) <= '9' || displayText.charAt(i) == '.') {
					while (cnt >= l.size()) l.add(null);
					if (l.get(cnt) == null) l.set(cnt, s[i]);
					else l.set(cnt, l.get(cnt)+s[i]);
				}
				else {
					l.add(s[i]);
					cnt+=2;
				}
			}
			
			while (l.contains("*") || l.contains("/")) {
			for (int i = 0; i < l.size(); i++) {
				if (l.get(i).equals("*")) {
					Double num = Double.parseDouble(l.get(i-1))*Double.parseDouble(l.get(i+1));
					l.set(i, num.toString());
					l.remove(i+1);
					l.remove(i-1);
				}
				else if (l.get(i).equals("/")) {
					Double num = Double.parseDouble(l.get(i-1))/Double.parseDouble(l.get(i+1));
					l.set(i, num.toString());
					l.remove(i+1);
					l.remove(i-1);
				}
				
			}
			}
			
			while (l.size() > 1) {
				for (int i = 0; i < l.size(); i++) {
					if (l.get(i).equals("+")) {
						Double num = Double.parseDouble(l.get(i-1))+Double.parseDouble(l.get(i+1));
						l.set(i, num.toString());
						l.remove(i+1);
						l.remove(i-1);
					}
					else if (l.get(i).equals("-")) {
						Double num = Double.parseDouble(l.get(i-1))-Double.parseDouble(l.get(i+1));
						l.set(i, num.toString());
						l.remove(i+1);
						l.remove(i-1);
					}
					
				}
			}
			
			parent.setDisplayValue(l.getFirst());
			
		} 
		
	} 

} 
