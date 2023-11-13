package use_case.OpenNote;

public class OpenNoteOutputData {
    private String noteId;
    private String message;

    public OpenNoteOutputData(String noteId, String message){
        this.noteId = noteId;
        this.message = message;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getMessage() {
        return message;
    }
}
