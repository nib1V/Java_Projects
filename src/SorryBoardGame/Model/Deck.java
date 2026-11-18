package SorryBoardGame.Model;

import SorryBoardGame.Model.Cards.Card;

public class Deck {
    private int numCards = 45;
    private Card[] cards = new Card[45];

    public Deck(){
        //Initialize the Deck here
    }

    public void shuffle(){
        //Shuffle the Cards Randomly here
    }

    //Add more

    public boolean isEmpty(){return numCards == 0;}
}
