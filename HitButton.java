import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitButton here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class HitButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 550;
    
    private Player player;
    private Shoe shoe;
    private Table table;
    private BlackJackRunner bjr;
    
    public HitButton(int x, int y){
        super(new GreenfootImage("images//hit3.png"), x, y);
    }
    
    public HitButton(Table table, BlackJackRunner bjr){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        player = table.getPlayer(0);
        shoe = table.getShoe();
        this.bjr = bjr;
    }
    
    public HitButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
       animate("hit");
       if(Greenfoot.mouseClicked(this) && !bjr.isBetting()){
           int cards = table.getAmountOfCards();
           player.hit(shoe);
           table.hit(cards);
           if ((player.getHandValue() + (player.getAceCount() * 11) > 21) && (player.getHandValue() + player.getAceCount() > 21)) {
               bjr.setBetting(true);
               bjr.setBetAmount(0);
               table.getDealer().revealHand();
               bjr.setTimer(0);
           }
        }
    }
}
