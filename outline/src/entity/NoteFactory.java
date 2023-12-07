package entity;

import java.nio.file.Path;
import java.time.LocalDateTime;

// gives an interface that concludes our entity's building functions
public interface NoteFactory {

    Note create(String noteName, String notePath, String content);
    Note fetchText(String noteName, String notePath);
    Note addText(Note note, String text);
}
