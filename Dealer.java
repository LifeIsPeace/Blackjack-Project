import java.util.ArrayList;
/**
 * Truthfully this class could just be rulehand but I'd like to see
 * you refactor code after coding literally every class
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Dealer  
{
    private RuleHand dealerHand = new RuleHand();
    private boolean willHit;
    
    public void startingHand(Shoe tableShoe){
        hit(tableShoe);
        hit(tableShoe);
        dealerHand.getCard(0).flipCard();
        for(int i = 0; i < 2; i++){
        scaleCard(dealerHand.getCard(i));
    }
    }
    
    //Make sure to scale this card too
    public void hit(Shoe tableShoe){
        dealerHand.addCard(tableShoe.dealCard());
    }
    
    public void scaleCard(Card card){
        card.getImage().scale(138,192);
    }
    
    public void revealHand(){
        dealerHand.getCard(0).flipCard();
    }
    
    public void clearHand(){
        dealerHand.clearHand();
    }
    
    public int aceElevenValue(){
        return dealerHand.aceElevenValue();
    }
    
    public boolean isSoft(){
        return dealerHand.isSoft();
    }
    
    public void addCard(Card card){
        dealerHand.addCard(card);
    }
    
    public Card getCard(int index){
        return dealerHand.getCard(index);
    }
    
    public RuleHand getRuleHand(){
        return dealerHand;
    }
}

/*Notes 
 * When a blackjack occurs for the dealer, of course, the hand is over, 
 * and the players' main bets are collected - unless a player also has blackjack, 
 * in which case it is a stand-off.
 * 
*/