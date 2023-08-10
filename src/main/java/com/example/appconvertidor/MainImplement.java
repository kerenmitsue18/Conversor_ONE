package com.example.appconvertidor;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainImplement extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {

        primaryStage.setTitle("Convertidor");
        Parent root = FXMLLoader.load( getClass().getResource( "mainConverter.fxml"));
        Scene scence = new Scene(root,300,300);
        scence.getStylesheets().add(getClass().getResource( "main.css" ).toExternalForm());

        primaryStage.setScene(scence);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    public static void main(String[] args) {
        launch();
    }


}