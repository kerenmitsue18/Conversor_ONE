package com.example.appconvertidor;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import org.jetbrains.annotations.NotNull;


import java.io.IOException;

public class MainConverter {
    @FXML
    private Label welcomeText;
    @FXML
    private Button currency;
    @FXML
    private Button temperature;
    @FXML
    private Button data;
    @FXML
    private Button time;

    @FXML
    protected void type(@NotNull ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("view.fxml"));
        Parent root = loader.load();
        ViewController viewController = loader.getController();

        if(event.getTarget().equals( currency )){
            viewController.getTypeConvert("Currency");
        } else if (event.getTarget().equals( temperature )) {
            viewController.getTypeConvert("Temperature");
        } else if (event.getTarget().equals( data )) {
            viewController.getTypeConvert("Data" );
        }else{
            viewController.getTypeConvert( "Time" );
        }

        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene( root );
        stage.setScene( scene );
        scene.getStylesheets().add(getClass().getResource( "view.css" ).toExternalForm());
        stage.setTitle( "Converter" );
        stage.setResizable(false);
        stage.show();

    }
}