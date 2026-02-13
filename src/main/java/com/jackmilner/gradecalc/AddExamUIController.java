package com.jackmilner.gradecalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;

public class AddExamUIController implements Initializable {

    @FXML
    private VBox examUI;
    @FXML
    private TextField examName;
    @FXML
    private Button addExamButton;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void addExam(ActionEvent event) {
        String name = examName.getText(); // name of new exam
        
        // setting up new fixed label for exam
        
        Label nameLabel = new Label();
        nameLabel.setText(name);
        nameLabel.setFont(new Font("System",18.0));
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        VBox.setMargin(nameLabel, new Insets(0,10,0,10));
        nameLabel.setTextFill(new Color(1.0, 1.0, 1.0, 1.0));
        nameLabel.setTextAlignment(TextAlignment.LEFT);
        // adding to ui tree
        
        examUI.getChildren().remove(addExamButton); // removes add button 
        examUI.getChildren().remove(examName);
        examUI.getChildren().add(0, nameLabel);
    }

}
