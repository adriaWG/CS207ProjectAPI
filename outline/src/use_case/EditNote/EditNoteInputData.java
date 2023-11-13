package use_case.EditNote;

public class EditNoteInputData {
    final private String filename;

    public EditNoteInputData(String filename) {
        this.filename = filename;

    }

    String getFilename() {
        return filename;
    }

}

