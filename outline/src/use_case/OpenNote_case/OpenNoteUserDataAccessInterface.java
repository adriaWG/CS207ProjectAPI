package use_case.OpenNote_case;

import entity.Note;

public interface OpenNoteUserDataAccessInterface {
    boolean existsByName(String title);
    void saveNote(Note note);

    String getPath(String title);
}
