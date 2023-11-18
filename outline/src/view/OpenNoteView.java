package view;

import java.util.Scanner;

import use_case.OpenNote_case.OpenNoteInputData;
import use_case.OpenNote_case.OpenNoteOutputBoundary;
import use_case.OpenNote_case.OpenNoteOutputData;

public class OpenNoteView implements OpenNoteOutputBoundary {
    private final Scanner scanner;
    public OpenNoteView(){
        this.scanner = new Scanner(System.in);
    }

    public void presentNoteCreated(OpenNoteOutputData outputData){
        System.out.println("Note ID:" + outputData.getNoteId());
        System.out.println(outputData.getMessage());
    }

    public OpenNoteInputData collectNoteInput(){
        System.out.println("Enter note title:");
        String title = scanner.nextLine();
        System.out.println("Enter note content:");
        String content = scanner.nextLine();

        return new OpenNoteInputData(title, content);
    }


}
