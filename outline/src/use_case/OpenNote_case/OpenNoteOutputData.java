package use_case.OpenNote_case;

public class OpenNoteOutputData {
    private String noteId;
    private String message;
    private  boolean usecaseFailed;

    private boolean useCaseFailed;
    public OpenNoteOutputData(String noteId, String message,boolean useCaseFailed){
        this.noteId = noteId;
        this.message = message;
        this.usecaseFailed=useCaseFailed;
    }

    public String getNoteId() {
        return noteId;
    }

    public String getMessage() {
        return message;
    }
}
