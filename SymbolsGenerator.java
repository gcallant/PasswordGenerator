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
        this.symbol = null;
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
            throw new IndexOutOfBoundsException();
        }
        this.symbol = this.symbols[randomNum];
    }
}
