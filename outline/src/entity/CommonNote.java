package entity;

public class CommonNote implements Note {
    private final String noteName;
    private String content;
    private String notePath;
    CommonNote(String noteName,String notePath, String content) {
        this.noteName = noteName;
        this.notePath=notePath;
        this.content = content;
    }
    @Override
    public String getContent() {return content;}
    public String getNoteName(){return noteName;}

    public String getNotePath() {return notePath;}

    @Override
    public void addContent(String newContent){
        this.content = newContent;
    }
}

