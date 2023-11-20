package interface_adapter.ClearNote_adapter;
import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import interface_adapter.ViewModel;

public class ClearNoteViewModel extends ViewModel {
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

    @Override
    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }

    @Override
    public String getViewName() {
        return null;
    }
}
