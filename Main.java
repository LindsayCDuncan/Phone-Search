import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Start your program here
        
        //try with resources is not supported with this ide plugin from the MOOC :(
        Scanner scanner = new Scanner(System.in); 
        Prompter prompter = new Prompter(scanner);
        OutputWriter writer = new OutputWriter();
        PhoneBook book = new PhoneBook();
        CaseMaker caseMaker = new CaseMaker(book, writer, prompter);
        
        PhoneSearchOperator operator = new PhoneSearchOperator(caseMaker, 
            writer, prompter);
        
        operator.begin();
        prompter.close();
    }
}
