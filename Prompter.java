
import java.io.Closeable;
import java.io.IOException;
import java.util.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author linzi
 */
public class Prompter implements Closeable{
    private final Scanner scanner;
    
    public Prompter(Scanner scanner){
        this.scanner = scanner;
    }
    
    public String retrieveInput(){
        return scanner.nextLine();
    }

    @Override
    public void close() {
        scanner.close();
    }
    
}
