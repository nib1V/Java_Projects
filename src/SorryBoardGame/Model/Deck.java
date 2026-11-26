package SorryBoardGame.Model;

import SorryBoardGame.Model.Cards.*;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private int top = 43;
    private final ArrayList<Card> cards = new ArrayList<>(44);

    /**
     * Constructor of Class {@code Deck}.<br>
     * <b>Post-Condition:</b> Must initialize the Deck with 44 cards and shuffle it:<br>
     * 4 Cards for each number: {@code 1,2,3,4,5,7,8,10,11,12},<br>
     * and also 4 {@code Sorry} cards.
     * @class Deck
     */
    public Deck(){
        for(int j = 0; j < 44; j++) cards.add(null);
        for(int i = 0; i < 4; i++){
            cards.set(i, new SorryCard());
            cards.set(i + 4, new NumberOneCard());
            cards.set(i + 8, new NumberTwoCard());
            cards.set(i + 12, new NumberThreeCard());
            cards.set(i + 16, new NumberFourCard());
            cards.set(i + 20, new NumberFiveCard());
            cards.set(i + 24, new NumberSevenCard());
            cards.set(i + 28, new NumberEightCard());
            cards.set(i + 32, new NumberTenCard());
            cards.set(i + 36, new NumberElevenCard());
            cards.set(i + 40, new NumberTwelveCard());
        }
        reshuffle();
    }

    /**
     * Transformer method used to Re-shuffle the cards.<br>
     * <b>Post-Condition:</b> Must Reshuffle the deck of cards and
     * change the top of the Deck to the new one.
     * @class Deck
     */
    public void reshuffle(){
        Collections.shuffle(cards);
        top = 43;
    }

    /**
     * Accessor Method used to Draw a Card from the top of the Deck.<br>
     * <b>Post-Condition:</b> Returns the Card at the top of the Deck
     * and also makes the new top of the deck the card bellow. Also,
     * if the deck is empty checked by {@code isEmptyDeck} it <u>reshuffles</u>
     * it and then draws the top card.
     * @class Deck
     */
    public Card drawTop() {
        if (isEmptyDeck()) reshuffle();
        return cards.get(top--);}

    /**
     * Observer method used to know if the deck is {@code Empty}.<br>
     * <b>Post-Condition:</b> Must return a boolean value according
     * to the state of the {@code Deck}.
     * @class Deck
     */
    public boolean isEmptyDeck(){return top < 0;}
}
