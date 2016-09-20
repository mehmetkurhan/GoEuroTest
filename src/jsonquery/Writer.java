/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonquery;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class Writer {
    
    
    public static void writeCity(City city) {
        
    }
    public static void writeCities(ArrayList<City> cities) {
        
        String fileName = "cities.csv";
        PrintWriter writer;
        try {
            writer = new PrintWriter(new File(fileName));
            writer.write("_id,name,type,latitude,longitude");
            writer.write("\n");
            for(City city : cities) {
                String formatString = "%s,%s,%s,%s,%s\n";
                String line = String.format(formatString,
                        String.valueOf(city.getId()),
                        city.getName(),
                        city.getType(),
                        String.valueOf(city.getLocation().getLatitude()),
                        String.valueOf(city.getLocation().getLongitude()));
                writer.write(line);
            }
            writer.close();
        } catch(IOException ex) {
            System.out.println("The file cannot be created");
            ex.printStackTrace();
        } 
    }
}
