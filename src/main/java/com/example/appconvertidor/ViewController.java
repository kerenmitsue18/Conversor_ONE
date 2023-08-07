package com.example.appconvertidor;

import com.example.appconvertidor.Filter.DecimalFilter;
import com.example.appconvertidor.Model.ConversorAPI;
import com.example.appconvertidor.Model.Convert;
import com.example.appconvertidor.Model.Temperature;
import com.example.appconvertidor.Model.Unit;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.DoubleStringConverter;


import java.io.IOException;
import java.text.DecimalFormat;
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

    public void init(String type){
        this.type = type;
        title.setText(type + " Converter");
        txtType.setText( "Type of " + type.toLowerCase() + ":");
        txtValue.setText( "Value of " + type.toLowerCase() + ":" );

        //Formato a los valores
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.00, new DecimalFilter() );
        input.setTextFormatter(textFormatter);
        //result.setTextFormatter(textFormatter);

    }
    public void typeConvert(String type) {

        init(type);

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
                    result.setText( value_result );
                } catch (IOException e) {
                    throw new RuntimeException( e );
                }
                break;
            case "Temperature":
                value_result = String.valueOf( Temperature.computeTemperature( value,
                        (Temperature) choiceOne.getValue(), (Temperature) choiceTwo.getValue() ) );
                result.setText( value_result );
                break;
            case "Data":
                break;
            case "Time":
                break;

            default:
                throw new IllegalStateException( "Unexpected value: " + this.type );
        }

    }


    public void back(ActionEvent actionEvent) {

    }
    




}
