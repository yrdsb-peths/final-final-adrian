import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PointBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PointBlock extends Block
{
    /**
     * Act - do whatever the PointBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public PointBlock(String blockType, int speed)
    {
        super(blockType, speed);
        
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
    
    public void act()
    {
        // Add your action code here.
        animateBlock();
        fall();
        rotateBlock();
        updateBlock();
        checkCollision();
        removeIfOffScreen();
    }
}
