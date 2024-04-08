/**
 * Write a description of class Player here.
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Player  
{
    private RuleHand playerHand;
    private RuleHand playerSplitHand;
    private boolean separateHandAce;
    
    //Bets are placed before hand is dealt
    public void startingHand(Shoe tableShoe){
        hit(tableShoe);
        hit(tableShoe);
    }
    
    public void hit(Shoe tableShoe){
        playerHand.addCard(tableShoe.dealCard());
    }
    
    public void pshHit(Shoe tableShoe){
        playerSplitHand.addCard(tableShoe.dealCard());
    }
    
    public void setBet(double amount){
        playerHand.placeBet(amount);
    }
    
    public void separateHand(){
        // test later
        if(playerHand.getCard(0).toString() == playerHand.getCard(1).toString()){
            playerSplitHand.placeBet(playerHand.getBet());
            playerSplitHand.addCard(playerHand.getCard(1));
            playerHand.removeCard();
            
            if(playerHand.getCard(0).getValue() == 1){
                separateHandAce = true;
            }
        }
        else{
            return;
        }
    }
    
    public boolean playableHand(){ // In the future check if this needs to be called with every method
        if(playerHand.getSize() > 1){
            return true;
        }
        return false;
    }
    
    public void reset(){
        playerHand.clearHand();
        playerSplitHand.clearHand();
    }
}
