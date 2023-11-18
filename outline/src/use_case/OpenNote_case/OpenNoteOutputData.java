package use_case.OpenNote_case;

public class OpenNoteOutputData {
    private String noteId;
    private String message;

    private boolean useCaseFailed;
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
