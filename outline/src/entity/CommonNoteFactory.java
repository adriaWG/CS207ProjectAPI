package entity;

public class CommonNoteFactory implements NoteFactory{


    @Override
    public Note create(String filename, String content) {
        return new CommonNote(filename, content);
    }

    @Override
    public Note addText(Note note,String text) {
        note.addContent(text);
        return null;
    }
}
