package view;

import interface_adapter.EditNote_adapter.*;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteState;
import use_case.ClearNote_case.ClearNoteInputBoundary;

import use_case.ClearNote_case.ClearNoteInterface;
import use_case.ClearNote_case.ClearNoteOutputBoundary;
import use_case.ClearNote_case.ClearNoteUserDataAccessInterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class EditNoteView extends JPanel implements ActionListener, PropertyChangeListener {
    public final String viewName="Edit Note";
    private final EditNoteViewModel editNoteViewModel;

    final JTextField filenameInputField = new JTextField(100);
    private final JLabel filenameErrorField = new JLabel();

    private final JButton edit;
    private final JButton cancel;
    private final JButton export;
    private final JButton clear;
    
    private final EditNoteController editNoteController;

    public EditNoteView(EditNoteViewModel editNoteViewModel, EditNoteController controller) {

        this.editNoteController = controller;
        this.editNoteViewModel = editNoteViewModel;
        this.editNoteViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Edit Note View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel filenameInfo = new LabelTextPanel(
                new JLabel("Filename"), filenameInputField);

        JPanel buttons = new JPanel();
        edit = new JButton(editNoteViewModel.EDIT_BUTTON_LABEL);
        buttons.add(edit);
        cancel = new JButton(editNoteViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);
        export = new JButton(editNoteViewModel.EXPORT_LABEL);
        buttons.add(export);
        clear = new JButton(editNoteViewModel.CLEAR_LABEL);
        buttons.add(clear);

        edit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
                            EditNoteState currentState = EditNoteViewModel.getState();
                            //TODO Edit Note view 1: finish this
                            EditNoteController.editNote(currentState.getFilename());
                        }
                    }
                }
        );

        cancel.addActionListener(this);
        
        export.addActionListener(this);
        
        clear.addActionListener(this);
        
}
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        EditNoteState state = (EditNoteState) evt.getNewValue();
        if (state.getFilenameError() != null) {
            JOptionPane.showMessageDialog(this, state.getFilenameError());
        }
    }

}













}
