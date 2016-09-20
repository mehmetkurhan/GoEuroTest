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
public class GeoPosition {
    
    private double latitude;
    private double longitude;
    
    
    public double getLongitude() {
        return this.longitude;
    }
    public void setLongitude(double lng) {
        if(lng < -180 || lng > 180) {
            throw new IllegalArgumentException("Longitude value " + lng +" is invalid");
        } else {
            this.longitude = lng;
        }
    }
    public double getLatitude() {
        return this.latitude;
    }
    public void setLatitude(double lat) {
        if(lat < -90 || lat > 90) {
            throw new IllegalArgumentException("Lattitude value " + lat + " is invalid.");
        } else {
            this.latitude = lat;
        }
    }
    
    
}
