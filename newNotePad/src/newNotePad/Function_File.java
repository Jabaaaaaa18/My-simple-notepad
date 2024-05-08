package newNotePad;

import java.awt.FileDialog;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class Function_File {
	
	MyGUI gui;
	String fileName;
	String fileAddress;
	
	public Function_File(MyGUI gui) {
		this.gui = gui;
		
	}
	public void newFile() {
		gui.TA.setText("");
		gui.window.setTitle("New");
		fileName = null;
		fileAddress = null;
	}
	public void open() {
		FileDialog FD = new FileDialog(gui.window, "File Manager", FileDialog.LOAD);
		FD.setVisible(true);
		
		if(FD.getFile()!=null) {
			fileName = FD.getFile();
			fileAddress = FD.getDirectory();
			gui.window.setTitle(fileName);
		}
		System.out.println("File Address and File Name" + fileAddress + fileName );

		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileAddress + fileName));
			
			gui.TA.setText("");
			String line = null;
			
			while((line = br.readLine())!=null){
				gui.TA.append(line + "\n");
			}
			br.close();
			
		}catch(Exception e) {
			System.out.println("FILE NOT FOUND!");
		}
	}
	public void save() {
		if(fileName==null) {
			saveAs();
		}
		else {
			try {
				FileWriter FW = new FileWriter(fileAddress + fileName);
				FW.write(gui.TA.getText());
				gui.window.setTitle(fileName);
				FW.close();
			}catch(Exception e) {
				System.out.println("SOMETHING WRONG");

			}
		}
		
	}
	public void saveAs() {
		FileDialog FD = new FileDialog(gui.window, "Save", FileDialog.SAVE);
		FD.setVisible(true);
		
		if(FD.getFile()!=null) {
			fileName = FD.getFile();
			fileAddress = FD.getDirectory();
			gui.window.setTitle(fileName);
		}
		try {
			FileWriter FW = new FileWriter(fileAddress + fileName);
			FW.write(gui.TA.getText());
			FW.close();
			
		}catch(Exception e) {
			System.out.println("SOMETHING WRONG");
		}
			
	}
	public void exit() {
		System.exit(0);
	}
	
	
	
	
	
	
	
	
	

}
