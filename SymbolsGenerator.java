import java.util.Random;

/**
 * Created by Boyette on 11/19/2015.
 */
public class SymbolsGenerator{
    private String[] symbols = new String[]{"!", "@", "#", "$", "%", "^", "&", "*"}; //7
    private String symbol = null;

    /**
     * creates a new SymbolGenerator object
     */
    public SymbolsGenerator(){
        this.symbol = ""; /*Prevents a nullPointerException if class is instantiated, and 
        getLength is called on null string. */
    }

    /**
     * @return returns the length of the symbols array
     */
    public int getLength(){
        return this.symbols.length;
    }

    /**
     *
     * @return returns the symbol
     * @note Need to improve this method if the symbol is null. 
     */

    public String getSymbol(){
        return this.symbol;
    }

    /**
     * sets the letter to a random symbol String
     * @param randomNum a random number that is within the range of the array of Symbol Generator
     */

    public void setSymbol(int randomNum){
        if(randomNum < 0 || randomNum > this.symbols.length){
            Random rand = new Random(System.currentTimeMillis());
            
            //Range of Random Number
            int high = symbols.length - 1;
            int low = 0;
            randomNum = rand.nextInt(high - low) + low; //Zero in this case, but added for convention
        }
        this.symbol = this.symbols[randomNum];
    }
}
