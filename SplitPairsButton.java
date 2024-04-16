import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SplitPairsButton here.
 * 
 * @author Brejon T 
 * @version 4.16.24
 */
public class SplitPairsButton extends Button
{
    /**
     * Act - do whatever the SplitPairsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    static final int DEFAULT_X = 1129;
    static final int DEFAULT_Y = 675;
    
    public SplitPairsButton(int x, int y, int z){
        super("SPLITPAIR", x, y, z);
    }
    
    public SplitPairsButton(int x, int y){
        super("SPLITPAIR", x, y);
    }
    
    public SplitPairsButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
