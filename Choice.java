/**
 * Created by Boyette on 1/4/2016.
 */

import java.util.*;

/**
 * @brief This class will hold choices that the user will be asked.
 */
public class Choice {

    /**
     * @brief reads the choice from the keyboard and returns an integer.
     *
     * @param kb A Scanner object that obtains keyboard input
     *
     * @return returns an integer of how many digits they want their password to be.
     *
     * @note make a better name for the method so it is easier to look at and debug when necessary
     */
    public static int readChoice(Scanner kb){
        //RETURNS THE LENGTH OF THE PASSWORD THAT THE USER SPECIFIES
        //USE TRY CATCH WITHIN A WHILE LOOP TO DETERMINE WHETHER THEY ENTER INVALID INPUT

        int length = 0;
        boolean go = true;
        while(length < 6 || length > 12 || go == true){
            try{
                System.out.print("Enter the length of your password: ");
                length = kb.nextInt();
                //clear the buffer
                kb.nextLine();
                go = false;

            }catch(InputMismatchException e){
                System.out.println("The input you entered is incorrect");
                go = true;
            }
            catch(Exception e){
                System.out.println("An error has occurred. The program will exit now");
                e.getStackTrace();
                System.exit(-1);
            }
        }
        return length;
    }//end method

    /**
     * @brief Asks the user whether they want symbols/other miscellaneous stuff in their passwords
     *
     * @param kb A Scanner object that reads user input
     *
     * @param choice Displays the item they may want to have in their password
     *
     * @return true or false based on choice.
     */
    public static boolean readChoices(Scanner kb, String choice){
        boolean want = false, go = true;
        String answer = "";

        while(go){

            try{
                System.out.print("Do you want " + choice + " in your password? ");
                answer = kb.nextLine();
                if (answer.compareToIgnoreCase("no") == 0)
                    want = false;

                else if(answer.compareToIgnoreCase("yes") == 0)
                    want = true;
                else
                    throw new InputMismatchException();
                go = false;
            }catch(InputMismatchException e){
                System.out.println("The input you entered is incorrect");
                go = true;
            }catch(Exception e){
                System.out.println("An error has occurred. The program will exit now");
                e.getStackTrace();
                System.exit(-1);
            }
        }
        return want;
    }
    /** @brief Asks the user how many symbols they want in their password.
     *
     * @param kb A Scanner object that must be passed in.
     *
     * @return how many symbols the user would like in their password.
     *
     *
     */
    public static int readSymbolChoice(Scanner kb){
        boolean go = true;
        int choice = 0;

        while(go){
            try{
                System.out.println("How many symbols would you like in your password?");
                choice = kb.nextInt();
                if(choice < 0)
                    throw new InputMismatchException();
                go = false;
            }catch(InputMismatchException e){
                System.out.println("Invalid input!");
                go = true;
            }
            catch(Exception e){
                System.out.println("An error occurred");
            }
        }
        return choice;
    }
    public static boolean readChoiceForDigits(Scanner kb){



        return false;
    }

}
