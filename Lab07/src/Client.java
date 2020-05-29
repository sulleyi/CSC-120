/**
 * Author: Ian Sulley
 *
 * Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus.
 */


import java.util.Scanner;

public class Client {
    /**
     *main die game
     *
     * rolls a 6 sided die and a 12 sided die
     * if the 2 * 6 sided die value euquals ther 12 sided die value
     * the game ends
     *
     * @param args None
     */
    public static void main(String[] args){

        boolean gameOver = false; // intial the game as not over

        while(!gameOver) { //while the game is not over keep playing!

            Die die1 = new Die(); //new 6 sided die object
            Die die2 = new Die(12); //12 sided die object

            //roll each die
            die1.roll();
            die2.roll();

            //hold on to the values of each die
            int die1Value = die1.getValue();
            int die2Value = die2.getValue();

            //Print the results of the roll
            System.out.print("Die 1 (6 sided die value): ");
            System.out.println(die1Value);
            System.out.print("Die 2 (12 sided die value): ");
            System.out.println(die2Value);



            if(die1Value * 2 == die2Value){ //see if game is won or not
                    gameOver = true; //if the game is won, it is over
                    System.out.print(" Die 1 times 2 equals Die 2. Congratulations, you win!");
            }

            else{
                gameOver = false; //else you keep playing!
                System.out.print("Press enter/return to continue");
                Scanner myScanner = new Scanner(System.in); // new scanner object
                myScanner.nextLine(); // user input
            }

        }
    }








}
