package interface_adapter.OpenNote_adapter;

import use_case.OpenNote_case.OpenNoteOutputBoundary;

public class OpenNotePresenter implements OpenNoteOutputBoundary {
    System.out.println("Note ID:" + outputData.getNoteId());
    System.out.println(outputData.getMessage());


}
