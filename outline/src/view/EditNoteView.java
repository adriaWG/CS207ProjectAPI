package view;

import use_case.ClearNote_case.ClearNoteInputBoundary;

import use_case.ClearNote_case.ClearNoteInterface;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;

public class EditNoteView {
    ClearNoteUserDataAccessInterface dataAccess = new ClearNoteUserDataAccess();
    ClearNoteInputBoundary inputBoundary = new ClearNoteInputData(dataAccess);
    ClearNoteOutputBoundary outputBoundary = new ClearNoteOutputData();
    ClearNoteInterface interactor = new ClearNoteInteractor(inputBoundary);

// To delete a notebook
interactor.deleteNotebook("yourNotebookId", outputBoundary);
}
