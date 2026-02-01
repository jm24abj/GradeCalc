package com.jackmilner.gradecalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ModuleUIController implements Initializable {
    
    private static int moduleCount = 0;
    private static Button[] modules = new Button[30];

    @Override
    public void initialize(URL url, ResourceBundle rb) { 
        // TODO
        System.out.println("init");
        moduleCount += 1;
    }

    public void instantiateModule(Button newButton,String name) {
        modules[moduleCount] = newButton;
        newButton.setText(name);
        newButton.setId(String.valueOf(moduleCount));
        newButton.setMaxWidth(Double.MAX_VALUE);
        
        Module module = new Module();
        
        module.addExam(new Exam("In class test 1",72,100,20));
        module.addExam(new Exam("In class test 2",89,100,30));
        module.addExam(new Exam("In class test 3",75,100,50));
       
        String GPA = module.currentModuleGPA();
        System.out.println(GPA);
        
        newButton.setOnAction(event -> {
            System.out.println(newButton.getText());
            System.out.println("id: " + newButton.getId());
        });
    }
}
