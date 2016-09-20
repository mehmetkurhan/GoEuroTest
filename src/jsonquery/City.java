/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonquery;

/**
 *
 * @author ASUS
 */
public class City {
    
    private int id;
    private String name;
    private String type;
    private GeoPosition location;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the location
     */
    public GeoPosition getLocation() {
        return location;
    }

    /**
     * @param location the location to set
     */
    public void setLocation(GeoPosition location) {
        this.location = location;
    }
    
    
}
