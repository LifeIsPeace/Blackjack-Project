import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Card here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Card  
{
    private final Rank RANK;
    private final Suit SUIT;
    private final GreenfootImage CARDPNG;
    
    public Card(Rank rank, Suit suit){
        RANK = rank;
        SUIT = suit;
        String fileName = SUIT.toString().toLowerCase() + "_Of_" + 
            RANK.toString().toLowerCase();
        CARDPNG = new GreenfootImage(fileName);
    }
    
    public enum Rank{
        ACE(1),TWO(2),THREE(3),FOUR(4),FIVE(5),SIX(6),SEVEN(7),EIGHT(8),NINE(9),
        TEN(10),JACK(10),QUEEN(10),KING(10);
        
        private int value;
        Rank(int value){
            this.value = value;
        }
        
        public String toString(){ return name().toLowerCase();}
    }
    
    public enum Suit{
        DIAMONDS, HEARTS, SPADES, CLUBS;
    public String toString(){ return name().toLowerCase();}
    
    }
    
    public int getValue(){ return RANK.value;}
    public Rank getRank(){ return RANK;}
    public GreenfootImage getImage(){return new GreenfootImage(CARDPNG);}
    
    public String toString(){ return RANK + " of " + SUIT;}    
}