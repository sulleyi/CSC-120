package proj4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Author: Ian Sulley
 *
 * Honor Code: I affirm that I have carried out the attached academic endeavors with full academic honesty,
 * in accordance with the Union College Honor Code and the course syllabus
 */
public class Client{


    public static void main(String[] args){

        boolean isOver = false;

        Deck myDeck = new Deck();
        myDeck.shuffle();

        int playerScore = 0;

        while(myDeck.size() > 9 && !isOver){


            ArrayList<Card> cardArrayListCC = new ArrayList<Card>();
            for(int i = 0; i < 5; i++){
               cardArrayListCC.add(myDeck.deal());
            }

            ArrayList<Card> Hand1Cards = new ArrayList<>();
            ArrayList<Card> Hand2Cards = new ArrayList<>();
            for(int i = 0; i < 2; i++){
                Hand1Cards.add(myDeck.deal());
                Hand2Cards.add(myDeck.deal());
            }

            CommunityCardSet communityCards = new CommunityCardSet(cardArrayListCC);
            StudPokerHand hand1 = new StudPokerHand(communityCards, Hand1Cards);
            StudPokerHand hand2 = new StudPokerHand(communityCards, Hand2Cards);


            System.out.println(hand1);
            System.out.println(hand2);

            Scanner input = new Scanner(System.in);
            System.out.println("Which hand wins (enter 1 for the first hand, 2 for the second hand, or 0 for tie");
            int userGuess = input.nextInt();


            while(userGuess != 1 && userGuess != 2 && userGuess != 0){
                System.out.println("Invalid entry, please try 1, 2 or a space:");
                 userGuess = input.nextInt();
            }


            System.out.print("Your input:");
            System.out.print(input);

            int expectedAnswer = hand1.compareTo(hand2);

            if(expectedAnswer == userGuess || (expectedAnswer == 0 && userGuess == 0)){
                playerScore++;
                System.out.println("Congrats! You are correct. +1 point");
            }
            else{
                System.out.println("Sorry, wrong answer");
                isOver = false;
            }
        }
        System.out.println("Game over, your score is: ");
        System.out.print(playerScore);
    }
}