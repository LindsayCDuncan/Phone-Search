/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.*;
/**
 *
 * @author linzi
 */
public class Person implements Comparable<Person>{
    
    private final String name;
    private final Set<String> phoneNumbers;
    private final Set<Address> addresses;
    
    public Person(String name){
        this.name = name;
        phoneNumbers = new HashSet<String>();
        addresses = new HashSet<Address>();
    }
    
    public void addPhoneNumber(String number){
        phoneNumbers.add(number);
    }
    
    public void addAddress(Address adr){
        addresses.add(adr);
    }
    
    public String printPhoneNumbers(){
        String numbers = "";
        if(!phoneNumbers.isEmpty()){
            for(String number : phoneNumbers){
                numbers += "   " + number + "\n";
            }
        }       
        else{
            numbers = " phone number not found\n";
        }
        return numbers;
    }
    
    public String printAddresses(){
        if(!addresses.isEmpty()){
            for(Address adr : addresses){
                return adr.toString();
            }
        }
        return "address unknown";
    }
    
    public String getName(){
        return this.name;
    }
    
    public boolean isInPhoneNumbers(String otherNumber){
        for(String number : phoneNumbers){
            if (number.equals(otherNumber)){
                return true;
            }           
        }
        return false;
    }
    
    public boolean isInAddresses(String word){
        for(Address adr : addresses){ 
            if(adr.toString().contains(word)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Person o) {
        int value = this.getName().compareToIgnoreCase(o.getName());
        return value;
    }
    
    public String toString(){
        String str = "  address: " + this.printAddresses() +
                "\n  phone numbers: \n" + this.printPhoneNumbers();
        return str;
    }
}
