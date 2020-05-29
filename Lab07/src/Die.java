import java.util.*;
public class Die {

    private int numSides; // Number of sides the Die has
    private int currentValue; // Top value of the Die

    /**
     * Die object constructor
     * @param sides number of sides the die has
     */
    Die(int sides){

        numSides = sides;
        currentValue = (int) Math.random() * numSides;

    }

    /**
     * default Die object constructor
     * default number of sides is 6
     */
    Die(){

        numSides = 6; //default number of sides
        currentValue =  (int) Math.random() * numSides;

    }


    /**
     * rolls the Die
     * sets current value to a new value in the range o 1 to numSides
     */
    public void roll(){
        Random rand = new Random();
        int newValue = rand.nextInt(numSides);
        currentValue = newValue + 1;
    }

    /**
     * getter method for current value
     * @return Current value of this Die Object
     */
    public int getValue(){
       return currentValue;
    }
}
