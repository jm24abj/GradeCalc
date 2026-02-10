package com.jackmilner.gradecalc;

import java.io.IOException;
import javafx.fxml.FXML;


public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void addModule() throws IOException {
        // occurs when #addModule button in the side panel is pressed
        App.createModuleNameField();
        
    }
    
    @FXML
    private void addExam() throws IOException {
        // occurs when #addModule button in the side panel is pressed
        App.createExamNameField();
        
    }
}
