import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class AchievementsButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AchievementsButton extends Button
{
    private static final int DEFAULT_X = 120;
    private static final int DEFAULT_Y = 500;
    private BlackJackRunner bjr;

    public AchievementsButton(BlackJackRunner bjr){
        this(DEFAULT_X, DEFAULT_Y);
        this.bjr = bjr;
    }

    public AchievementsButton(int x, int y){
        super(new GreenfootImage("images//trophy1.png"), x, y);
    }

    public AchievementsButton(){
        this(DEFAULT_X, DEFAULT_Y);
    }

    public void animate(String btnType){
        if(Greenfoot.mousePressed(this)){
            setImage(scale(new GreenfootImage("images//"+btnType+"1.png"),170,100));
        } 
        if(Greenfoot.mouseClicked(this)){
            setImage(scale(new GreenfootImage("images//"+btnType+"2.png"),190,110));
            //if (this instanceof StartButton){ Greenfoot.setWorld( new BlackJackRunner()); }
        }
        if(Greenfoot.mouseMoved(this)){
            setImage(scale(new GreenfootImage("images//"+btnType+"2.png"),190,110));
        } else if(Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)){
            setImage(scale(new GreenfootImage("images//"+btnType+"3.png"),170,100));
        }
    }

    /**
     * Act - do whatever the AchievementsButton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act(){
        animate("trophy");
        if(Greenfoot.mouseClicked(this)){
            this.getWorld().stopped();
            Greenfoot.setWorld(new Achievements(bjr));
        }
    }
}