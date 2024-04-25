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
    
    /**
     * Adds a card object to the ArrayList hand
     * @param card a card object
     */
    public void addCard(Card card){ hand.add(card);}
    
    public void removeCard(int index){hand.remove(index);}
    
    public void removeCard(){
        if(hand.size() > 0){
            hand.remove(hand.size() - 1);
        }
        else{
            return;
        }
    }
    
    /**
     * Returns the card in the ith index of hand
     * @param index an integer that signifies the wanted index of hand
     * @return  the card at the ith index of hand
     */
    public Card getCard(int index){ return hand.get(index);}
    
    public int getSize(){ return hand.size();}
    
    public void clearHand(){ hand.clear();}
    
    public int handValue(){
        int value = 0;
        for(Card card: hand){
            if (card.getValue() != 1) {
                value += card.getValue();
            }
        }
        return value;
    }
    public int aceCount(){
        int ace = 0;
        for(Card card: hand){ 
            if (card.getValue() == 1) {
                ace++;
            }
        }
        return ace;
    }
}
