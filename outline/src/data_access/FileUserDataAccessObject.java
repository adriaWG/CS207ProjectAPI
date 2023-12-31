package data_access;

import entity.Note;
import entity.NoteFactory;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;
import use_case.EditNote_case.EditNoteUserDataAccessInterface;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import use_case.OutNote_case.OutNoteUserDataAccessInterface;

import java.io.*;
import java.util.*;
// Our fileUserDataAccessObject uses a csv file to contain our filenames and filepaths,
// In this way, we can read file contents using FileUserDataAccessObject by building readContent functions in it.
// Our other codes don't have to know how we read content from filepath.
public class FileUserDataAccessObject implements OpenNoteUserDataAccessInterface, EditNoteUserDataAccessInterface,
        ClearNoteUserDataAccessInterface, OutNoteUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String,String> fileAccounts = new HashMap<>();

    private NoteFactory noteFactory;

    public FileUserDataAccessObject(String csvPath, NoteFactory noteFactory) throws IOException {
        this.noteFactory = noteFactory;

        csvFile = new File(csvPath);
        headers.put("filename", 0);
        headers.put("filepath",1);

        if (csvFile.length() == 0) {
            saveFileAccounts();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("noteName,notePath");
                headers.put("noteName", 0);
                headers.put("notePath", 1);

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String noteName = String.valueOf(col[headers.get("noteName")]);
                    String notePath = String.valueOf(col[headers.get("notePath")]);
                    String content = null; //when you first create a file it would be null
                    Note note = noteFactory.create(noteName, notePath, content);

                    fileAccounts.put(noteName, notePath);
                }
            }
        }
    }

    //function of saving file
    public void saveToTxt(Note note) {
        String filePath = note.getNotePath();
        String fileContent = note.getContent();
        if (fileContent != null && !fileContent.isEmpty()) {
            try (FileWriter writer = new FileWriter(filePath)) {
                writer.write(fileContent);
                System.out.println("Note saved to " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            // 如果内容为空，创建一个空的txt文件
            try {
                FileWriter writer = new FileWriter(filePath);
                writer.close(); // 创建空文件
                //TODO: delete this when finished
                System.out.println("Note file saved at " + filePath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void saveNote(Note note) {
        saveToTxt(note);
        fileAccounts.put(note.getNoteName(), note.getNotePath());
        this.saveFileAccounts();
    }

    @Override
    public void saveFileAccounts() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(csvFile))) {
            // Writing headers
            writer.println("noteName,notePath");

            // Writing data from fileAccounts map
            for (Map.Entry<String, String> entry : fileAccounts.entrySet()) {
                String noteName = entry.getKey();
                String notePath = entry.getValue();
                writer.println(noteName + "," + notePath);
            }
        } catch (IOException e) {
            e.printStackTrace(); // Handle the exception according to your application's logic
        }
    }


    //function2 get notePath
    @Override
    public boolean existsByName(String identifier) {
        return fileAccounts.containsKey(identifier);
    }
    @Override
    public String getPath(String noteName){
        return fileAccounts.get(noteName);
    }
    //add get all username
    public Set<String> getAllFileNames() {
        return fileAccounts.keySet();
    }

    public void deleteNoteFile(String notePath) {
        File fileToDelete = new File(notePath);

        if (fileToDelete.exists()) {
            boolean isDeleted = fileToDelete.delete();
            if (isDeleted) {
                System.out.println("File deleted successfully.");
                // You may also want to remove the entry from fileAccounts map:
                // fileAccounts.remove(noteName);
            } else {
                System.out.println("Failed to delete the file.");
            }
        } else {
            System.out.println("File does not exist at the given path.");
        }
    }

    private Set<String> getAllNoteNames() {
        return fileAccounts.keySet();
    }

    public void deleteAllNote() {
        Set<String> noteNames = getAllNoteNames();
        Iterator<String> iterator = noteNames.iterator();
        while (iterator.hasNext()) {
            String noteName = iterator.next();
            String notePath = fileAccounts.get(noteName);
            if (notePath != null) {
                iterator.remove();
                fileAccounts.remove(noteName);
                deleteNoteFile(notePath);
//                System.out.println(username);
            }
        }
        saveFileAccounts();
    }

    @Override
    public void deleteSingleNote(String noteName) {
        if (fileAccounts.containsKey(noteName)) {
            String notePath =  fileAccounts.get(noteName);
            deleteNoteFile(notePath);
            fileAccounts.remove(noteName);
            saveFileAccounts(); // Save the updated fileAccounts to the CSV file
            System.out.println("Note '" + noteName + "' deleted successfully.");
        } else {
            System.out.println("Note '" + noteName + "' not found.");
        }
    }
}
