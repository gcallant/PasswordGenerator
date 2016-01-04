/**
 * Created by Boyette on 11/19/2015.
 */
import java.util.*;
import java.io.*;

/**
 * @note Generates a password of the users preference and displays the output to the screen
 */
public class Password {
    public static void main(String[]args){
        /**@brief ASK THE USER FOR HOW LONG THEY WANT THE PASSWORD TO BE
         *
         * @note Most passwords are between 6 to 12 characters long so that is what we will do return the password correctly.
         *
         *@note ADD: Ask user if they want to save their results to a file.
         *
         *@note ADD: Ask user how many symbols they want in their password.
         *
         */
        int choice, numOfSyms;
        boolean wantSymbols = false, wantDigits = false, onlyDigits = false, writeToFile = false;
        PrintStream fout = null;
        String digits = "digits", symbols = "symbols", results = "";

        Scanner kb = new Scanner(System.in);


        choice = Choice.readChoice(kb);
        numOfSyms = Choice.readSymbolChoice(kb);
        onlyDigits = Choice.readChoiceForDigits(kb);
        //If the user does not want only digits, then the program will ask whether they want to add symbols and digits
        if(onlyDigits){
            wantSymbols = Choice.readChoices(kb, symbols);
            wantDigits = Choice.readChoices(kb, digits);
        }

        else{
            System.out.println("Generating a password of " + choice + " digits long");

            results = PasswordGenerator.generatePasswordForDigits(choice);

            writeFile(kb, fout, writeToFile, results);


        }

        //Generates password here. Will ask user if they want to write the results to the file or not.

        System.out.println("Generating a password of " + choice + " characters long");

        results = PasswordGenerator.generatePassword(choice, wantSymbols, wantDigits);

        System.out.println("This is your password: " + results);

        writeFile(kb, fout, writeToFile, results);
        /**@note One of these days I will add the option to write it to the file
         *
         *@note Do generating for a PIN as well.
         */


    }//end main

}
