package newNotePad;

import java.awt.Font;

import javax.swing.JTabbedPane;

public class Format {
	MyGUI gui;
	Font arial, comicSansMS, timesNewRoman, serif, impact, tahoma, sansSerif, trebuchetMS , bold;
	String selectedFont;
	
	public Format(MyGUI gui) {
		this.gui = gui;
	}
	public void wordWrap() {
		
		if(gui.wordWrapOn == false) {
			
			gui.wordWrapOn = true;
			gui.TA.setLineWrap(true);
			gui.TA.setWrapStyleWord(true);
			gui.iWrap.setText("Word Wrap: On");
			
		}
		else if(gui.wordWrapOn == true) {
			
			gui.wordWrapOn = false;
			gui.TA.setLineWrap(false);
			gui.TA.setWrapStyleWord(false);
			gui.iWrap.setText("Word Wrap: Off");
		}
	}
	
	public void createFont(int fontSize) {
		
		arial = new Font("Arial", Font.PLAIN, fontSize);
		comicSansMS = new Font("Comic Sans MS", Font.PLAIN, fontSize);
		timesNewRoman = new Font("Times New Roman", Font.PLAIN, fontSize);
		serif = new Font("Serif", Font.PLAIN, fontSize);
		serif = new Font("Serif", Font.PLAIN, fontSize);
		impact = new Font("Impact", Font.PLAIN, fontSize);
		tahoma = new Font("Tahoma", Font.PLAIN, fontSize);
		sansSerif = new Font("Sans Serif", Font.PLAIN, fontSize);
		trebuchetMS = new Font("Trebuchet MS", Font.PLAIN, fontSize);
		bold = new Font("Bold", Font.BOLD, fontSize);

		
		setFont(selectedFont);
	}
	public void toggleBold() {
	    // Toggle bold
	    int currentStyle = gui.TA.getFont().getStyle();
	    int newStyle = (currentStyle ^ Font.BOLD);
	    gui.TA.setFont(gui.TA.getFont().deriveFont(newStyle));
	}
	public void toggleItalic() {
	    // Toggle italic
	    int currentStyle = gui.TA.getFont().getStyle();
	    int newStyle = (currentStyle ^ Font.ITALIC);
	    gui.TA.setFont(gui.TA.getFont().deriveFont(newStyle));
	}
	/*public void createTab() {
		 JTabbedPane tabbedPane;
		    int tabIndex = 1;

	}*/
	
	
	
	public void setFont(String font) {
		//gui.format.setSize(50,70);
		//gui.SP = new JScrollPane(gui.TA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		selectedFont = font;
		
		switch(selectedFont) {
		case"Arial":
			gui.TA.setFont(arial);
			break;
		case"Comic Sans MS":
			gui.TA.setFont(comicSansMS); 
			break;
		case"Times New Roman":
			gui.TA.setFont(timesNewRoman);
			break;
		case"Serif":
			gui.TA.setFont(serif);
			break;
		case"Impact":
			gui.TA.setFont(impact);
			break;
		case"Tahoma":
			gui.TA.setFont(tahoma);
			break;
		case"Sans Serif":
			gui.TA.setFont(sansSerif);
			break;
		case"Trebuchet MS":
			gui.TA.setFont(trebuchetMS);
			break;
		}
	}
}
