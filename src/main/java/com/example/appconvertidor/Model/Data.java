package com.example.appconvertidor.Model;

import java.util.ArrayList;

public class Data extends Convert{
    public Data(String key, String name) {
        super( key, name );
    }

    public static ArrayList<Data> getData(){
        ArrayList<Data> data = new ArrayList<>();
        data.add( new Data( "B","Byte") );
        data.add( new Data( "KB","Kilobyte") );
        data.add( new Data( "MB","Megabyte") );
        data.add( new Data( "GB","Gigabyte") );
        data.add( new Data( "TB","Terabyte") );
        data.add( new Data( "PB","Petabyte") );

        return data;
    }

    public static Double compute(Double value, Data from, Data to) {
        Double result = 0.0;

        if (from.getKey().equals( "B" ) & to.getKey().equals( "KB" )
                || from.getKey().equals( "KB" ) & to.getKey().equals( "GB" )
                || from.getKey().equals( "MB" ) & to.getKey().equals( "GB" )
                || from.getKey().equals( "GB" ) & to.getKey().equals( "TB" )
                || from.getKey().equals( "KB" ) & to.getKey().equals( "MB" )
                || from.getKey().equals( "TB" ) & to.getKey().equals( "PB" )
        ) result = value * 0.001;

        if (from.getKey().equals( "B" ) & to.getKey().equals( "MB" )
                || from.getKey().equals( "MB" ) & to.getKey().equals( "TB" )
                || from.getKey().equals( "GB" ) & to.getKey().equals( "PB" )
        ) result = value * 0.000001;

        if (from.getKey().equals( "B" ) & to.getKey().equals( "GB" )
                || from.getKey().equals( "KB" ) & to.getKey().equals( "TB" )
                || from.getKey().equals( "MB" ) & to.getKey().equals( "PB" )
        ) result = value * 1e-9;

        if (from.getKey().equals( "B" ) & to.getKey().equals( "TB" )
                || from.getKey().equals( "KB" ) & to.getKey().equals( "PB" )
        ) result = value * 1e-12;

        if (from.getKey().equals( "KB" ) & to.getKey().equals( "B" )
                || from.getKey().equals( "MB" ) & to.getKey().equals( "KB" )
                || from.getKey().equals( "TB" ) & to.getKey().equals( "GB" )
                || from.getKey().equals( "PB" ) & to.getKey().equals( "TB" )
                || from.getKey().equals( "GB" ) & to.getKey().equals( "MB" )
        ) result = value * 1024;

        if (from.getKey().equals( "MB" ) & to.getKey().equals( "B" )
                || from.getKey().equals( "TB" ) & to.getKey().equals( "MB" )
                || from.getKey().equals( "PB" ) & to.getKey().equals( "GB" )
        ) result = value * 1048576;

        if (from.getKey().equals( "GB" ) & to.getKey().equals( "B" )
                || from.getKey().equals( "GB" ) & to.getKey().equals( "KB" )
        ) result = value * 1073741824;

        if (from.getKey().equals( "TB" ) & to.getKey().equals( "B" )
                || from.getKey().equals( "PB" ) & to.getKey().equals( "KB" )
        ) result = value * 1e12;

        if (from.getKey().equals( "TB" ) & to.getKey().equals( "KB" )
                || from.getKey().equals( "PB" ) & to.getKey().equals( "MB" )
        ) result = value * 1000000000;


        if (from.getKey().equals( "B") & to.getKey().equals("PB"))
            result = value * 1e-15;
        if (from.getKey().equals( "PB") & to.getKey().equals( "B" ))
            result = value * 999999999999999.9;
        if(from.getKey().equals( to.getKey() )){
            result = value;
        }

        return result;
    }



}
