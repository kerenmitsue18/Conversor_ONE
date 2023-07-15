package com.example.appconvertidor.Filter;

import javafx.scene.control.TextFormatter;

import java.util.function.UnaryOperator;

public class DecimalFilter implements UnaryOperator<TextFormatter.Change> {


    @Override
    public TextFormatter.Change apply(TextFormatter.Change change) {
        String newText = change.getControlNewText();

        // Permitir solo dígitos, punto decimal y máximo dos decimales
        if (newText.matches("\\d*\\.?\\d{0,3}")) {
            return change;
        }

        return null;
    };

}
