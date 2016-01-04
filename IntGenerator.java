/**
 * Created by Boyette on 11/19/2015.
 */

public class IntGenerator {
    private int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}; //9
    private int num;

    /**
     * @brief creates a new IntGenerator Object
     */
    public IntGenerator(){
        this.num = 0;
    }

    /**
     *
     * @return the length of the IntGenerator array
     */

    public int getLength(){
        return this.nums.length;
    }

    /**
     *
     * @0return returns the num that was assigned a random value
     */

    public String getNum(){
        return Integer.toString(this.num);
    }

    /**
     * Sets num to a random number within the array
     * @param randomNum a random number that is within the range of the IntGenerator array.
     */

    public void setNum(int randomNum){
        if(randomNum < 0 || randomNum > this.nums.length){
            throw new IndexOutOfBoundsException();
        }

        this.num = this.nums[randomNum];
    }
}
