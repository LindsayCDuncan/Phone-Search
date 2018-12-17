
import java.util.Collections;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author linzi
 */
public class CaseMaker {
    private final PhoneBook book;
    private final OutputWriter writer;
    private final Prompter prompter;
    
    public CaseMaker(PhoneBook book, OutputWriter writer, Prompter prompter){
        this.book = book;
        this.writer = writer;
        this.prompter = prompter;
    }
    
    public void retrieveCaseOne(){        
        String name;
        String number;
        
        writer.writeLine("whose number: ");
        name = prompter.retrieveInput();
        writer.writeLine("number: ");
        number = prompter.retrieveInput();
        
        book.addPersonToBook(name);
        book.addPhoneNumberToPerson(name, number);        
    }
    
    public void retrieveCaseTwo(){
        String searchName;
        
        writer.writeLine("whose number: ");
        searchName = prompter.retrieveInput();
        writer.writeLine(book.searchForPhoneNumberByName(searchName));
    }
    
    public void retrieveCaseThree(){
        String searchNum;
        
        writer.writeLine("number: ");
        searchNum = prompter.retrieveInput();
        writer.writeLine(book.searchForNameByPhoneNumber(searchNum));
    }
    
    public void retrieveCaseFour(){
        String name;
        String street;
        String city;
        Address adr;
        
        writer.writeLine("whose address: ");
        name = prompter.retrieveInput();
        writer.writeLine("street: ");
        street = prompter.retrieveInput();
        writer.writeLine("city: ");
        city = prompter.retrieveInput();
        
        adr = new Address(street, city);
        
        book.addAddressToPerson(name, adr);
    }
    
    public void retrieveCaseFive(){
        String name;
        
        writer.writeLine("whose information: ");
        name = prompter.retrieveInput();        
        writer.writeLine(book.searchForInfoByName(name));
    }
    
    public void retrieveCaseSix(){
        String name;
        
        writer.writeLine("whose information: ");
        name = prompter.retrieveInput();
        
        book.removePersonFromBook(name);
    }
    
    public void retrieveCaseSeven(){
        String word;
        List<Person> results;
        
        writer.writeLine("keyword (if empty, all listed): ");
        word = prompter.retrieveInput();
        
        results = book.searchByKeyWord(word);
        
        if(results.isEmpty()){
            writer.writeLine(" not found\n");
        }
        
        else{
            Collections.sort(results); //is it bad to sort this here?
            for(Person person : results){
                writer.writeLine("\n " + person.getName() + "\n" 
                        + person.toString());
            }           
        }
    }
    
}
