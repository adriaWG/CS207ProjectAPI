package interface_adapter.EditNote_adapter;

public class EditNoteState {
    private String filename = "";
    private String filenameError = null;
    public EditNoteState(EditNoteState copy) {
        filename = copy.filename;
        filenameError = copy.filenameError;

    }
    // Because of the previous copy constructor, the default constructor must be explicit.
    public EditNoteState() {}

    public String getFilename() {
        return filename;
    }

    public String getFilenameError() {
        return filenameError;
    }


}
