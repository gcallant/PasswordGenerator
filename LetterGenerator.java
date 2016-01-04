/**
 * Created by Boyette on 11/19/2015.
 */


public class LetterGenerator {
    private String[] alphabet = new String[]{"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
            "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String letter = null;

    /**@brief A Letter Generator
     *
     * @note creates a new letterGenerator object.
     */
    public LetterGenerator(){
        this.letter = null;
    }

    /**@brief returns the length of the array
     *
     *
     *  @return int length
     */
    public int getLength(){
        return this.alphabet.length;
    }

    /**@brief grabs a letter from the private array using a randomly generated number.
     *
     * @return returns the letter that was set
     */
    public String getLetter(){
        return this.letter;
    }

    /**
     * @brief Takes in a random integer (within the range of the array)
     *
     * @brief Sets a letter to the variable, letter, with that random value
     *
     * @note if integer % 2 == 0, then set letter to upper case
     *
     * @note elsewise, lower case
     *
     * @param randomNum a random number within the range of the array
     */
    public void setLetter(int randomNum){
        if(randomNum < 0 || randomNum > this.alphabet.length){
            throw new IndexOutOfBoundsException();
        }
        if(randomNum % 2 == 0){
            this.letter = this.alphabet[randomNum].toUpperCase();

        }
        else
            this.letter = this.alphabet[randomNum];
    }
}
