package interface_adapter.clear_users;
import interface_adapter.ViewModel;

import javax.swing.*;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Set;

// TODO Complete me

public class ClearViewModel extends ViewModel {
    public Set<String> deletedUsernames;
    private ClearState state = new ClearState();
    public static final String OK_BUTTON_LABEL = "ok";
    public ClearViewModel() {
        super("clear");
    }

    //state set up
    public void setState(ClearState state) {
        this.state = state;
    }
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    @Override
    public void firePropertyChanged() {
        support.firePropertyChange("state", null, this.state);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        support.addPropertyChangeListener(listener);
    }
    public ClearState getState() {
        return state;
    }

    //success view set up
    public void getnames(Set<String> names){
        this.deletedUsernames=names;
    }
    public void printUser(){
        String message = "Users deleted successfully:\n";
        Set<String> deletedUsernames = this.deletedUsernames;

        for (String username : deletedUsernames) {
            message += username + "\n";
        }
        JOptionPane.showMessageDialog(null, message);
    }

}
