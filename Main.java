package org.example;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {

        URL url = null;
        String urlString = "https://api.chucknorris.io/jokes/random";
        try{
            url = new URL(urlString);
        }catch(MalformedURLException e){
System.out.println("Problem in url");
        }

        HttpURLConnection connection = null;
        int responseCode = 0;
try{
connection =(HttpURLConnection)url.openConnection();
responseCode =connection.getResponseCode();
}catch(Exception e){
System.out.println("Connection Problem");
}
//extract information from the connection object

        if(responseCode==200){
            BufferedReader in = null;
            try {
                in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            StringBuilder api = new StringBuilder();
            String readLine = null;

            while(true){
                try {
                    if (!((readLine = in.readLine())!=null)) break;
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                api.append(readLine);
            }try{
                in.close();
            }catch(IOException e){
throw new RuntimeException(e);
            }
            JSONObject jsonAPIresponse = new JSONObject(api.toString());
            System.out.println(jsonAPIresponse.get("categories"));
            System.out.println(jsonAPIresponse.get("created_at"));
            System.out.println(jsonAPIresponse.get("icon_url"));
            System.out.println(jsonAPIresponse.get("id"));
            System.out.println(jsonAPIresponse.get("updated_at"));
            System.out.println(jsonAPIresponse.get("url"));
            System.out.println(jsonAPIresponse.get("value"));
        }else{
            System.out.println("API call could not be made");
        }
    }
}