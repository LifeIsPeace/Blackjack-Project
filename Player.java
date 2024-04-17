/**
 * Write a description of class Player here.
 * 
 * @author Brejon T 
 * @version 3.28.24
 */
public class Player  
{
    private RuleHand playerHand = new RuleHand();
    private RuleHand playerSplitHand;
    private boolean separateHandAce;
    
    //Bets are placed before hand is dealt
    public void startingHand(Shoe tableShoe){
        hit(tableShoe);
        hit(tableShoe);
        for(int i = 0; i < 2; i++){
            scaleCard(playerHand.getCard(i));
        }
    }
    
    public Card getCard(int x){
        return playerHand.getCard(x);
    }
    
    public void hit(Shoe tableShoe){
        playerHand.addCard(tableShoe.dealCard());
    }
    
    public void scaleCard(Card card){
        card.getImage().scale(92,128);
    }
    
    public void pshHit(Shoe tableShoe){
        playerSplitHand.addCard(tableShoe.dealCard());
    }
    
    public void setBet(double amount){
        playerHand.placeBet(amount);
    }
    
    public void separateHand(){
        // test later
        playerSplitHand = new RuleHand();
        if(playerHand.getCard(0).toString() == playerHand.getCard(1).toString()){
            playerSplitHand.placeBet(playerHand.getBet());
            playerSplitHand.addCard(playerHand.getCard(1));
            playerHand.removeCard();
            
            if(playerHand.getCard(0).getValue() == 1){
                //Sees if both cards are aces
                separateHandAce = true;
            }
        }
    }
    
    /*
     * Shouldn't be a necessary method
     */
    public boolean playableHand(){ // In the future check if this needs to be called with every method
        if(playerHand.getSize() > 1){
            return true;
        }
        return false;
    }
    
    public void reset(){
        playerHand.clearHand();
        playerSplitHand = null;
    }
}
