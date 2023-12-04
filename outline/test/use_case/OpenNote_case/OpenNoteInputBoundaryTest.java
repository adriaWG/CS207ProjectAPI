package use_case.OpenNote_case;

import junit.framework.TestCase;

public class OpenNoteInputBoundaryTest extends TestCase {

    public void testCreateNote() {
        OpenNoteInputBoundary openNoteInputBoundary = new OpenNoteInputBoundary() {
            @Override
            public void createNote(OpenNoteInputData inputData) {

            }

            @Override
            public void openNote(OpenNoteInputData inputData) {

            }
        };
    }

    public void testOpenNote() {
    }
}