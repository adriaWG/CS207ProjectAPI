package interface_adapter.ClearNote_adapter;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import interface_adapter.ViewModel;

public class ClearNoteViewModel extends ViewModel {
    public final String CLEAR_BUTTON_LABEL = "Clear page";
    private ClearNoteState state = new ClearNoteState();

    public ClearNoteViewModel() {
        super("clear");
    }

    public ClearNoteState getState() {
        return state;
    }

    public void setState(ClearNoteState clearNoteState) {
        state = clearNoteState;
    }

    private final PropertyChangeSupport support = new PropertyChangeSupport(this);
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    public String getViewName() {
        return null;
    }

    public void printSuccess() { JOptionPane.showMessageDialog(null, "File successfully cleared!");}
}
