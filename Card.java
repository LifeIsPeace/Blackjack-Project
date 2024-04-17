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
    private GreenfootImage cardPng;
    private final String rankFileName;
    private static final GreenfootImage BACK_OF_CARDPNG = 
            new GreenfootImage("images//card_images//backOfCard.png");
    private boolean backOfCard;
    
    public Card(Rank rank, Suit suit){
        backOfCard = false; // Rethink later
        RANK = rank;
        SUIT = suit;
        rankFileName = "images//card_images//" + RANK.toString()
        + "_of_" + SUIT.toString() +  ".png";
        //Java garbage collector will collect this if the card is ever flipped
        cardPng = new GreenfootImage(rankFileName);
        this.setImage(cardPng);
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
        if(backOfCard){
            cardPng = new GreenfootImage(rankFileName);
            this.setImage(cardPng);
            backOfCard = !backOfCard;
        }
        else{
            cardPng = BACK_OF_CARDPNG;
            this.setImage(cardPng);
            backOfCard = !backOfCard;
        }
    }
    
    public int getValue(){ return RANK.value;}
    public Rank getRank(){ return RANK;}
    public boolean sideOfCard(){return backOfCard;}
    /** 
     * If there were multiple players and they had a card that was flipped, this would not work as the dealer class
     * scales this image to be more visible to the irl player. For this project, there is only 1 player that will
     * always see their cards.
     */
    public GreenfootImage getImage(){
        if(backOfCard){
            return BACK_OF_CARDPNG;
        }
        return cardPng;}
    public String toString(){ return RANK + " of " + SUIT;}    
}