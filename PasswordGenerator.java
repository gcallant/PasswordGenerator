/**
 * Created by Boyette on 11/19/2015.
 */


import java.util.*;

public class PasswordGenerator {

    /**
     *
     * @brief generates a password and returns the result
     *
     * @note hashedGenerator takes classes LetterGenerator, IntGenerator, SymbolsGenerator as its values
     *
     * @note Uses Java's psuedo Random class to hash the values from hashedGenerator
     *
     * @note Adds the hashed values into the linkedList object then remove the objects from the linkedList and concatenates it to String Result
     *
     * @param choice how long the user would like their password to be
     *
     * @param symb determines whether the user wants to have special symbols in their password
     *
     * @param digs determines whether the user wants digits in their passwords
     *
     * @return String result -- the newly generated password.
     *
     * @note make this look somewhat better for peple to read.
     */
    public static String generatePassword(int choice, boolean symb, boolean digs){
        LinkedList<String> randomList = new LinkedList<String>();
        Object[] hashedGenerator;
        //By creating the object, it does not automatically set a letter/num to it.
        LetterGenerator letterGen = new LetterGenerator();
        IntGenerator intGen = new IntGenerator();
        SymbolsGenerator symGen = new SymbolsGenerator();
        //Rand will be used for multiple psuedo-random generations
        Random rand = new Random();
        String result = "";

        try{
            //if the user said yes to both having symbols and digits
            if(symb && digs){
                //then do this
                hashedGenerator = new Object[]{letterGen, intGen, symGen};
                randomList = addToList(hashedGenerator, rand, randomList, choice);

            }
            //if the user said yes to symbols but no to digits
            else if(symb && !digs){
                //then do this
                hashedGenerator = new Object[]{letterGen, symGen};
                randomList = addToList1(hashedGenerator, rand, randomList, choice);
            }
            //If the user wants digits and not symbols
            else if(!symb && digs){
                //then do this
                hashedGenerator = new Object[]{letterGen, intGen};
                randomList = addToList2(hashedGenerator, rand, randomList, choice);
            }
            //Too bad so sad.
            else
                return "No. Program will not make bad passwords\n";

        }catch(Exception e){
            System.out.println("An error occurred. Exiting");
            e.getMessage();
            e.getStackTrace();
            System.exit(-1);
        }

        try{
            for(int i = 0; i < choice; i++){
                result += randomList.remove(rand.nextInt(randomList.size()));
            }
        }catch (Exception e){
            System.out.println("An error occurred when removing Node and data");
            e.getStackTrace();
            System.exit(-1);
        }


        return result;
    }

    public static String generatePasswordForDigits(int choice){


        return null;
    }

    /**
     * @brief Adds values to the list that are randomly generated.
     *
     * @note NOW that the program runs correctly a few changes need to be made:
     *
     * @brief If the character before is the same as the character generated, a new character needs to be generated.
     *
     * @note More than likely, have it spit out a new generator class rather than another random number from the same one.
     *
     * @param hashedGenerator where the generators are stored
     *
     * @param rand the Random value that will be used
     *
     * @param randomList the linkedlist that will store the values
     *
     * @param choice how long the password is.
     *
     * @return The LinkedList<E></E>
     */
    public static LinkedList<String> addToList(Object[] hashedGenerator, Random rand, LinkedList<String> randomList, int choice){
        int i, x, y;
        boolean go = true;
        Object something = "";
        //x will get the value of random of the hashedGenerator array
        //y will get the random value of the length of the generator list in position x
        for(i = 0; i < choice; i++){
            x = rand.nextInt(hashedGenerator.length);
            //LetterGenerator
            if(x == 0){
                y = rand.nextInt(((LetterGenerator)hashedGenerator[x]).getLength());
                ((LetterGenerator)hashedGenerator[x]).setLetter(y);
                go = randomList.add(((LetterGenerator)hashedGenerator[x]).getLetter());

            }
            //IntGenerator
            else if(x == 1){
                y = rand.nextInt(((IntGenerator)hashedGenerator[x]).getLength());
                ((IntGenerator)hashedGenerator[x]).setNum(y);
                go = randomList.add(((IntGenerator)hashedGenerator[x]).getNum());

            }

            //Symbol Generator
            /**NOTES
             * Checking to see if the symbol is the same as the previous symbol
             * If the same, break out of the loop and do something else? Not sure yet
             */
            else{
                y = rand.nextInt(((SymbolsGenerator)hashedGenerator[x]).getLength());
                ((SymbolsGenerator)hashedGenerator[x]).setSymbol(y);
                go = randomList.add(((SymbolsGenerator)hashedGenerator[x]).getSymbol());

            }


        }
        return randomList;
    }

    //These two methods are duplicates of the one above.

    public static LinkedList<String> addToList1(Object[] hashedGenerator, Random rand, LinkedList<String> randomList, int choice){
        int i, x, y;
        boolean go = true;

        for(i = 0; i < choice; i++){
            x = rand.nextInt(hashedGenerator.length);
            //LetterGenerator
            if(x == 0){
                y = rand.nextInt(((LetterGenerator)hashedGenerator[x]).getLength());
                ((LetterGenerator)hashedGenerator[x]).setLetter(y);
                go = randomList.add(((LetterGenerator)hashedGenerator[x]).getLetter());
            }
            else{
                y = rand.nextInt(((SymbolsGenerator)hashedGenerator[x]).getLength());
                ((SymbolsGenerator)hashedGenerator[x]).setSymbol(y);
                go = randomList.add(((SymbolsGenerator)hashedGenerator[x]).getSymbol());
            }

        }


        return randomList;
    }

    public static LinkedList<String> addToList2(Object[] hashedGenerator, Random rand, LinkedList<String> randomList, int choice){
        int i, x, y;
        boolean go = true;

        for(i = 0; i < choice; i++){
            x = rand.nextInt(hashedGenerator.length);
            //LetterGenerator
            if(x == 0){
                y = rand.nextInt(((LetterGenerator)hashedGenerator[x]).getLength());
                ((LetterGenerator)hashedGenerator[x]).setLetter(y);
                go = randomList.add(((LetterGenerator)hashedGenerator[x]).getLetter());
            }
            else{
                y = rand.nextInt(((IntGenerator)hashedGenerator[x]).getLength());
                ((IntGenerator)hashedGenerator[x]).setNum(y);
                go = randomList.add(((IntGenerator) hashedGenerator[x]).getNum());
            }

        }


        return randomList;
    }
}//end class
