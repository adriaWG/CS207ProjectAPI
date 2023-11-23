package data_access;

import entity.Note;
import entity.NoteFactory;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;
import use_case.EditNote_case.EditNoteUserDataAccessInterface;
import use_case.OpenNote_case.OpenNoteUserDataAccessInterface;
import use_case.OutNote_case.OutNoteUserDataAccessInterface;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

public class FileUserDataAccessObject implements OpenNoteUserDataAccessInterface, EditNoteUserDataAccessInterface,
        ClearNoteUserDataAccessInterface, OutNoteUserDataAccessInterface {

    private final File csvFile;

    private final Map<String, Integer> headers = new LinkedHashMap<>();

    private final Map<String, Note> accounts = new HashMap<>();

    private NoteFactory noteFactory;

    public FileUserDataAccessObject(String csvPath, NoteFactory noteFactory) throws IOException {
        this.noteFactory = noteFactory;

        csvFile = new File(csvPath);
        headers.put("filename", 0);
        headers.put("filepath",1);

        if (csvFile.length() == 0) {
            save();
        } else {

            try (BufferedReader reader = new BufferedReader(new FileReader(csvFile))) {
                String header = reader.readLine();

                // For later: clean this up by creating a new Exception subclass and handling it in the UI.
                assert header.equals("filename,filepath");

                String row;
                while ((row = reader.readLine()) != null) {
                    String[] col = row.split(",");
                    String filename = String.valueOf(col[headers.get("filename")]);
                    String filepath = String.valueOf(col[headers.get("filepath")]);
//                    String content = String.value
                    Note note = noteFactory.create(filename, filepath, content);
                    accounts.put(username, user);
                }
            }
        }
    }

    @Override
    public void save(User user) {
        accounts.put(user.getName(), user);
        this.save();
    }

    @Override
    public User get(String username) {
        return accounts.get(username);
    }

    private void save() {
        BufferedWriter writer;
        try {
            writer = new BufferedWriter(new FileWriter(csvFile));
            writer.write(String.join(",", headers.keySet()));
            writer.newLine();

            for (User user : accounts.values()) {
                String line = String.format("%s,%s,%s",
                        user.getName(), user.getPassword(), user.getCreationTime());
                writer.write(line);
                writer.newLine();
            }

            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Return whether a user exists with username identifier.
     * @param identifier the username to check.
     * @return whether a user exists with username identifier
     */
    @Override
    public boolean existsByName(String identifier) {
        return accounts.containsKey(identifier);
    }

    @Override
    public void save(Note note) {

    }

    //add get all username
    public Set<String> getAllUsernames() {
        return accounts.keySet();
    }

    public void deleteUser(Set<String> usernames) {
        Iterator<String> iterator = usernames.iterator();
        while (iterator.hasNext()) {
            String username = iterator.next();
            User user = accounts.get(username);
            if (user != null) {
                iterator.remove();
                accounts.remove(username);
//                System.out.println(username);
            }
        }
        save();
    }

    @Override
    public void deleteNotebook() {

    }
}
