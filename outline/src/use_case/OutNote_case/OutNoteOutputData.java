package use_case.OutNote_case;

public class OutNoteOutputData {
    private final String filename;
    private final String filepath;

    private boolean useCaseFailed;

    public OutNoteOutputData(String filename, String filepath, boolean useCaseFailed) {
        this.filename = filename;
        this.filepath = filepath;
        this.useCaseFailed = useCaseFailed;
    }

    public String getFilename() {return filename;}
    public String getFilepath() {return filepath;}
}
