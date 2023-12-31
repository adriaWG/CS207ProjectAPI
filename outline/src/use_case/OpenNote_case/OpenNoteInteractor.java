package use_case.OpenNote_case;

import entity.Note;
import entity.NoteFactory;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        if (noteDataAccessObject.existsByName(title) ){
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

            OpenNoteOutputData openNoteOutputData = new OpenNoteOutputData(note.getNoteName(), note, false);
            openNotePresenter.prepareSuccessView(openNoteOutputData);
        }
    }
    //basic thing here is [using methods that is already defined] with inputdata
    @Override
    public void openNote(OpenNoteInputData openNoteInputData) {
        String title = openNoteInputData.getTitle();
        if (!noteDataAccessObject.existsByName(openNoteInputData.getTitle())) {
            openNotePresenter.prepareFailView("Note name not found.");
        } else {
            System.out.println("note opening");

            String path = noteDataAccessObject.getPath(title);
            System.out.println(path);
            System.out.println(readString(path));
            Note note = notefactory.create(openNoteInputData.getTitle(),path, readString(path));
            noteDataAccessObject.saveNote(note);

            OpenNoteOutputData openNoteOutputData = new OpenNoteOutputData(note.getNoteName(), note, false);
            openNotePresenter.prepareSuccessView(openNoteOutputData);
        }

    }

    public String readString(String filePath) {

        String fileContent;
        try {
            //fileContent = Files.readString(Paths.get(filePath));
            List<String> lines = Files.readAllLines(Paths.get(filePath),StandardCharsets.UTF_8);
            fileContent = String.join(System.lineSeparator(), lines);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return fileContent;
    }

}
