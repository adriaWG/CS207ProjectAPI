package interface_adapter.OpenNote_adapter;

import interface_adapter.OpenNote_adapter.OpenNoteState;

public class OpenNoteState {
    private String noteId="";
    private String message="";
    private String noteIdError=null;
    public OpenNoteState(OpenNoteState copy){
        noteId= copy.noteId;
        message=copy.message;
        noteIdError=copy.noteIdError;
    }
    public OpenNoteState(){}

    public String getNoteId(){return noteId;}
    public String getMessage(){return message;}
    public void setNoteId(String noteId){this.noteId=noteId;}
    public void setMessage(String message){this.message=message;}

    public void setNoteIdError(String noteIdError) {
        this.noteIdError = noteIdError;
    }
    public String getNoteIdError() {
        return noteIdError;
    }


}