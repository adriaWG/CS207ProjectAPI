package use_case.EditNote;

public class EditNoteOutputData {

    private final String filename;
    private boolean useCaseFailed;

    public EditNoteOutputData(String filename, boolean useCaseFailed) {
        this.filename = filename;
        this.useCaseFailed = useCaseFailed;
    }

    public String getFilename() {
        return filename;
    }

}
