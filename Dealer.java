import java.util.ArrayList;
/**
 * Write a description of class Dealer here.
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Dealer  
{
    private RuleHand dealerHand;
    private boolean willHit;
    
    public void startingHand(Shoe tableShoe){
        hit(tableShoe);
        hit(tableShoe);
        dealerHand.getCard(0).flipCard();
    }
    
    public void hit(Shoe tableShoe){
        dealerHand.addCard(tableShoe.dealCard());
    }
    
    public void revealHand(){
        dealerHand.getCard(0).flipCard();
    }
}

/*Notes 
 * When a blackjack occurs for the dealer, of course, the hand is over, 
 * and the players' main bets are collected - unless a player also has blackjack, 
 * in which case it is a stand-off.
 * 
*/