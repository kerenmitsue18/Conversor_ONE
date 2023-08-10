package com.example.appconvertidor.Model;

import java.util.ArrayList;

public class Temperature extends Convert{

    public Temperature(String key, String name){
        super(key,name);
    }

    public static Double compute(Double value, Convert from, Convert to){
        Double result = 0.0;

        if(from.getKey().equals("°C") &  to.getKey().equals( "°K" ))
            result = value + 273.15;
        if(from.getKey().equals("°C") &  to.getKey().equals( "°F" ))
            result = (value * 9/5) + 32;
        if(from.getKey().equals( "°F" ) & to.getKey().equals( "°C" ))
            result = (value - 32) * 5/9;
        if (from.getKey().equals( "°F" ) & to.getKey().equals( "°K" ))
            result = (value - 32) * 5/9 + 273.15;
        if (from.getKey().equals( "°K" ) & to.getKey().equals( "°C" ))
            result = value - 273.15;
        if (from.getKey().equals( "°K" ) & to.getKey().equals( "°F" ))
            result = (value - 273.15) * 9/5 + 32;
        if(from.equals(to)){
            result = value;
        }

        return result;

    }
    public static ArrayList<Temperature> getTemperature(){
        ArrayList<Temperature> temperature = new ArrayList<>();
        temperature.add( new Temperature( "°C", "Celsius" ) );
        temperature.add( new Temperature( "°K", "Kelvin" ) );
        temperature.add( new Temperature( "°F","Fahrenheit" ));

        return temperature;
    }

}
