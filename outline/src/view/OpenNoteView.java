package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeListener;

import interface_adapter.OpenNote_adapter.OpenNoteController;
import interface_adapter.OpenNote_adapter.OpenNoteState;
import interface_adapter.OpenNote_adapter.OpenNoteViewModel;

import javax.swing.*;


public class OpenNoteView extends JPanel implements ActionListener, PropertyChangeListener {

    public final String viewName="Open Note";
    private final OpenNoteViewModel openNoteViewModel;

    final JTextField filenameInputField = new JTextField(100);
    private final JLabel filenameErrorField = new JLabel();

    final JButton open;
    final JButton cancel;
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
        cancel = new JButton(openNoteViewModel.CANCEL_BUTTON_LABEL);
        buttons.add(cancel);


        open.addActionListener(
                new ActionListener() {
                    public void actionPerformed(ActionEvent evt) {
                        if (evt.getSource().equals(open)) {
                            OpenNoteState currentState = openNoteViewModel.getState();

                            openNoteController.execute(
                                    currentState.getFilename()
                            );
                        }
                    }
                });







    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void propertyChange(PropertyChangeEvent evt) {

    }
//public class OpenNoteView implements OpenNoteOutputBoundary {
//    private final Scanner scanner;
//    public OpenNoteView(){
//        this.scanner = new Scanner(System.in);
//    }
//
//    public void presentNoteCreated(OpenNoteOutputData outputData){
//        System.out.println("Note ID:" + outputData.getNoteId());
//        System.out.println(outputData.getMessage());
//    }
//
//    public OpenNoteInputData collectNoteInput(){
//        System.out.println("Enter note title:");
//        String title = scanner.nextLine();
//        System.out.println("Enter note content:");
//        String content = scanner.nextLine();
//
//        return new OpenNoteInputData(title, content);
//    }


}


}
