package com.example.appconvertidor.Model;

import java.util.ArrayList;


public class Unit extends Convert{


    public Unit(String key, String name) {
        super(key,name);
    }

    public static ArrayList<Unit> getCurrency(){
        ArrayList<Unit> currency = new ArrayList<>();
        currency.add(new Unit("CRC","Colón Costa Rica"));
        currency.add(new Unit( "MXN","Peso Mexicano" ));
        currency.add(new Unit( "GTQ","Quetzal Guatemalteco" ));
        currency.add(new Unit( "BTC","Bitcoin" ));
        currency.add(new Unit(  "UYU","Peso uruguayo"));
        currency.add(new Unit( "SVC","Colón Salvadoreño" ));
        currency.add(new Unit( "ARS","Peso Argentino" ));
        currency.add(new Unit( "CNY","Yuan chino" ));
        currency.add(new Unit( "PHP","Peso filipino" ));
        currency.add(new Unit( "RUB","Rublo Rusia" ));
        currency.add(new Unit( "PYG","Guaraní Paraguayo " ));
        currency.add(new Unit( "JMD","Dólar jamaiquino" ));
        currency.add(new Unit( "COP","Peso Colombiano" ));
        currency.add(new Unit( "USD","Dólar Estado Unidense" ));
        currency.add(new Unit( "CHF","Franco Suizo" ));
        currency.add(new Unit( "ILS","Nuevo séquel Israelí" ));
        currency.add(new Unit("KPW","Won Norcoreano"  ));
        currency.add(new Unit( "BOB","Boliviano Bolivia" ));
        currency.add(new Unit( "CAD","Dólar Canadiense" ));
        currency.add(new Unit( "JPY","Yen Japon" ));
        currency.add(new Unit( "BYR","Rublo Bielorruso" ));
        currency.add(new Unit(  "NIO","Córdoba Nicaragüense"));
        currency.add(new Unit( "PEN","Nuevo sol Peruano" ));
        currency.add(new Unit( "CLF","Unidad Chilena de cuenta (UF)" ));
        currency.add(new Unit( "BRL","Real Brasileño" ));
        return currency;
    }



}
