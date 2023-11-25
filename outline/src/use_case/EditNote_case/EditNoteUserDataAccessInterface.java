package use_case.EditNote_case;

import entity.Note;

import java.io.File;

public interface EditNoteUserDataAccessInterface {
    // TODO: edit4 modify this according to DAO
    boolean existsByName(String identifier);

    void saveNote(Note note);

    void saveFileAccounts();

//    String get(String filename);
}
