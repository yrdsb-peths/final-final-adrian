import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Block here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Block extends Actor
{
    GreenfootImage [] expression = new GreenfootImage[2];
    SimpleTimer animationTimer = new SimpleTimer();
    
    private String blockType;
    private int speed;
    
    private int rotation = 0;
    private int rotationSpeed = 3;
    
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block(String image, int theSpeed)
    {
        for(int i = 0; i < expression.length; i++)
        {
            speed = theSpeed;
            blockType = image;
            expression[i] = new GreenfootImage("images/" + blockType + i + ".png");
            expression[i].scale(50,50);
        }
        
        animationTimer.mark();
        
        setImage(expression[0]);
    }
    
    // Animate the block
    int imageIndex = 0;
    public void animateBlock()
    {
        if(animationTimer.millisElapsed() < 1000)
        {
            return;
        }
        animationTimer.mark();
        
        //setImage(expression[imageIndex]);
                
        imageIndex = (imageIndex + 1) % expression.length;
    
    }
    
    public void updateBlock()
    {
        // Create a copy of the current frame
        GreenfootImage frame = new GreenfootImage(expression[imageIndex]);
        
        // Rotate frame
        frame.rotate(rotation);

        // Set rotated frame
        setImage(frame);
    }
    
    // Moves the block downward
    public void fall()
    {
        setLocation(getX(), getY() + speed);
    }
    
    // Rotates the block
    public void rotateBlock()
    {
        rotation += rotationSpeed;
    }
    
    public void removeIfOffScreen()
    {
        if(getY() > getWorld().getHeight())
        {
            getWorld().removeObject(this);
        }
    }
    
    public void act()
    {
        // Add your action code here.
        animateBlock();
        fall();
        rotateBlock();
        updateBlock();
        removeIfOffScreen();
    }
}
