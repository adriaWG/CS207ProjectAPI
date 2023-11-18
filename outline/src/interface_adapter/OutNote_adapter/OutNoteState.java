package interface_adapter.OutNote_adapter;

public class OutNoteState {
    private String filename="";
    private String filepath="";
    public OutNoteState(OutNoteState copy){filename= copy.filename;filepath=copy.filepath;}
    public OutNoteState(){}

    public String getFilename(){return filename;}
    public String getFilepath(){return filepath;}
    public void setFilename(String filename){this.filename=filename;}
    public void setFilepath(String filepath){this.filepath=filepath;}
}
