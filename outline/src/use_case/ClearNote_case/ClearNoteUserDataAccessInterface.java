package use_case.ClearNote_case;

import java.util.Set;

public interface ClearNoteUserDataAccessInterface {
    void deleteAllNote();
    void deleteSingleNote(String noteName);
}
