package use_case.OpenNote_case;

import entity.Note;

public class OpenNoteOutputData {
    private String noteId;
    private Note note;
    private  boolean usecaseFailed;

    public OpenNoteOutputData(String noteId, Note note,boolean useCaseFailed){
        this.noteId = noteId;
        this.note = note;
        this.usecaseFailed=useCaseFailed;
    }

    public String getNoteId() {
        return noteId;
    }

    public Note getNote() {
        return note;
    }

    public String getNoteText(){
        return note.getContent();
    }
}
