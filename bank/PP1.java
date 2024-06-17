package bank;

import java.io.Console;
import java.util.Arrays;

public class PP1 {
    public static void main(String[] args) {
        Console console = System.console();
        char[] password = console.readPassword("Enter password");  
         Arrays.fill(password, '*');
    }
}
