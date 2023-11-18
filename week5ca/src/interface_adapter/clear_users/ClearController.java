package interface_adapter.clear_users;

import use_case.clear_users.ClearInputBoundary;
import use_case.clear_users.ClearInputData;
import use_case.signup.SignupInputBoundary;
import use_case.signup.SignupInputData;

import javax.swing.*;
import java.util.Set;

// TODO Complete me
public class ClearController {
    //get information, no info given, so just execute
    final ClearInputBoundary userClearUseCaseInteractor;
    public ClearController(ClearInputBoundary userClearUseCaseInteractor) {
        this.userClearUseCaseInteractor = userClearUseCaseInteractor;
    }

    public Set<String> execute() {
        return userClearUseCaseInteractor.execute();
    }


}
