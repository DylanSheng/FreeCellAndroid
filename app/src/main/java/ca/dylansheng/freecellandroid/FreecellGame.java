package ca.dylansheng.freecellandroid;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

import ca.dylansheng.freecellandroid.Card;

/**
 * Created by dsheng on 1/31/2017.
 */
public class FreecellGame {
    public static void main(String[] args){
        FreecellGame freecellGame = new FreecellGame();
    }

    public ArrayList<Stack<Card>> tableau;
    public Card[] freecell;
    public ArrayList<Stack<Card>> homecell;


    FreecellGame(){
        tableau = new ArrayList<Stack<Card>>(8);
        for (int i = 0; i < 8; i++) {
            Stack<Card> s = new Stack<>();
            tableau.add(s);
        }

        freecell = new Card[4];

        homecell = new ArrayList<Stack<Card>>(4);
        for (int i = 0; i < 4; i++) {
            Stack<Card> s = new Stack<>();
            homecell.add(s);
        }


        Deck deck = new Deck();
        ArrayList<Card> deckList = deck.deckList;
        deal(deckList);

        printBoard();

        moveFromTableauToFreecell(3,0);

        printBoard();

        moveFromTableauToHomecell(3,0);

        printBoard();
    }

    void deal(ArrayList<Card> deckList){
        for(int i = 0; i < 6; ++i){
            for(int j = 0; j < 8; ++j) {
                tableau.get(j).push(deckList.get(i * 8 + j));
            }
        }
        for(int i = 0; i < 4; ++i){
            tableau.get(i).push(deckList.get(6 * 8 + i));
        }
    }

    void moveFromTableauToTableau(int begin, int end){
        if(isValidMove()){
            tableau.get(end).push(tableau.get(begin).peek());
            tableau.get(begin).pop();
        }
    }

    void moveFromTableauToFreecell(int begin, int end){
        if(isValidMove()){
            freecell[end] = tableau.get(begin).peek();
            tableau.get(begin).pop();
        }
    }

    void moveFromTableauToHomecell(int begin, int end){
        if(isValidHomecellMove()){
            homecell.get(end).push(tableau.get(begin).peek());
            tableau.get(begin).pop();
        }
    }

    void moveFromFreecellToTableau(int begin, int end){
        if(isValidMove()){
            tableau.get(end).push(freecell[begin]);
            freecell[begin] = null;
        }
    }

    void moveFromFreecellToHomecell(int begin, int end){
        if(isValidHomecellMove()){
            homecell.get(end).push(freecell[begin]);
            freecell[begin] = null;
        }
    }

    boolean isValidMove(){
        return true;//----------------------------------
    }

    boolean isValidHomecellMove(){
        return true; //-----------------------------------
    }

    void printBoard(){
        for(int i = 0; i < 4; ++i){
            if(freecell[i] != null) {
                System.out.println("Freecell " + i + ":[" + freecell[i].CardNumber + freecell[i].SuitName + "]");
            }else{
                System.out.println("Freecell " + i + ":[]");
            }
        }
        for(int i = 0; i < 4; ++i){
            if(!homecell.get(i).empty()) {
                System.out.println("Homecell " + i + ":[" + homecell.get(i).peek().CardNumber + homecell.get(i).peek().SuitName + "]");
            }else{
                System.out.println("Homecell " + i + ":[]");
            }
        }
        for(int i = 0; i < 8; ++i){
            if(!tableau.get(i).empty()) {
                String s = "";

                Iterator<Card> it = tableau.get(i).iterator();
                while(it.hasNext()){
                    Card c = it.next();
                    s = s + c.CardNumber + c.SuitName + ",";
                }
                s = s.substring(0, s.length() - 1);
                System.out.println("Tableau " + i + ":[" + s + "]");
            }else{
                System.out.println("Tableau " + i + ":[]");
            }
        }
    }
}
