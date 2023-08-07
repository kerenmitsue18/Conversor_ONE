package com.example.appconvertidor.Model;

public abstract class Convert {


    public Convert(String key, String name){
        this.name = name;
        this.key = key;
    }
    private  String name;
    private String  key;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key + " - " + name;
    }
}
