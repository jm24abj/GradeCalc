package com.jackmilner.gradecalc;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
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
    @FXML
    private TextField yourMarkField;
    @FXML
    private TextField maxMarkField;
    @FXML
    private TextField examWeightingField;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Label createExamLabel(String nameOfExam) {
        Label nameLabel = new Label();
        nameLabel.setText(nameOfExam);
        nameLabel.setFont(new Font("System",18.0));
        nameLabel.setMaxWidth(Double.MAX_VALUE);
        VBox.setMargin(nameLabel, new Insets(0,10,0,10));
        nameLabel.setTextFill(new Color(1.0, 1.0, 1.0, 1.0));
        nameLabel.setTextAlignment(TextAlignment.LEFT);
        return nameLabel;
    }
    
    private boolean validMarks() {
        return false;
    }
    
    private boolean validWeight() {
        return false;
    }
    
    private boolean validIntegerField(String fieldText, boolean isRequired) { // used to validate fields so they can be assumed as integers in addExam()

        if (fieldText.length() < 1 & isRequired) {
            System.out.println("this field must not be empty!");
            return false;
        } 
        
        for (int i = 0; i < fieldText.length(); i++) {
            String newCharacter = "" + fieldText.charAt(i);

            if (!newCharacter.matches("[0-9]")) {
                System.out.println(fieldText + " isnt valid | char : " + newCharacter);
                return false;
            }
        }
        
        return true;
    }
    
    @FXML
    private void addExam(ActionEvent event) {

        String name = examName.getText(); // name of new exam

        // fields every new exam contains
        String currentMark = yourMarkField.getText();
        String maxMark = maxMarkField.getText();
        String weight = examWeightingField.getText();
        
        boolean nameEntered = name.length() > 0;
        boolean validFields = validIntegerField(currentMark,false) & validIntegerField(maxMark,true) & validIntegerField(weight,true); 
        
        // input validation
        
        if (!nameEntered) {
            System.out.println("name must be entered");
            return;
        }
        
        if (!validFields) {
            return;
        }
        
        // if reached then all inputs are valid and ui can be created
        
        examWeightingField.setText(weight + "%"); // adds % sign to make it more clear its percentage weighting
        Label newExam = createExamLabel(name);

        // adding new exam to ui

        examUI.getChildren().remove(addExamButton); 
        examUI.getChildren().remove(examName);
        examUI.getChildren().add(0, newExam);
        
        
    }

}
