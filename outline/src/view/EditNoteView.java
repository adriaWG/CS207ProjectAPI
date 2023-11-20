package view;

import use_case.ClearNote.ClearNoteInputBoundary;
import use_case.ClearNote.ClearNoteInterface;
import use_case.ClearNote.ClearNoteOutputBoundary;
import use_case.ClearNote.ClearNoteUserDataAccessInterface;

public class EditNoteView {
    ClearNoteUserDataAccessInterface dataAccess = new ClearNoteUserDataAccess();
    ClearNoteInputBoundary inputBoundary = new ClearNoteInputData(dataAccess);
    ClearNoteOutputBoundary outputBoundary = new ClearNoteOutputData();
    ClearNoteInterface interactor = new ClearNoteInteractor(inputBoundary);

// To delete a notebook
interactor.deleteNotebook("yourNotebookId", outputBoundary);
}
