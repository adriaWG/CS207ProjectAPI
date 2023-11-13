package interface_adapter;

public class OpenNoteState {
    public boolean isAuthenticated;
    private String errorMessage;

    public OpenNoteState(){
        // initialise the state
        isAuthenticated = false;
        errorMessage = null;
    }

    public boolean isAuthenticated(){
        return isAuthenticated;
    }

    public void setAuthenticated(boolean isAuthenticated){
        this.isAuthenticated = isAuthenticated;
    }

    public String getErrorMessage(){
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage){
        this.errorMessage = errorMessage;
    }
}
