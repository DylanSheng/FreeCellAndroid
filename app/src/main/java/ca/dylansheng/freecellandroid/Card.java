package ca.dylansheng.freecellandroid;

/**
 * Created by dsheng on 1/31/2017.
 */
public class Card {
    String SuitName;
    Integer CardNumber;
    Integer DeckPosition;
    Card(String SuitName, Integer CardNumber, Integer DeckPosition){
        this.SuitName = SuitName;
        this.CardNumber = CardNumber;
        this.DeckPosition = DeckPosition;
    }
}
