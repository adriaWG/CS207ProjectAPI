package use_case.OutNote_case;

public class OutNoteInteractor implements OutNoteInputBoundary{
    final OutNoteUserDataAccessInterface userDataAccessObject;
    final OutNoteOutputBoundary outNotePresenter;

    public OutNoteInteractor(OutNoteUserDataAccessInterface userDataAccessInterface,
                              OutNoteOutputBoundary outNoteOutputBoundary) {
        this.userDataAccessObject = userDataAccessInterface;
        this.outNotePresenter = outNoteOutputBoundary;
    }

    @Override //some kind of execute that deal with outNote InputData
    public void outputfile(OutNoteInputData outNoteInputData) {
        String filename = outNoteInputData.getFilename();
        String filepath = outNoteInputData.getFilepath();
        //TODO: out2. add API for OutNote,output the file according to filepath
    }
}
