/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcipher;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.Label;
/**
 *
 * @author hiruna
 * Github: https://github.com/hiruna
 * 
 * Thanks to Daniel Miessler for providing the large password list.
 * Github: https://github.com/danielmiessler
 *
 */
public class hcimp extends Application {
    
    @FXML
   private Button btnCheck;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("How Common Is My Password");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        
        //btnCheck.setOnMouseEntered(e->System.out.println("hi"));
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
