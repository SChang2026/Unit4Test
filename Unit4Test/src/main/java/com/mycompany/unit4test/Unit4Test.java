/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
//Plan Before Coding: This project is likely easier because my final is nearly identical.
//The only difference is that 5 cards are dealed at once, and I do not have to work
//within the mindset of an actual visual area i.e. Jframe. The most time consuming part is
//going to be the unique card coding.

package com.mycompany.unit4test;

/**
 *
 * @author SChang2026
 */

import java.util.Random;

public class Unit4Test {

    public static void main(String[] args) {
        // Array to hold 5 Card objects
        Card[] hand = new Card[5];

        // Create 5 unique cards using a loop
        for (int i = 0; i < hand.length; i++) {
            Card newCard;
            boolean duplicate;
            
            // Ensure the card is unique
            do {
                newCard = new Card();
                duplicate = false;
                
                for (int j = 0; j < i; j++) {
                    if (hand[j].equals(newCard)) {
                        duplicate = true;
                        break;
                    }
                }
            } while (duplicate);
            
            hand[i] = newCard;
        }

        // Display the cards and find the highest value card
        int highestValue = 0;
        Card highestCard = null;
        
        System.out.println("Dealt hand:");
        for (Card card : hand) {
            System.out.println(card);
            if (card.getValue() > highestValue) {
                highestValue = card.getValue();
                highestCard = card;
            }
        }

        // Display the card with the highest value
        System.out.println("\nThe card with the highest value is: " + highestCard);
    }
}

class Card {
    private String suit;
    private int value;

    // Constructor generates a random card
    public Card() {
        String[] suits = {"Clubs", "Diamonds", "Hearts", "Spades"};
        Random random = new Random();
        this.suit = suits[random.nextInt(suits.length)];
        this.value = random.nextInt(13) + 1; // Values 1 to 13
    }

    // Getters
    public String getSuit() {
        return suit;
    }

    public int getValue() {
        return value;
    }

    // Override toString for easy printing
    @Override
    public String toString() {
        return value + " of " + suit;
    }

    // Override equals to ensure uniqueness
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Card card = (Card) obj;
        return value == card.value && suit.equals(card.suit);
    }
}

