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
public class QueryBuilder {
    
    private Query query;
    private String language = "en"; //English as default
    private String city;
    public QueryBuilder setLanguage(String language) {
        this.language = language;
        return this;
    }
    public QueryBuilder(Query query) {
        this.query = query;
    }
    public QueryBuilder setCity(String city) {
     
        this.city = city;
        return this;
    }
    public Query build() {
        
        query.addConstraint(language);
        query.addConstraint(city);
        return query;
    }
}
