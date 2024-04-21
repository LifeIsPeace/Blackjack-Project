import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StandButton here.
 * 
 * @author Brejon T
 * @version 4.16.24
 */
public class StandButton extends Button
{
    static final int DEFAULT_X = 99;
    static final int DEFAULT_Y = 547;
    private Player player;
    private Shoe shoe;
    private Table table;
    
    public StandButton(int x, int y){
        super("STAND", x, y);
    }
    
    public StandButton(Table table, Player player, Shoe shoe){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        this.player = player;
        this.shoe = shoe;
    }
    
    public StandButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this)){
           table.getDealer().revealHand();
           int cards = table.getAmountOfDealerCards();
           Dealer dealer = table.getDealer();
           while (dealer.getHandValue() < 17) {
               dealer.hit(shoe);
               table.hitDealer(cards);
               cards++;
               table.setAmountOfDealerCards(cards);
            }
           if (!(dealer.getHandValue() + (dealer.getAceCount() * 11) > 21) && !(dealer.getHandValue() + dealer.getAceCount() > 21) && player.getHandValue() < dealer.getHandValue()) {
               table.getWorld().showText("GAMEOVER", 630, 630);
           }
           else {
               table.getWorld().showText("WIN", 630, 630);
           }
        }
    }
}
