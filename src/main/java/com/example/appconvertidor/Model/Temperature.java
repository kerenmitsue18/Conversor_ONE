package com.example.appconvertidor.Model;

public class Temperature implements Converter{


    private String[] temperature = {"°C - Grado Celcius", "°F - Fahrenheit", "°K - Kelvin"};

    public String[] getTemperature() {
        return temperature;
    }

    @Override
    public Double converter(double value, Unit from, Unit to) {
        return null;
    }
}
