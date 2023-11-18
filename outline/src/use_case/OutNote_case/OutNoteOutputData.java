package use_case.OutNote_case;

public class OutNoteOutputData {
    private final String filename;

    private boolean useCaseFailed;

    public OutNoteOutputData(String filename, boolean useCaseFailed) {
        this.filename = filename;
        this.useCaseFailed = useCaseFailed;
    }

    public String getFilename() {
        return filename;
    }
}
