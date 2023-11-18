package interface_adapter.OpenNote_adapter;

public class OpenNoteController {
    private final OpenNoteViewModel viewModel;
    public OpenNoteController(OpenNoteViewModel viewModel){
        this.viewModel = viewModel;
    }

    public void handleCreateNote(){
        viewModel.createNote();
    }
}
