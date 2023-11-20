package view;

import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.EditNote_adapter.EditNoteState;
import interface_adapter.EditNote_adapter.EditNoteState;
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
    public final String viewName="Edit Note";
    private final EditNoteViewModel editNoteViewModel;

    final JTextField filenameInputField = new JTextField(100);
    private final JLabel filenameErrorField = new JLabel();

    private final JButton edit;
    private final JButton cancel;
    private final JButton clear;
    private final JButton export;
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
        clear = new JButton(clearNoteViewModel.CLEAR_BUTTON_LABEL);
        buttons.add(clear);
        export = new JButton(outNoteViewModel.EXPORT_BUTTON_LABEL);
        buttons.add(export);

        edit.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(edit)) {
                            EditNoteState currentState = editNoteViewModel.getState();
                            editNoteController.editNote(currentState.getFilename());
                        }
                    }
                }
        );
        
        cancel.addActionListener(this);
        clear.addActionListener(this);
        export.addActionListener(this);
}
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Function not implemented yet.");
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
