package com.example.appconvertidor;

import com.example.appconvertidor.Filter.DecimalFilter;
import com.example.appconvertidor.Model.Currency;
import com.example.appconvertidor.Model.Temperature;
import com.example.appconvertidor.Model.Unit;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.util.converter.DoubleStringConverter;

import java.net.Proxy;
import java.text.DecimalFormat;
import java.util.ListIterator;
import java.util.function.UnaryOperator;

public class ViewController {
    @FXML
    Label title;
    @FXML
    Label txtType;
    @FXML
    Label txtValue;
    @FXML
    ChoiceBox<Unit> choiceOne;
    @FXML
    ChoiceBox<Unit> choiceTwo;

    @FXML
    TextField result;
    @FXML
    TextField input;

    @FXML
    Button btnConvert;

    String type;
    Currency currency = new Currency();



    public void init(String type){
        this.type = type;
        title.setText(type + " Converter");
        txtType.setText( "Type of " + type.toLowerCase() + ":");
        txtValue.setText( "Value of " + type.toLowerCase() + ":" );

        //Formato a los valores
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        TextFormatter<Double> textFormatter = new TextFormatter<>(new DoubleStringConverter(), 0.00, new DecimalFilter() );
        input.setTextFormatter(textFormatter);
        result.setTextFormatter(textFormatter);


    }
    public void typeConvert(String type) {

        init(type);

        switch (this.type){
            case "Currency":
                choiceOne.setItems( FXCollections.observableArrayList(currency.getUnits()) );
                choiceTwo.setItems( FXCollections.observableArrayList(currency.getUnits()) );
                break;
            case "Temperature":

                break;
            case "Data":
               break;
            case "Time":
                break;
        }

        //valores por defecto
        choiceOne.getSelectionModel().select(0);
        choiceTwo.getSelectionModel().select(1);
    }

    public void convert(ActionEvent actionEvent) {

        //obtener valores de los componentes

         String to = choiceTwo.getValue().toString();
         Double value = Double.valueOf( input.getText() );



        switch (this.type){
            case "Currency":
                currency.converter( value,choiceOne.getValue(),choiceTwo.getValue());
                break;
            case "Temperature":
                break;
            case "Data":
                break;
            case "Time":
                break;

        }

    }

    public void back(ActionEvent actionEvent) {

    }
}
