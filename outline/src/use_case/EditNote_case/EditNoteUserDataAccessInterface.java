package use_case.EditNote_case;

import entity.Note;

public interface EditNoteUserDataAccessInterface {
    // TODO: edit4 modify this according to DAO
    boolean existsByName(String identifier);

    void save(Note note);

    //anything that the editNote might need
    Note get(String filename);
}
