package ca.dylansheng.freecellandroid;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

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
