package use_case.clear_users;

// TODO Complete me

import java.util.HashSet;
import java.util.Set;

public class ClearOutputData{
    private Set<String> deletedUsernames;

    public ClearOutputData(Set<String> deletedusernames) {
        this.deletedUsernames = new HashSet<>(deletedusernames);
    }
    public void setdeletedUsernames(Set<String> deletedusernames) {
        this.deletedUsernames = deletedusernames;
    }
    public Set<String> getDeletedUsernames() {
        return deletedUsernames;
    }
}
