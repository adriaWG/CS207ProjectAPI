package interface_adapter.ClearNote_adapter;

public class ClearNoteState {
    private String filename = "";
    private String filenameError = null;

    public ClearNoteState(ClearNoteState copy) {
        filename = copy.filename;
        filenameError = copy.filenameError;
    }

    public ClearNoteState() {}

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilenameError(String filename) {
        this.filename = filenameError;
    }

    public String getFilenameError() {
        return filenameError;
    }
}
