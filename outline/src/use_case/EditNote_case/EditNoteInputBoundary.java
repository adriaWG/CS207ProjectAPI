package use_case.EditNote_case;

import interface_adapter.EditNote_adapter.EditNoteController;

public interface EditNoteInputBoundary {
    //define methods that EditNote should present
    //for start we just have one function edit (including editing files and all)
    //TODO: edit 1. add wanted method for editNote
    void edit(EditNoteInputData editNoteInputData);


}
