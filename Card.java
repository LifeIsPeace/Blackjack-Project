import greenfoot.*;
import java.util.*;
/**
 * Write a description of class Card here.
 * 
 * @author Brejon Turner 
 * @version 3.28.24
 */
public class Card extends Actor  
{
    private final Rank RANK;
    private final Suit SUIT;
    private final GreenfootImage CARDPNG;
    private static final GreenfootImage BACK_OF_CARDPNG = 
            new GreenfootImage("images//card_images//backOfCard.png");
    private boolean backOfCard;
    
    public Card(Rank rank, Suit suit){
        backOfCard = false; // Rethink later
        RANK = rank;
        SUIT = suit;
        String rankFileName = "images//card_images//" + RANK.toString()
        + "_of_" + SUIT.toString() +  ".png";
        CARDPNG = new GreenfootImage(rankFileName);
        this.setImage(CARDPNG);
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
    /**
     * Changes the setImage of this card to BACK_OF_CARDPNG or CARDPNG depending on the value of backOfCARD
     */
    public void flipCard(){
        backOfCard = !backOfCard;
        if(backOfCard){
            this.setImage(CARDPNG);
        }
        else{
            this.setImage(BACK_OF_CARDPNG);
        }
    }
    
    public int getValue(){ return RANK.value;}
    public Rank getRank(){ return RANK;}
    public boolean sideOfCard(){return backOfCard;}
    public GreenfootImage getImage(){return new GreenfootImage(CARDPNG);}
    public String toString(){ return RANK + " of " + SUIT;}    
}