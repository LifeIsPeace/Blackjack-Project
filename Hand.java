import java.util.ArrayList;
/**
 * Write a description of class Hand here.
 * 
 * @author Brejon T 
 * @version (a version number or a date)
 */
public class Hand  
{
    public ArrayList<Card> hand = new ArrayList<>();
    
    public void addCard(Card card){ hand.add(card);}
    
    public Card getCard(int i){ return hand.get(i);}
    
    public int getSize(){ return hand.size();}
    
    public void clearHand(){ hand.clear();}
    
    public int handValue(){
        int value = 0;
        for(Card card: hand){ value += card.getValue();}
        return value;
    }
}
