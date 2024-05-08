package newNotePad;

import java.awt.Color;

public class FColor {

	MyGUI gui;
	
	public FColor(MyGUI gui) {
		this.gui = gui;
	}
	public void ChangeColor(String color) {
		
		switch(color) {
		case"White":
			gui.window.getContentPane().setBackground(Color.white);
			gui.TA.setBackground(Color.white);
			gui.TA.setForeground(Color.black);
			break;
			
		case"Black":
			gui.window.getContentPane().setBackground(Color.black);
			gui.TA.setBackground(Color.black);
			gui.TA.setForeground(Color.green);
			break;
			
		case"Blue":
			gui.window.getContentPane().setBackground(Color.blue);
			gui.TA.setBackground(Color.blue);
			gui.TA.setForeground(Color.black);
			break;
			
		case"Green":
			gui.window.getContentPane().setBackground(Color.green);
			gui.TA.setBackground(Color.green);
			gui.TA.setForeground(Color.black);
			break;
			
		case"Red":
			gui.window.getContentPane().setBackground(Color.red);
			gui.TA.setBackground(Color.red);
			gui.TA.setForeground(Color.black);
			break;
			
		case"Yellow":
			gui.window.getContentPane().setBackground(Color.yellow);
			gui.TA.setBackground(Color.yellow);
			gui.TA.setForeground(Color.black);
			break;
			
		case"Cyan":
			gui.window.getContentPane().setBackground(Color.cyan);
			gui.TA.setBackground(Color.cyan);
			gui.TA.setForeground(Color.black);
			break;
		}
		
	}
}
