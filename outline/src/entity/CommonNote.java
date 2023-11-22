package entity;

public class CommonNote implements Note {
    private final String filename;
    private String content;
    CommonNote(String filename, String content) {
        this.filename = filename;
        this.content = content;
    }
    @Override
    public String getContent() {return content;}
    @Override
    public void addContent(String newContent){
        this.content += newContent;
    }
}

