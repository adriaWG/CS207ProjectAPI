package entity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CommonNoteFactory implements NoteFactory{


    @Override
    public Note create(String noteName, String notePath,String content) {
        return new CommonNote(noteName, notePath ,content);
    }
    public String readFileToString(String filePath) {
        StringBuilder content = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return content.toString();
    }
    @Override
    public Note fetchText(String noteName, String notePath){
        String content = readFileToString(notePath);
        return new CommonNote(noteName,notePath,content);
    }

    @Override
    public Note addText(Note note,String text) {
        note.addContent(text);
        return note;
    }
}
