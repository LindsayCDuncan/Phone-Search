/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author linzi
 */
public class Address {
    
    private final String city;
    private final String street;
    
    public Address(String street, String city){
        this.city = city;
        this.street = street;
    }
    
    
    //equals and hashCode implemented from http://www.technofundo.com/tech/java/equalhash.html - no Lombok yet
    @Override
    public boolean equals (Object o){
        
        if(this == o){
            return true;
        }
        if((o == null) || (o.getClass() != this.getClass())){
            return false;
        }
        
        Address adr = (Address) o;
        
        return (city == adr.city || (city != null && city.equals(adr.city))) &&
                (street == adr.street || (street != null && street.equals(adr.street)));
        
    }
    
    @Override
    public int hashCode(){
        int hash = 7;
        
        hash = 31 * hash + (null == city ? 0 : city.hashCode());
        hash = 31 * hash + (null == street? 0 : street.hashCode());
        
        return hash;
    }
    
    @Override
    public String toString(){
        String str = this.street + " " + this.city;
        
        return str;
    }
}
