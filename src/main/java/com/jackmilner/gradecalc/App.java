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

/**
 * JavaFX App
 */
public class App extends Application {
    

    private static Scene scene;
    private static VBox moduleHolder;
    private static boolean addingModule = false;

    @Override
    public void start(Stage stage) throws IOException {
        
        // called when first running application
       
        scene = new Scene(loadFXML("primary"), 960, 540);
        stage.setScene(scene);
        stage.show();
        
        // initialising ui elements
        
        moduleHolder = (VBox) scene.lookup("#moduleHolder");
        System.out.println(moduleHolder);
    }
    
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    static void createModuleNameField() {
        
        System.out.println("in");
        
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
                createModule(newModuleName.getText());
            }
        });
    }
    
    static void createModule(String moduleName) {
        if (!addingModule) {
            return;
        }
      
        addingModule = false;
        
        System.out.println("new module: " + moduleName + " added!");
    }
    
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}