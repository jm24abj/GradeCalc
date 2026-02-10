package com.jackmilner.gradecalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ModuleUIController implements Initializable {
   
    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        // TODO
        System.out.println("init");
    }

    public Button instantiateModule(Button newButton,String name) {
        newButton.setText(name);
        newButton.setMaxWidth(Double.MAX_VALUE);
        return newButton;
    }
}
