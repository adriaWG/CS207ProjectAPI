package entity;

import java.time.LocalDateTime;

public interface NoteFactory {

    Note create(String filename, String filepath,String content);

    Note addText(Note note, String text);
}
