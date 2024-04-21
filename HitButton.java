import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HitButton here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class HitButton extends Button
{
    private static final int DEFAULT_X = 64;
    private static final int DEFAULT_Y = 610;
    
    private Player player;
    private Shoe shoe;
    private Table table;
    
    public HitButton(int x, int y){
        super("HIT", x, y);
    }
    
    public HitButton(Table table, Player player, Shoe shoe){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        this.player = player;
        this.shoe = shoe;
    }
    
    public HitButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
       if(Greenfoot.mouseClicked(this)){
           int cards = table.getAmountOfCards();
           player.hit(shoe);
           table.hit(cards);
           cards++;
           table.setAmountOfCards(cards);
           
           if ((player.getHandValue() + (player.getAceCount() * 11) > 21) && (player.getHandValue() + player.getAceCount() > 21)) {
               table.getWorld().showText("GAMEOVER", 630, 630);
           }
        }
    }
}
