package com.jackmilner.gradecalc;

import java.io.IOException;
import javafx.fxml.FXML;


public class PrimaryController {

    @FXML
    private void switchToSecondary() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void resizeSidePanel() throws IOException {
        
    }
}
