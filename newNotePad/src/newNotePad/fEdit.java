package newNotePad;

public class fEdit {

	MyGUI gui;
	public fEdit(MyGUI gui) {
		this.gui = gui;
	}
	public void undo() {
		gui.UM.undo();
	}
	public void redo() {
		gui.UM.redo();
	}
}
