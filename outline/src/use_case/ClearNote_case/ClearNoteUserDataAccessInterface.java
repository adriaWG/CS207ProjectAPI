package use_case.ClearNote_case;

import java.util.Set;

public interface ClearNoteUserDataAccessInterface {
    void deleteAllNote(Set<String> noteNames);
    void deleteSingleNote(String noteName);
}
