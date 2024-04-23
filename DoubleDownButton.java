import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DoubleDownButton here.
 * 
 * @author Brejon T 
 * @version 4.17.24
 */
public class DoubleDownButton extends Button
{
    static final int DEFAULT_X = 188;
    static final int DEFAULT_Y = 675;
    
    private int amountOfCards;
    private Player player;
    private Shoe shoe;
    private Table table;
    private BlackJackRunner bjr;
    
    public DoubleDownButton(int x, int y){
        super("DOUBLE DOWN", x, y);
    }
    
    public DoubleDownButton(Table table, BlackJackRunner bjr){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        player = table.getPlayer(0);
        shoe = table.getShoe();
        amountOfCards = 2;
        this.bjr = bjr;
    }
    
    public DoubleDownButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this) && !bjr.isBetting() && bjr.getStartingMoney() >= bjr.getBetAmount() * 2){
           bjr.setStartingMoney(bjr.getStartingMoney() - bjr.getBetAmount());
           bjr.setBetAmount(bjr.getBetAmount() * 2);
           int cards = table.getAmountOfCards();
           player.hit(shoe);
           table.hit(cards);
           
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
