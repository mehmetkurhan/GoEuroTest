/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonquery;
import java.io.InputStream;
import java.net.*;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.json.JSONException;
import org.json.simple.JSONObject;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Reader {

 
    

    private String read(String queryString){
        URL url;
        String result = "";
        try {
        url = new URL(queryString);
        InputStream stream = url.openStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
        StringBuilder b = new StringBuilder();
        String line;
          while((line = reader.readLine()) != null) {
            b.append(line);
           
          }
         result = b.toString();
        } catch(Exception ex) {
            if(ex instanceof IOException) {
                System.out.println("Server error.");
        } else if(ex instanceof MalformedURLException) {
            System.out.println(queryString + " is invalid.");
           }  
        }
     return result;
    }
      public ArrayList<City> readCities(Query queryString) {
          ArrayList<City> cities = new ArrayList<>();
          String json = read(queryString.getQueryString());
          if(json != null && !json.isEmpty()) {
             JSONParser parser = new JSONParser();
             try {
        
             Object obj = parser.parse(json);
             JSONArray array = (JSONArray)obj;
             for (Object cityJson : array) {
                    JSONObject c = (JSONObject)cityJson;
                    City city = new City();
                    city.setName(c.get("name").toString());
                    city.setId(Integer.parseInt(c.get("_id").toString()));
                    city.setType(c.get("type").toString());
                    JSONObject loc = (JSONObject)c.get("geo_position");
                    GeoPosition pos = new GeoPosition();
                    pos.setLatitude(Double.parseDouble(loc.get("latitude").toString()));
                    pos.setLongitude(Double.parseDouble(loc.get("longitude").toString()));
                    city.setLocation(pos);
                    cities.add(city);
                 }
             } catch(Exception ex) {
                 if(ex instanceof JSONException || ex instanceof ParseException) {
                     System.out.println(json + " is not a valid json.");
                    
                 } else {
                     System.out.println("Unknown exception.");
                 }
                 ex.printStackTrace();
             } 
          } 
          return cities;
      }
    
}
