package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws IOException {

        URL url = null;
        String urlstring = "https://api.zippopotam.us/us/33162";
        try {
            url = new URL(urlstring);
        } catch (MalformedURLException e) {
            System.out.println("Problem in url");
        }

        //connection

        HttpURLConnection connection = null;
        int responsecode = 0;
        try {
            connection =(HttpURLConnection) url.openConnection();
            responsecode = connection.getResponseCode();
        } catch (Exception e) {
            System.out.println("Connection problem");
        }

        //extract information from the connection object

        if(responsecode==200){
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            StringBuilder api = new StringBuilder();
            String readLine = null;

            while((readLine = in.readLine())!=null){
                api.append(readLine);
            }
            try {
                in.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            JSONObject jsonAPIresponse = new JSONObject(api.toString());

           String s2 = jsonAPIresponse.get("places").toString();

           String ss = s2.substring(1,s2.length()-1);

            JSONObject jsonAPIresponse1 = new JSONObject(ss);
            System.out.println(jsonAPIresponse.get("post code"));
            System.out.println(jsonAPIresponse.get("country"));
            System.out.println(jsonAPIresponse.get("country abbreviation"));
            String []arr = ss.split(",");
            for(String x : arr){
                System.out.println(x);
            }

        }else{
            System.out.println("API call could not be made!!");
        }

    }
}