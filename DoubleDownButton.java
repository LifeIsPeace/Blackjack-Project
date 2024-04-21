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
    
    public DoubleDownButton(int x, int y){
        super("DOUBLE DOWN", x, y);
    }
    
    public DoubleDownButton(Table table, Player player, Shoe shoe){
        this(DEFAULT_X, DEFAULT_Y);
        this.table = table;
        this.player = player;
        this.shoe = shoe;
        amountOfCards = 2;
    }
    
    public DoubleDownButton(){
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
        }
    }
}
