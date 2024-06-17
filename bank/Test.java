package bank;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test 
{   
    public static void main(String[] args) 
    {   
        Console console = System.console();

        console.printf("Please enter your username: ");
        String username = console.readLine();
        console.printf(username + "\n");

        console.printf("Please enter your password: ");
        char[] passwordChars = console.readPassword("*");
        String passwordString = new String(passwordChars);

        console.printf(passwordString + "\n");
    }
}
