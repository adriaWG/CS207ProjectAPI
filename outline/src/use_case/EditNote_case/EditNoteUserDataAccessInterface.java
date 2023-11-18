package use_case.EditNote_case;

import entity.Note;

public interface EditNoteUserDataAccessInterface {
    boolean existsByName(String identifier);

    void save(Note note);

    //anything that the editnote might need
    Note get(String username);
}
