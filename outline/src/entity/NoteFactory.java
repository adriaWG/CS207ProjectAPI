package entity;

import java.time.LocalDateTime;

public interface NoteFactory {

    Note create(String filename, String content);

    Note addText(Note note, String text);
}
