package newNotePad;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.print.PrinterException;

public class Keyhandler implements KeyListener {
	
	MyGUI gui;
	
	public Keyhandler(MyGUI gui) {
		this.gui = gui;
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.save();
		}
		if (e.isShiftDown()&& e.isControlDown() && e.getKeyCode() == KeyEvent.VK_S) {
			gui.file.saveAs();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_N) {
			gui.file.newFile();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_Z) {
			gui.edit.undo();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_W) {
			gui.format.wordWrap();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_B) {
			gui.format.toggleBold();
		}
		if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_I) {
			gui.format.toggleItalic();
		}
		 if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_P) {
	            printAction();
		 }
		
		
		
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	public void printAction() {
        try {
            gui.TA.print();
        } catch (PrinterException ex) {
            ex.printStackTrace();
        }
	}	

}
