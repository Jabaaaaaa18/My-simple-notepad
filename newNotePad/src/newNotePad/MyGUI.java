package newNotePad;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class MyGUI implements ActionListener{
	JFrame window;
	JTextArea TA;
	JScrollPane SP;
	boolean wordWrapOn = false;
	JMenuBar MB;
	JMenu MenuFile, MenuEdit, MenuFormat, MenuColor;
	JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
	JMenuItem iWrap, iFontArial, iFontCSMS, iFontSerif, iFontImpact, iFontTahoma, iFontSansSerif, iFonttrebuchetMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
	JMenu MenuFont, MenuFontSize;
	JMenuItem iColor1, iColor2, iColor3, iColor4, iColor5, iColor6, iColor7;
	JMenuItem iUndo, iRedo;
	Function_File file = new Function_File(this);	
	Format format = new Format(this);
	FColor iColor = new FColor(this);
	UndoManager UM = new UndoManager();
	fEdit edit = new fEdit(this);
	Keyhandler KH = new Keyhandler(this);

	public static void main(String[] args) {
		new MyGUI();
	}
	public MyGUI(){
		createWindow();
		createTextArea();
		createMenuBar();
		createFileMenu();
		createFormatMenu();
		createColorMenu();
		createEditMenu();
		
		format.selectedFont = "Arial";
		format.createFont(16);
		format.wordWrap();
		iColor.ChangeColor("White");
		/*format.selectedFont = "Cosmic Sans MS";	
		format.createFont(16);
		format.wordWrap();
		format.selectedFont = "Time New Roman";
		format.createFont(16);
		format.wordWrap();*/

		
		window.setVisible(true);
		
	}
	public void createWindow() {
		window = new JFrame("Notepad");
		//SP.setBackground(Color.BLACK);
		//window.setColor(Color.BLACK);
		//window.set
		window.setSize(1000, 500);
		window.setResizable(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	public void createTextArea() {
		TA = new JTextArea();
		
		TA.addKeyListener(KH);
		TA.getDocument().addUndoableEditListener(
				new UndoableEditListener() {

					@Override
					public void undoableEditHappened(UndoableEditEvent e) {
						UM.addEdit(e.getEdit());
						}
					
				});
		SP = new JScrollPane(TA, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		SP.setBorder(BorderFactory.createEmptyBorder());
		window.add(SP);
		}
	public void createMenuBar() {
		MB = new JMenuBar();
		window.setJMenuBar(MB);
		
		MenuFile = new JMenu("File");
		MB.add(MenuFile);
		
		MenuEdit = new JMenu("Edit");
		MB.add(MenuEdit);
		
		MenuFormat = new JMenu("Format");
		MB.add(MenuFormat);
		
		MenuColor = new JMenu("Color");
		MB.add(MenuColor);
		
		
	}
	public void createFileMenu() {
		iNew = new JMenuItem("New");
		iNew.addActionListener(this);
		iNew.setActionCommand("New");
		MenuFile.add(iNew);
			
		iOpen = new JMenuItem("Open");
		iOpen.addActionListener(this);
		iOpen.setActionCommand("Open");
		MenuFile.add(iOpen);
		
		iSave = new JMenuItem("Save");
		iSave.addActionListener(this);
		iSave.setActionCommand("Save");
		MenuFile.add(iSave);
		
		iSaveAs = new JMenuItem("Save As");
		iSaveAs.addActionListener(this);
		iSaveAs.setActionCommand("SaveAs");
		MenuFile.add(iSaveAs);
		
		iExit = new JMenuItem("Exit");
		iExit.addActionListener(this);
		iExit.setActionCommand("Exit");
		MenuFile.add(iExit);
	}
	
	public void createEditMenu() {
		iUndo = new JMenuItem("Undo");
		iUndo.addActionListener(this);
		iUndo.setActionCommand("Undo");
		MenuEdit.add(iUndo);
		
		iRedo = new JMenuItem("Redo");
		iRedo.addActionListener(this);
		iRedo.setActionCommand("Redo");
		MenuEdit.add(iRedo);
	}
	public void createFormatMenu() {
		iWrap = new JMenuItem("Word Wrap: Off");
		iWrap.addActionListener(this);
		iWrap.setActionCommand("Word Wrap");
		MenuFormat.add(iWrap);
		
		MenuFont = new JMenu("Font");
		MenuFormat.add(MenuFont);
		
		iFontArial = new JMenuItem("Arial");
		iFontArial.addActionListener(this);
		iFontArial.setActionCommand("Arial");
		MenuFont.add(iFontArial);
		
		iFontCSMS = new JMenuItem("Comic Sans MS");
		iFontCSMS.addActionListener(this);
		iFontCSMS.setActionCommand("Comic Sans MS");
		MenuFont.add(iFontCSMS);
		
		iFontTNR = new JMenuItem("Times New Roman");
		iFontTNR.addActionListener(this);
		iFontTNR.setActionCommand("Times New Roman");
		MenuFont.add(iFontTNR);
		
		iFontSerif = new JMenuItem("Serif");
		iFontSerif.addActionListener(this);
		iFontSerif.setActionCommand("Serif");
		MenuFont.add(iFontSerif);
		
		iFontImpact = new JMenuItem("Impact");
		iFontImpact.addActionListener(this);
		iFontImpact.setActionCommand("Impact");
		MenuFont.add(iFontImpact);
		
		iFontTahoma = new JMenuItem("Tahoma");
		iFontTahoma.addActionListener(this);
		iFontTahoma.setActionCommand("Tahoma");
		MenuFont.add(iFontTahoma);
		
		iFontSansSerif = new JMenuItem("Sans Serif");
		iFontSansSerif.addActionListener(this);
		iFontSansSerif.setActionCommand("Sans Serif");
		MenuFont.add(iFontSansSerif);
		
		iFonttrebuchetMS = new JMenuItem("Trebuchet MS");
		iFonttrebuchetMS.addActionListener(this);
		iFonttrebuchetMS.setActionCommand("Trebuchet MS");
		MenuFont.add(iFonttrebuchetMS);
		
		MenuFontSize = new JMenu("Font Size");
		MenuFormat.add(MenuFontSize);
		
		iFontSize8 = new JMenuItem("8");
		iFontSize8.addActionListener(this);
		iFontSize8.setActionCommand("Size 8");
		MenuFontSize.add(iFontSize8);
		
		iFontSize12 = new JMenuItem("12");
		iFontSize12.addActionListener(this);
		iFontSize12.setActionCommand("Size 12");
		MenuFontSize.add(iFontSize12);
		
		iFontSize16 = new JMenuItem("16");
		iFontSize16.addActionListener(this);
		iFontSize16.setActionCommand("Size 16");
		MenuFontSize.add(iFontSize16);
		
		iFontSize20 = new JMenuItem("20");
		iFontSize20.addActionListener(this);
		iFontSize20.setActionCommand("Size 20");
		MenuFontSize.add(iFontSize20);
		
		iFontSize24 = new JMenuItem("24");
		iFontSize24.addActionListener(this);
		iFontSize24.setActionCommand("Size 24");
		MenuFontSize.add(iFontSize24);
		
		iFontSize28 = new JMenuItem("28");
		iFontSize28.addActionListener(this);
		iFontSize28.setActionCommand("Size 28");
		MenuFontSize.add(iFontSize28);
		
	}
	
	public void createColorMenu() {
		iColor1 = new JMenuItem("White");
		iColor1.addActionListener(this);
		iColor1.setActionCommand("White");
		MenuColor.add(iColor1);
		
		iColor2 = new JMenuItem("Black");
		iColor2.addActionListener(this);
		iColor2.setActionCommand("Black");
		MenuColor.add(iColor2);
		
		iColor3 = new JMenuItem("Blue");
		iColor3.addActionListener(this);
		iColor3.setActionCommand("Blue");
		MenuColor.add(iColor3);
		
		iColor4 = new JMenuItem("Green");
		iColor4.addActionListener(this);
		iColor4.setActionCommand("Green");
		MenuColor.add(iColor4);
		
		iColor5 = new JMenuItem("Red");
		iColor5.addActionListener(this);
		iColor5.setActionCommand("Red");
		MenuColor.add(iColor5);
		
		iColor6 = new JMenuItem("Yellow");
		iColor6.addActionListener(this);
		iColor6.setActionCommand("Yellow");
		MenuColor.add(iColor6);
		
		iColor7 = new JMenuItem("Cyan");
		iColor7.addActionListener(this);
		iColor7.setActionCommand("Cyan");
		MenuColor.add(iColor7);
		
		
		
		
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		switch(command) {
		case "New": file.newFile(); break;
		case "Open": file.open(); break;
		case "Save": file.save(); break;
		case "SaveAs": file.saveAs(); break;
		case "Exit": file.exit(); break;
		case "Undo": edit.undo(); break;
		case "Redo": edit.redo(); break;
		case "Word Wrap": format.wordWrap(); break;
		case "Arial": format.setFont(command); break;
		case "Comic Sans MS": format.setFont(command); break;
		case "Times New Roman": format.setFont(command); break;
		case "Serif": format.setFont(command); break;
		case "Impact": format.setFont(command); break;
		case "Tahoma": format.setFont(command); break;
		case "Sans Serif": format.setFont(command); break;
		case "Trebuchet MS": format.setFont(command); break;
		case "Size 8": format.createFont(8); break;
		case "Size 12": format.createFont(12); break;
		case "Size 16": format.createFont(16); break;
		case "Size 20": format.createFont(20); break;
		case "Size 24": format.createFont(24); break;
		case "Size 28": format.createFont(28); break;
		case "White": iColor.ChangeColor(command); break;
		case "Black": iColor.ChangeColor(command); break;
		case "Blue": iColor.ChangeColor(command); break;
		case "Green": iColor.ChangeColor(command); break;
		case "Red": iColor.ChangeColor(command); break;
		case "Yellow": iColor.ChangeColor(command); break;
		case "Cyan": iColor.ChangeColor(command); break;






		}	
	}
	
}
