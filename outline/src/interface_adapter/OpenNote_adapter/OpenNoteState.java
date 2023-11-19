package interface_adapter.OpenNote_adapter;

import interface_adapter.OpenNote_adapter.OpenNoteState;

public class OpenNoteState {
    private String noteId="";
    private String message="";
    public OpenNoteState(OpenNoteState copy){noteId= copy.noteId; message=copy.message;}
    public OpenNoteState(){}

    public String getNoteId(){return noteId;}
    public String getMessage(){return message;}
    public void setNoteId(String noteId){this.noteId=noteId;}
    public void setMessage(String message){this.message=message;}
}