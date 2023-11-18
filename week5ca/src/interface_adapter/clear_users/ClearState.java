package interface_adapter.clear_users;

// TODO Complete me

import interface_adapter.login.LoginState;

import java.util.Set;

public class ClearState {
    private Set<String> deletedUsernames;
    public ClearState() {
        this.deletedUsernames=deletedUsernames;
    }
    public void setdeletedUsername(Set<String> inputusernames){
        this.deletedUsernames=inputusernames;
    }
    public Set<String> getdeletedUsernames(){
        return this.deletedUsernames;
    }
}
