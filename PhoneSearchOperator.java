/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author linzi
 */
public class PhoneSearchOperator {
    private final OutputWriter writer;
    private final CaseMaker caseMaker;
    private final Prompter prompter;

    
    public PhoneSearchOperator(CaseMaker caseMaker,
            OutputWriter writer, Prompter prompter){
        this.caseMaker = caseMaker;
        this.writer = writer;
        this.prompter = prompter;
    }
    
    public void begin(){
        printMenu();
        activeSearch();
    }
    
    public void printMenu(){
        writer.writeLine("phone search\n");
        writer.writeLine("available operations: \n");
        writer.writeLine(" 1 add a number\n" +
                         " 2 search for a number\n" +
                         " 3 search for a person by phone number\n" +
                         " 4 add an address\n" +
                         " 5 search for personal information\n" +
                         " 6 delete personal information\n" +
                         " 7 filtered listing\n" +
                         " x quit\n");
    }
    
    public void activeSearch(){
        char selection;
        
        while(true){
            writer.writeLine("\ncommand: ");
            selection = prompter.retrieveInput().charAt(0);
            
            //This was inside switch for System.exit(0), but the tests provided hated it - would it be bad to have it there?
            if (selection == 'x'){
                break;
            }
            
            switch(selection){
                case '1':
                    caseMaker.retrieveCaseOne(); break;
                case '2':
                    caseMaker.retrieveCaseTwo(); break;
                case '3':
                    caseMaker.retrieveCaseThree(); break;
                case '4':
                    caseMaker.retrieveCaseFour(); break;
                case '5':
                    caseMaker.retrieveCaseFive(); break;
                case '6':
                    caseMaker.retrieveCaseSix(); break;
                case '7':
                    caseMaker.retrieveCaseSeven(); break;
            }
        }
    }
}
