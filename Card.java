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
    private final GreenfootImage CARD_RANK_PNG;
    private final GreenfootImage CARD_SUIT_PNG;
    
    public Card(Rank rank, Suit suit){
        RANK = rank;
        SUIT = suit;
        String rankFileName = "images//CardBeta//" + RANK.toString() + ".png";
        String suitFileName = "images//CardBeta//" + SUIT.toString() + ".png";
        CARD_RANK_PNG = new GreenfootImage(rankFileName);
        CARD_SUIT_PNG = new GreenfootImage(suitFileName);
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
    //Definitely needs to be changed later due to separate pngs
    public GreenfootImage getImage(){return new GreenfootImage(CARD_SUIT_PNG);}
    
    public String toString(){ return RANK + " of " + SUIT;}    
    
    
    /*
     * Disregard
     * 
     * public Card(String rank, String suit){
        String rankFileName;
        String suitFileName;
        boolean validRank = true;
        switch(rank.toLowerCase()){
            case "one": 
                rankFileName = rank.toLowerCase() + ".png";
                RANK = Rank.valueOf(rank);
                break;
            case "two":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "three":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "four":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "five":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "six":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "seven":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "eight":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "nine":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "ten":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "jack":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "queen":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "king":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            case "ace":
                rankFileName = rank.toLowerCase() + ".png";
                break;
            default:
                rankFileName = "backOfCard" + ".png";
                validRank = false;
                break;
        }
        
        if(validRank){
            switch(suit.toLowerCase()){
                case "spades":
                    suitFileName = suit.toLowerCase() + ".png";
                    break;
                case "clubs":
                    suitFileName = suit.toLowerCase() + ".png";
                    break;
                case "diamonds":
                    suitFileName = suit.toLowerCase() + ".png";
                    break;
                case "hearts":
                    suitFileName = suit.toLowerCase() + ".png";
                    break;
                default:
                    rankFileName = "backOfCard" + ".png";
                    suitFileName = null;
                    validRank = false;
                break;
            }
        }
        else{
            suitFileName = null;
        }
        
    }
     */
}