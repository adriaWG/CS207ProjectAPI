package interface_adapter.OutNote_adapter;

import use_case.OutNote_case.OutNoteInputBoundary;
import use_case.OutNote_case.OutNoteInputData;

public class OutNoteController {
    final OutNoteInputBoundary outNoteUseCaseInteractor;
    public OutNoteController(OutNoteInputBoundary outNoteUseCaseInteractor) {
        this.outNoteUseCaseInteractor = outNoteUseCaseInteractor;
    }


    public void execute(String filename) {
        OutNoteInputData outNoteInputData = new OutNoteInputData(filename,null);
        outNoteUseCaseInteractor.outputfile(outNoteInputData);
    }
}
