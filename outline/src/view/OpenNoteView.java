package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyChangeListener;

import interface_adapter.EditNote_adapter.EditNoteController;
import interface_adapter.EditNote_adapter.EditNoteViewModel;
import interface_adapter.OpenNote_adapter.OpenNoteController;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;

import javax.swing.*;

import java.beans.PropertyChangeEvent;

public class OpenNoteView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName="Open Note";
    private final OpenNoteViewModel openNoteViewModel;

    final JTextField filenameInputField = new JTextField(20);
    private final JLabel filenameErrorField = new JLabel();

    private final JButton open;
    private final JButton cancel;
    private final JButton new_file;
    private final OpenNoteController openNoteController;



    public OpenNoteView(OpenNoteViewModel openNoteViewModel, OpenNoteController controller) {

        this.openNoteController = controller;
        this.openNoteViewModel = openNoteViewModel;


        this.openNoteViewModel.addPropertyChangeListener(this);

        JLabel title = new JLabel("Open Note View");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        LabelTextPanel filenameInfo = new LabelTextPanel(
                new JLabel("Filename"), filenameInputField);

        JPanel buttons = new JPanel();
        open = new JButton(openNoteViewModel.OPEN_BUTTON_LABEL);
        buttons.add(open);
        new_file = new JButton(openNoteViewModel.NEW_BUTTON_LABEL);
        buttons.add(new_file);
        cancel = new JButton(openNoteViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);



        open.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(open)) {
                            OpenNoteState currentState = openNoteViewModel.getState();
                            openNoteController.openNote(currentState.getNoteId());

                        }
                    }
                }
        );

        new_file.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(new_file)) {
                            OpenNoteState currentState = openNoteViewModel.getState();
                            openNoteController.newNote(currentState.getNoteId());

                        }
                    }
                }
        );

        cancel.addActionListener(this);

        // This makes a new KeyListener implementing class, instantiates it, and
        // makes it listen to keystrokes in the usernameInputField.
        //
        // Notice how it has access to instance variables in the enclosing class!
        filenameInputField.addKeyListener(
                new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {
                        OpenNoteState currentState = openNoteViewModel.getState();
                        String text = filenameInputField.getText() + e.getKeyChar();
                        currentState.setNoteId(text);
                        openNoteViewModel.setState(currentState);
                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.add(title);
        this.add(filenameInfo);
        this.add(buttons);
}


    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showConfirmDialog(this, "Cancel not implemented yet.");
    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        OpenNoteState state = (OpenNoteState) evt.getNewValue();

        if (state.getNoteIdError() != null) {
            System.out.println(state.getNoteIdError());
            JOptionPane.showMessageDialog(this, state.getNoteIdError());
        }
    }

}

