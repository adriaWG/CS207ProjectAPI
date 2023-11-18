package use_case.ClearNote_case;

public class ClearNoteOutputData {
    private final String filename;
    private boolean useCaseFailed;

    public ClearNoteOutputData(String filename, boolean useCaseFailed) {
        this.filename = filename;
        this.useCaseFailed = useCaseFailed;
    }

    public String getFilename() {
        return filename;
    }
}
