package use_case.EditNote_case;

import entity.Note;

public class EditNoteInputData {
    final private String filename;
    private Note note;
    private String screenText;

    public EditNoteInputData(String filename,Note note,String screenText) {
        this.filename = filename;
        this.note=note;
        this.screenText=screenText;
    }

    String getFilename() {
        return filename;
    }

    Note getNote(){return note;}
    String getScreenText(){return screenText;}

}

