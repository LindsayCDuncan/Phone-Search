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
public class PhoneBook {
    
    private final Map<String, Person> phoneBook;
    
    public PhoneBook(){
        phoneBook = new HashMap<String, Person>();
    }
      
    public void addPersonToBook(String name){
        if(!phoneBook.containsKey(name)){
            phoneBook.put(name, new Person(name));
        }
    }
    
    public void addPhoneNumberToPerson(String name, String number){
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).addPhoneNumber(number);
        }
        else{
            addPersonToBook(name);
            addPhoneNumberToPerson(name, number);
        }
    }
    
    public void addAddressToPerson(String name, Address adr){
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).addAddress(adr);
        }
        else{
            addPersonToBook(name);
            addAddressToPerson(name, adr);
        }
    }
    
    public void removePersonFromBook(String name){
        if(phoneBook.containsKey(name)){
            phoneBook.remove(name);
        }
    }
    
    public String searchForPhoneNumberByName(String name){
        if(phoneBook.containsKey(name)){
            return phoneBook.get(name).printPhoneNumbers();
        }
        return "  phone number not found\n";
    }
    
    public String searchForInfoByName(String name){
        if(phoneBook.containsKey(name)){
            return phoneBook.get(name).toString();
        }
        return "  not found\n";
    }
    
    public String searchForNameByPhoneNumber(String number){
        for(String name : phoneBook.keySet()){
            if(phoneBook.get(name).isInPhoneNumbers(number)){
                return " " + phoneBook.get(name).getName() + "\n";
            }
        }
        return "  not found\n";
    }
    
    public List<Person> searchByKeyWord(String word){
        List<Person> searchResults = new ArrayList<Person>();
        
        //Add all persons for empty keyword
        if(word.equals("")){            
            for(String person : phoneBook.keySet()){
                searchResults.add(phoneBook.get(person));
            }
        }
        
        else{
            for(String name : phoneBook.keySet()){
                if(phoneBook.get(name).getName().contains(word) ||
                        phoneBook.get(name).isInAddresses(word)) {
                    searchResults.add(phoneBook.get(name));
                }
            }
        } 
        
        return searchResults;
    }
}
