package ca.dylansheng.freecellandroid;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dsheng on 1/31/2017.
 */
public class Deck {
    public static final String[] SuitName = {"Clubs", "Hearts", "Spades", "Diamonds"};
    public static final Integer[] CardNumber = {1,2,3,4,5,6,7,8,9,10,11,12,13};
    public ArrayList<Card> deckList;
    Deck(){
        deckList = createDeck();
        shuffle();
    }
    public ArrayList<Card> createDeck(){
        ArrayList<Card> deck = new ArrayList<>();
        int DeckPosition = 0;
        for(String s : SuitName){
            for(Integer i : CardNumber){
                Card card = new Card(s, i, DeckPosition);
                deck.add(card);
                ++DeckPosition;
            }
        }

        return deck;
    }

    public void shuffle(){
        Random rnd = ThreadLocalRandom.current();
        for (int i = deckList.size() - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i+1);
            Card a = deckList.get(index);
            deckList.set(index, deckList.get(i));
            deckList.set(i,a);
        }
    }
}
