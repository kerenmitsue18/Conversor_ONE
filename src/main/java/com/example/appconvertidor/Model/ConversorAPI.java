package com.example.appconvertidor.Model;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONObject;

import java.io.IOException;

public class ConversorAPI {

    public static String url(double valor, String origen, String destino) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().build();
        Request request = new Request.Builder()
                .url("https://api.apilayer.com/exchangerates_data/convert?to="+origen+"&from="+destino+"&amount="+valor)
                .addHeader("apikey", "HC8n3jDYhD2q4jxVDmH2vsR3X0amZpsm")
                .build();
        Response response = client.newCall(request).execute();
        String jsonbody = response.body().string();


        int indAmount = jsonbody.indexOf( "result" );
        String cantidad = ConversorAPI.findDigital(jsonbody.substring( (indAmount+9) ));

        //System.out.println(jsonbody);
        System.out.println("El texto inicia en el indice, "+ cantidad.substring( 0,cantidad.length()-2 ) );

        return cantidad.substring( 0,cantidad.length()-2 );
    }

    public static String findDigital(String s){
        String[] cadena = s.split( " " );
        for (int i = 0; i < cadena.length; i++){
            String palabra  = cadena[i];
            for (int j = 0; j < palabra.length(); j++ ){
                char c = s.charAt(j);
                if (c < '0' || c > '9') {
                    return palabra;
                }
            }
        }
        return null;
    }
}
