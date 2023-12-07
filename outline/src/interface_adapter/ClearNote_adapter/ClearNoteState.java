package interface_adapter.ClearNote_adapter;

import entity.Note;
import interface_adapter.EditNote_adapter.EditNoteState;
//it's similar to other note states
public class ClearNoteState {
    private String filename = "";
    private String filenameError = null;

    private Note currentNote;
    public ClearNoteState(ClearNoteState copy) {
        filename = copy.filename;
        filenameError = copy.filenameError;
        currentNote = copy.currentNote;

    }
    // Because of the previous copy constructor, the default constructor must be explicit.
    public ClearNoteState() {}

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void setFilenameError(String filename) {
        this.filename = filename;
    }

}
