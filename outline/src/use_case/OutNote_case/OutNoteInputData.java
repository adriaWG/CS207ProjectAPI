package use_case.OutNote_case;

public class OutNoteInputData {
    final private String filename;
    final private String filepath;

    public OutNoteInputData(String filename,String filepath) {
        this.filename = filename;
        this.filepath=filepath;
    }

    String getFilename() {
        return filename;
    }
    String getFilepath(){return filepath; }
}
