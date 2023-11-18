package use_case.clear_users;

// TODO Complete me

import java.util.Set;

public interface ClearOutputBoundary {
    void prepareSuccessView(ClearOutputData response);

    void prepareFailView(String error);

}
