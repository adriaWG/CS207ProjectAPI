package interface_adapter.EditNote_adapter;

import entity.Note;

public class EditNoteState {
    private String filename = "";
    private String filenameError = null;

    private Note currentNote;
    public EditNoteState(EditNoteState copy) {
        filename = copy.filename;
        filenameError = copy.filenameError;
        currentNote = copy.currentNote;

    }
    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditNoteState() {}

    public String getFilename() {
        return filename;
    }

    public String getFilenameError() {
        return filenameError;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
    public void setFilenameError(String filename) {
        this.filename = filename;
    }


    public void setCurrentNote(Note note){
        this.currentNote=note;
    }

    public Note getCurrentNote(){return this.currentNote;}
    public String getCurrentNoteContent(){
        return currentNote.getContent();
    }

}
