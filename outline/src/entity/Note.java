package entity;

import java.time.LocalDateTime;

public interface Note {
    //current note is just the simplest version of txt file
    String getContent();
    String getNotePath();
    String getNoteName();

    void addContent(String newContent);
}
