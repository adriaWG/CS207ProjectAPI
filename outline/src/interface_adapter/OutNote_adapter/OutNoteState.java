package interface_adapter.OutNote_adapter;

import entity.Note;

public class OutNoteState {
    private String filename = "";
    private String filenameError = null;

    private Note currentNote;
    public OutNoteState(OutNoteState copy){
        filename = copy.filename;
        filenameError = copy.filenameError;
        currentNote = copy.currentNote;
    }
    public OutNoteState(){}
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
