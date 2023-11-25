package use_case.OpenNote_case;

import entity.Note;
import entity.NoteFactory;

import java.nio.file.Path;
import java.nio.file.Paths;

public class OpenNoteInteractor implements OpenNoteInputBoundary {
    final OpenNoteUserDataAccessInterface noteDataAccessObject;
    final OpenNoteOutputBoundary openNotePresenter;
    final NoteFactory notefactory;

    public OpenNoteInteractor(OpenNoteUserDataAccessInterface userDataAccessInterface,
                              OpenNoteOutputBoundary openNoteOutputBoundary, NoteFactory notefactory) {
        this.noteDataAccessObject = userDataAccessInterface;
        this.openNotePresenter = openNoteOutputBoundary;
        this.notefactory = notefactory;
    }

    @Override //some kind of execute that deal with outNote InputData
    public void createNote(OpenNoteInputData openNoteInputData) {
        String title = openNoteInputData.getTitle();
        if (noteDataAccessObject.existsByName(openNoteInputData.getTitle())) {
            openNotePresenter.prepareFailView("Note name already exists.");
        } else {
            System.out.println("note creating");
            String currentWorkingDirectory = System.getProperty("user.dir");

            String filename = title+".txt";

            Path original_path = Paths.get(currentWorkingDirectory, filename); // 创建路径
            String path = original_path.toString();
            System.out.println(path);
            Note note = notefactory.create(openNoteInputData.getTitle(),path, null);
            noteDataAccessObject.saveNote(note);

            OpenNoteOutputData openNoteOutputData = new OpenNoteOutputData(note.getNoteName(), note.getContent(), false);
            openNotePresenter.prepareSuccessView(openNoteOutputData);
        }
    }

    @Override //some kind of execute that deal with outNote InputData
    public void openNote(OpenNoteInputData openNoteInputData) {
        String title = openNoteInputData.getTitle();
        if (!noteDataAccessObject.existsByName(openNoteInputData.getTitle())) {
            openNotePresenter.prepareFailView("Note name not found.");
        } else {
            System.out.println("note opening");

            String path = noteDataAccessObject.getPath(title);
            System.out.println(path);
            Note note = notefactory.create(openNoteInputData.getTitle(),path, null);
            noteDataAccessObject.saveNote(note);

            OpenNoteOutputData openNoteOutputData = new OpenNoteOutputData(note.getNoteName(), note.getContent(), false);
            openNotePresenter.prepareSuccessView(openNoteOutputData);
        }

    }

}
