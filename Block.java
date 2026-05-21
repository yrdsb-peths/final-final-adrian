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
    
    // Block image
    private String blockType;
    // Falling speed
    private int speed;
    
    // What rotation offset we are on
    private int rotation = 0;
    // Rotation speed
    private int rotationSpeed = 3;
    
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block(String image, int theSpeed)
    {
        // Sets instance variables
        speed = theSpeed;
        blockType = image;
        
        for (int i = 0; i < expression.length; i++)
        {
            // Original image
            GreenfootImage original = new GreenfootImage("images/" + blockType + i + ".png");

            // Scale the visible block
            original.scale(45, 45);

            // Create larger white square image to so when the block rotates the corners do not get clipped
            GreenfootImage largerCanvas = new GreenfootImage(80, 80);

            // Draws original visible image onto the center of the white square
            largerCanvas.drawImage(original, 15, 15);

            // Store the clear canvas image
            expression[i] = largerCanvas;
        }
        
        animationTimer.mark();
        
        // Sets original image
        setImage(expression[0]);
    }
    
    // Records which pose we are on
    int imageIndex = 0;
    // Animates the block
    public void animateBlock()
    {
        // Delay between poses
        if(animationTimer.millisElapsed() < 1000)
        {
            return;
        }
        animationTimer.mark();
        
        // Loops through and back the array    
        imageIndex = (imageIndex + 1) % expression.length;
    
    }
    
    // Updates the block rotation on the actual block sprite
    public void updateBlock()
    {
        // Create a copy of the current frame to not mess with the animations
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
    
    // If the block is off the screen remove it
    public void removeIfOffScreen()
    {
        if(getY() > 730)
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
