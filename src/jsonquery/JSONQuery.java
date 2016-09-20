/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonquery;

import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class JSONQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if(args.length < 1) {
            System.out.println("You should give city name as argument");
        } else {
            
            String city = args[0];
            Query query = new Query();
            QueryBuilder builder = new QueryBuilder(query);
            query = builder.setCity(city).setLanguage("en").build();
            Reader reader = new Reader();
            ArrayList<City> returnedCities = reader.readCities(query);
            if(returnedCities == null || returnedCities.isEmpty()) {
                System.out.println("The city " + city + " is not found." );
            } else {
                Writer.writeCities(returnedCities);
              }
        }
        
    }
    
}
