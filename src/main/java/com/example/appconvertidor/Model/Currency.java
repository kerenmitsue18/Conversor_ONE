package com.example.appconvertidor.Model;

import java.util.ArrayList;

public class Currency implements Converter {

    private ArrayList<Unit> units = new ArrayList<>();

    public Currency(){
        units.add(new Unit("MXN - Peso Mexicano",1.0) );
        units.add(new Unit( "USD - Dolar Estadounidense", 0.058 ));
        units.add(new Unit( "GBP - Libra Escarlina", 0.045));
        units.add(new Unit( "JPY - Yen Japonés",  8.31));
        units.add(new Unit( "KRW - Won Surcoreano ",  75.98));
    }

    public ArrayList<Unit> getUnits() {
        return units;
    }

    public void setUnits(ArrayList<Unit> units) {
        this.units = units;
    }

    @Override
    public Double converter(double value, Unit from, Unit to) {
        return value * (from.getValue()/ to.getValue());
    }




}
