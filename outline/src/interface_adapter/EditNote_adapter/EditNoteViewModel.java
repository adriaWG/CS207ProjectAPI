package interface_adapter.EditNote_adapter;

import interface_adapter.OutNote_adapter.OutNoteState;
import interface_adapter.ViewModel;

import javax.swing.*;
import javax.swing.text.Document;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;


public class EditNoteViewModel extends ViewModel {
    public final String TITLE_LABEL = "Edit Note View";


    //buttons that we need on edit note
    public static final String SAVE_BUTTON_LABEL = "Save";
    public static final String CANCEL_BUTTON_LABEL = "Cancel";
    private EditNoteState state = new EditNoteState();

    public  EditNoteViewModel() {
        super("edit note");
    }

    public void setState(EditNoteState state) {
        this.state = state;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    // This is what the Signup Presenter will call to let the ViewModel know
    // to alert the View
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public EditNoteState getState() {
        return state;
    }

    public void printSuccess(){
        JOptionPane.showMessageDialog(null, "File successfully saved!");
    }
    public void printSuccessDelete(String filename){
        JOptionPane.showMessageDialog(null, "File "+filename+" successfully Deleted!");
    }
    public void printSuccessExport(OutNoteState state){
        String[] fileTypes = {"PDF", "TXT", "DOC"};
        String selectedType = (String) JOptionPane.showInputDialog(null, "Choose export type:",
                "Export Type", JOptionPane.QUESTION_MESSAGE, null, fileTypes, fileTypes[0]);

        if (selectedType != null) {
            String noteContent = state.getCurrentNoteContent();
            String noteName = state.getFilename();
            String exportFilePath = exportNote(noteName, noteContent, selectedType);
            JOptionPane.showMessageDialog(null, "Successfully exported to \n" + exportFilePath,
                    "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private String exportNote(String noteName, String noteContent, String fileType) {
        String filePath = "";
        switch (fileType.toUpperCase()) {

            case "TXT":
                filePath = noteName + ".txt";
                exportToTxt(noteContent, filePath);
                break;

        }
        return filePath;
    }

    private void exportToTxt(String noteContent, String filePath) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
            writer.write(noteContent);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
