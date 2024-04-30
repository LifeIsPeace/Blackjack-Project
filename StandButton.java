import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StandButton here.
 * 
 * @author Brejon T
 * @version 4.16.24
 */
public class StandButton extends Button
{
    static final int DEFAULT_X = 120;
    static final int DEFAULT_Y = 450;
    private Player player;
    private Shoe shoe;
    private Table table;
    private BlackJackRunner bjr;
    
    public StandButton(int x, int y){
        super(new GreenfootImage("images//stand3.png"), x, y);
    }
    
    public StandButton(Table table, BlackJackRunner bjr){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        player = table.getPlayer(0);
        shoe = table.getShoe();
        this.bjr = bjr;
    }
    
    public StandButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
        animate("stand");
       if(Greenfoot.mouseClicked(this) && !bjr.isBetting()){
           table.getDealer().revealHand();
           Dealer dealer = table.getDealer();
           while (dealer.getHandValue() < 17) {
               int cardsd = table.getAmountOfDealerCards();
               dealer.hit(shoe);
               table.hitDealer(cardsd);
            }
           if (!(dealer.getHandValue() + (dealer.getAceCount() * 11) > 21) && !(dealer.getHandValue() + dealer.getAceCount() > 21) && player.getHandValue() < dealer.getHandValue()) {
               bjr.setBetting(true);
               bjr.setBetAmount(0);
           }
           else if (!(dealer.getHandValue() + (dealer.getAceCount() * 11) > 21) && !(dealer.getHandValue() + dealer.getAceCount() > 21) && player.getHandValue() == dealer.getHandValue()) {
               bjr.setBetting(true);
               bjr.setStartingMoney(bjr.getStartingMoney() + bjr.getBetAmount());
               bjr.setBetAmount(0);
           }
           else {
               bjr.setBetting(true);
               bjr.setStartingMoney(bjr.getStartingMoney() + (bjr.getBetAmount() * 2));
               bjr.setBetAmount(0);
           }
           bjr.setTimer(0);
        }
    }
}
