package entity;

public class CommonNote implements Note {
    private final String filename;
    private String content;
    private String filepath;
    CommonNote(String filename,String filepath, String content) {
        this.filename = filename;
        this.filepath=filepath;
        this.content = content;
    }
    @Override
    public String getContent() {return content;}
    public String getFilename(){return filename;}

    public String getFilepath() {return filepath;}

    @Override
    public void addContent(String newContent){
        this.content += newContent;
    }
}

