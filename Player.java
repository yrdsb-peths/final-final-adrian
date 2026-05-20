import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    // Angle relative to the center point of imaginary circle
    double angle = 0;
    
    // Max distance the ball will be from the center of the circle
    int radius = 180;
    
    // Center of the circle
    int xCenter = 300;
    int yCenter = 420;
    
    // Changes how big the changes in the angle is, which determines how fast the player moves around the circle
    double speed = 0.03;
    
    // 1 for clockwise and -1 for counter clockwise
    int direction = 1;
    
    
    public Player()
    {
        GreenfootImage image = new GreenfootImage("images/Blue ball.png");
        image.scale(50,40);
        setImage(image);        
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        movePlayer();
        changeDirection();
    }
    
    // This method moves the player in a circular path. Uses cos for x position and sin for y position like unit circle.
    public void movePlayer()
    {
        // updates the angle from the center
        angle = angle + (speed * direction);
        
        /* Calculates the x position. xCenter is added by cos of the angle times radius to determine how far right or left 
        we are on the circle */
        int posX = (int)(xCenter + (radius * Math.cos(angle)));
        /* Calculates the y position. yCenter is added by sin of the angle times radius to determine how far up or down
        we are on the circle */
        int posY = (int)(yCenter + (radius * Math.sin(angle)));
        
        // Sets the location of the player
        setLocation(posX, posY);
    }
    
    // This method allows the user to change the direction by pressing space
    public void changeDirection()
    {
        // Makes the direction positive or negative when space is pressed
        if(Greenfoot.isKeyDown("space"))
        {
            direction = direction * -1;
        }
    }
    
}
