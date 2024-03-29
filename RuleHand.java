/**
 * Write a description of class RuleHand here.
 * 
 * @author Brejon T 
 * @version (a version number or a date)
 */
public class RuleHand extends Hand
{
    private boolean splitPairs;
    private boolean doubleDown;
    private Card doubleDownCard;
    private double bet;
    
    private boolean hasAce(){
        for (Card card: hand){
            if(card.getValue() == 1){return true;}
        }
        return false;
    }
    //Double check this message
    public boolean isSoft(){return (handValue() < 12) && hasAce();}
    
    public void setSplitPairs(boolean value){ splitPairs = value;}
    
    public boolean getSplitPairs(){ return splitPairs;}
    
    public void placeBet(double bet){this.bet = bet;}
    
    public double getBet(){return bet;}
    
    public void setDoubleDown(boolean value){doubleDown = value;}
    
    public void addDoubleDownCard(Card card){
        doubleDownCard = card;
        addCard(card);
    }
    
    public Card getDoubleDownCard(){return doubleDownCard;}
    
    public boolean getDoubleDown(){return doubleDown;}
}
