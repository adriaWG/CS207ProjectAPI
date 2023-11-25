package entity;

public class CommonNoteFactory implements NoteFactory{


    @Override
    public Note create(String noteName, String notePath,String content) {
        return new CommonNote(noteName, notePath ,content);
    }

    @Override
    public Note addText(Note note,String text) {
        note.addContent(text);
        return null;
    }
}
