/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jcipher;
//
import static java.awt.Color.WHITE;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.io.*;
import java.util.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


/**
 *
 * @author hiruna
 * Github: https://github.com/hirun
 * 
 * Thanks to Daniel Miessler for providing the large password list.
 * Github: https://github.com/danielmiessler
 */
public class MainController implements Initializable  {
    
   @FXML
   private Button btnCheck;
   @FXML
   private TextField txtInPass;
 
 
   
   
   @FXML
   public void checkPass(ActionEvent event) throws Exception{
   String passDicPath = "https://raw.githubusercontent.com/danielmiessler/SecLists/master/Passwords/10_million_password_list_top_1000000.txt";
   String foundArr[] = new String[1000000];
   String currPass = "null";
   boolean found = false;
   boolean notFound = false;
   
   try{
       //File file = new File("com/jcipher/10_million_password_list_top_1000000.txt");
       InputStream file = getClass().getResourceAsStream("10_million_password_list_top_1000000.txt");
       Scanner fin = new Scanner(file);
        String inpPass = txtInPass.getText();
       int curr = 0;
       while(fin.hasNextLine()){
         currPass = fin.nextLine();
         if(currPass.contains(inpPass)){
            //System.out.println("Password Found!");
            foundArr[curr] = currPass;
            curr++;
            found = true;
         }
         else{
            notFound = true;
         }
      }
       fin.close();
      if(notFound == true && found == false){
        Alert fnf = new Alert(AlertType.WARNING);
        fnf.setTitle("No matches - hcimp");
        fnf.setHeaderText("Password not found!");
        fnf.setContentText("Your password is not commonly used.");
        fnf.showAndWait();
      }
      
      if(curr>0){
          
         String strPcont = curr + " passwords found containing \"" + inpPass +
               "\".\n";
         showResults(foundArr,curr,strPcont);
         //System.out.println(curr + " passwords found containing \"" + inpPass +
         //      "\".\n");
         //for(int i=0;i<curr;i++){
          //  System.out.println(i+1 + ". " + foundArr[i]);
         //}
      }
   }catch(Exception e){
       //e.printStackTrace();
       showIOException();
   }
   
   
      
               
   }
    
    public void showIOException(){
        Alert fnf = new Alert(AlertType.ERROR);
        fnf.setTitle("How Common Is My Password ?");
        fnf.setHeaderText("File not found!");
        fnf.setContentText("The password dictionary file was not found.");
        fnf.showAndWait();
    }
    public void showResults(String foundArr[],int curr,String strPcont) {
        String strResults = "";
        
        for(int i=0;i<curr;i++){
            strResults += i+1 + ". " + foundArr[i] + "\n";
        }
      
         
             
            AnchorPane ap = new AnchorPane();
            TextArea txtResults = new TextArea();
            Text lblPcont = new Text(strPcont);
            txtResults.setEditable(false);
            txtResults.setLayoutX(7.0);
            txtResults.setLayoutY(30.0);
            txtResults.setPrefHeight(162.0);
            txtResults.setPrefWidth(307.0);
            txtResults.appendText(strResults);
            lblPcont.setLayoutX(14.0);
            lblPcont.setLayoutY(23.0);
            lblPcont.setFill(Color.WHITE);
            
            ap.setStyle("-fx-background-color: #000000");
            ap.getChildren().addAll(txtResults,lblPcont);
            Scene sc = new Scene(ap,320,200);
            
            Stage stage = new Stage();
            
            stage.initModality(Modality.APPLICATION_MODAL);
            //stage.initStyle(StageStyle.UNDECORATED);
            stage.setTitle("Results - hcimp");
            stage.setScene(sc);  
            stage.show();
           
                
        
        
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

