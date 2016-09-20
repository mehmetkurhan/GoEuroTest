/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsonquery;
import java.util.regex.*;
/**
 *
 * @author ASUS
 */
public class Query {
    
    
    private final String API_END_POINT = "http://api.goeuro.com/api/v2/position/suggest";
    private String queryString;
    public Query() {
        queryString = API_END_POINT;

    }
    
    public String getQueryString() {
        
        return this.queryString;
    }
    public void addConstraint(String constraint) {
        StringBuilder query = new StringBuilder(queryString);
        validate(constraint);
        query.append("/").append(constraint);
        queryString = query.toString();
      
    }
    private void validate(String constraint) {
         Pattern p = Pattern.compile("^[a-zA-Z-]*$"); // Only characters and dash
         Matcher m = p.matcher(constraint);
         if(!m.find()) {
             throw new IllegalArgumentException(constraint + " is not valid");
         }
    }
}
