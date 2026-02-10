package com.jackmilner.gradecalc;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import java.io.IOException;
import javafx.scene.input.KeyCode;

public class App extends Application {
    
    private static Scene scene;
    private static VBox moduleHolder;
    private static VBox examHolder;
    private static boolean addingModule = false;
    private static Button[] modules = new Button[30];
    
    @Override
    public void start(Stage stage) throws IOException {
        
        // called when first running application
       
        scene = new Scene(loadFXML("primary"), 960, 540);
        stage.setScene(scene);
        stage.show();
        
        // initialising ui elements
        
        moduleHolder = (VBox) scene.lookup("#moduleHolder");
        System.out.println(moduleHolder);
        
        examHolder = (VBox) scene.lookup("#examHolder");
        System.out.println(moduleHolder);
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void createModuleNameField() throws IOException{
        if (addingModule) {
            return;
        }
        
        System.out.println("Adding module!");
        
        addingModule = true;
        
        TextField newModuleName = new TextField(); 
        moduleHolder.getChildren().add(newModuleName);
        
        // detects key presses until ENTER is pressed
        // will then create the UI for the module as a label
        
        newModuleName.setOnKeyPressed(event -> {
            
            KeyCode keyCode = event.getCode();
                
            if (keyCode.equals(KeyCode.ENTER)) {
                try {
                    createModule(newModuleName.getText());
                } catch(Exception e) {
                    
                }
                moduleHolder.getChildren().remove(newModuleName);
            }
        });
    }
    
    static void createExamNameField() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("addExamUI.fxml"));
        VBox newExam = (VBox) fxmlLoader.load();
        examHolder.getChildren().add(newExam);
    }
    
    static void createModule(String moduleName) throws IOException {
        if (!addingModule) {
            return;
        }
      
        addingModule = false;
        
        System.out.println("new module: " + moduleName + " added!");
        
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("moduleUI.fxml"));
        Button newModule = (Button) fxmlLoader.load();
        ModuleUIController controller = fxmlLoader.getController();
        Button newButton = controller.instantiateModule(newModule, moduleName);
        moduleHolder.getChildren().add(newModule);
        
        Module module = new Module(newButton.getText());
        
        newButton.setOnAction(event -> {
            loadModulePage(module);
        });
    }
    
    static void loadModulePage(Module module) {
        Label moduleNameLabel = (Label) scene.lookup("#moduleName");
        moduleNameLabel.setText(module.getName());
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}