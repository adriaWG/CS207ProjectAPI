package entity;

public class CommonNoteFactory implements NoteFactory{


    @Override
    public Note create(String filename, String filepath,String content) {
        return new CommonNote(filename, filepath,content);
    }

    @Override
    public Note addText(Note note,String text) {
        note.addContent(text);
        return null;
    }
}
