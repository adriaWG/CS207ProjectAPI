package use_case.clear_users;

// TODO Complete me

import entity.User;
import interface_adapter.clear_users.ClearPresenter;
import use_case.clear_users.*;
import use_case.signup.SignupOutputBoundary;

import java.util.Set;

public class ClearInteractor implements ClearInputBoundary{
    final ClearUserDataAccessInterface userDataAccessObject;
    final ClearOutputBoundary clearPresenter;


    public ClearInteractor(ClearUserDataAccessInterface userDataAccessInterface,ClearOutputBoundary clearPresenter) {
        this.userDataAccessObject = userDataAccessInterface;
        this.clearPresenter = clearPresenter;
    }
    @Override
    public Set<String> execute() {
        Set<String> allUsernames = userDataAccessObject.getAllUsernames();
        ClearOutputData clearOutputData=new ClearOutputData(allUsernames);
        userDataAccessObject.deleteUser(allUsernames);
        return clearOutputData.getDeletedUsernames();
    }

}
