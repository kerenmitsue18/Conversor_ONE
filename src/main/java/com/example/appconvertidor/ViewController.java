package com.example.appconvertidor;

import com.example.appconvertidor.Model.*;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;


import java.io.IOException;
import java.util.ArrayList;


public class ViewController {
    @FXML
    Label title;
    @FXML
    Label txtType;
    @FXML
    Label txtValue;
    @FXML
    ChoiceBox<Convert> choiceOne;
    @FXML
    ChoiceBox<Convert> choiceTwo;

    @FXML
    TextField result;
    @FXML
    TextField input;

    @FXML
    Button btnConvert;

    String type;

    public void getTypeConvert(String type) {

        this.type = type;
        title.setText(type + " Converter");
        txtType.setText( "Type " + type.toLowerCase() + ":");
        txtValue.setText( "Value " + type.toLowerCase() + ":" );

        switch (type){
            case "Currency":
                ArrayList<Unit> currency = Unit.getCurrency();
                choiceOne.setItems( FXCollections.observableArrayList(currency) );
                choiceTwo.setItems( FXCollections.observableArrayList(currency) );
                //valores por defecto
                choiceOne.getSelectionModel().select(1);
                choiceTwo.getSelectionModel().select(13);
                break;
            case "Temperature":
                ArrayList<Temperature> temperature = Temperature.getTemperature();
                choiceOne.setItems( FXCollections.observableArrayList(temperature) );
                choiceTwo.setItems( FXCollections.observableArrayList(temperature) );
                //valores por defecto
                choiceOne.getSelectionModel().select(0);
                choiceTwo.getSelectionModel().select(1);
                break;
            case "Data":
                ArrayList<Data> data = Data.getData();
                choiceOne.setItems( FXCollections.observableArrayList(data) );
                choiceTwo.setItems( FXCollections.observableArrayList(data) );
                choiceOne.getSelectionModel().select(0);
                choiceTwo.getSelectionModel().select(1);
               break;
            case "Time":
                break;
        }


    }

    public void convert(ActionEvent actionEvent) {

         //obtener valores de los componentes
         Double value = Double.valueOf( input.getText().toString() );
         String from = choiceOne.getValue().getKey();
         String to = choiceTwo.getValue().getKey();
         String  value_result = "";

        switch (this.type){
            case "Currency":
                try {
                     value_result = ConversorAPI.url( value,from,to );
                } catch (IOException e) {
                    throw new RuntimeException( e );
                }
                break;
            case "Temperature":
                value_result = String.valueOf( Temperature.compute( value,
                        (Temperature) choiceOne.getValue(), (Temperature) choiceTwo.getValue() ) );
                break;
            case "Data":
                value_result = String.valueOf( Data.compute( value,(Data) choiceOne.getValue(),(Data) choiceTwo.getValue() ) );
                break;
            case "Time":
                break;

            default:
                throw new IllegalStateException( "Unexpected value: " + this.type );
        }
        result.setText( value_result );

    }


    public void back(ActionEvent actionEvent) {

    }
    




}
