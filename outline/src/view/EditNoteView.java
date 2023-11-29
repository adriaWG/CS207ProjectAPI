package view;

import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;

import interface_adapter.EditNote_adapter.EditNoteState;
import interface_adapter.OutNote_adapter.OutNoteController;
import interface_adapter.OutNote_adapter.OutNoteViewModel;
import use_case.ClearNote_case.ClearNoteInputBoundary;
import interface_adapter.ClearNote_adapter.ClearNoteController;
import interface_adapter.ClearNote_adapter.ClearNotePresenter;
import interface_adapter.ClearNote_adapter.ClearNoteState;
import interface_adapter.ClearNote_adapter.ClearNoteViewModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditNoteView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName="edit note";
    private final EditNoteViewModel editNoteViewModel;
    private final OutNoteViewModel outNoteViewModel;
    private final ClearNoteViewModel clearNoteViewModel;
    private String existingText ;
    final JTextArea textArea = new JTextArea(existingText, 10, 30);
    private final JLabel filenameErrorField = new JLabel();

    private final JButton edit;
    private final JButton cancel;
    private final JButton clear;
    private final JButton export;
    private final EditNoteController editNoteController;
    private final OutNoteController outNoteController;
    private final ClearNoteController clearNoteController;


    public EditNoteView(EditNoteViewModel editNoteViewModel, EditNoteController editController,
                        OutNoteController outNoteController,OutNoteViewModel outNoteViewModel,
                        ClearNoteController clearNoteController, ClearNoteViewModel clearNoteViewModel) {

        this.editNoteController = editController;
        this.editNoteViewModel = editNoteViewModel;

        this.outNoteController = outNoteController;
        this.outNoteViewModel = outNoteViewModel;
        this.clearNoteController=clearNoteController;
        this.clearNoteViewModel=clearNoteViewModel;


        this.editNoteViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Edit Note View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);



        JPanel buttons = new JPanel();
        edit = new JButton(editNoteViewModel.SAVE_BUTTON_LABEL);
        buttons.add(edit);
        cancel = new JButton(editNoteViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        clear = new JButton(clearNoteViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);
        export = new JButton(outNoteViewModel.EXPORT_BUTTON_LABEL);
        buttons.add(export);

        edit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
                            EditNoteState currentState = editNoteViewModel.getState();
                            editNoteController.editNote(currentState.getFilename(),currentState.getCurrentNote(),textArea.getText());
                            editNoteViewModel.printSuccess();
                        }
                    }
                }
        );
        
        cancel.addActionListener(this);

        clear.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(clear)) {
                            EditNoteState currentState = editNoteViewModel.getState();
                            editNoteController.editNote(currentState.getFilename(),currentState.getCurrentNote(),textArea.getText());
                        }
                    }
                }
        );

        export.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(export)) {
                            EditNoteState currentState = editNoteViewModel.getState();
                            editNoteController.editNote(currentState.getFilename(),currentState.getCurrentNote(),textArea.getText());
                        }
                    }
                }
        );
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(textArea);
        this.add(buttons);

}



    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Function not implemented yet.");
    }
    
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditNoteState state = (EditNoteState) evt.getNewValue();
        setNoteContent(state);
        if (state.getFilenameError() != null) {
            JOptionPane.showMessageDialog(this, state.getFilenameError());
        }
    }

    private void setNoteContent(EditNoteState state){
        existingText = state.getCurrentNoteContent();
        textArea.setText(existingText);
        System.out.println(existingText);
    }

}
















