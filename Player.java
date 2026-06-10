import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// This is the player class. This is what the user will play as.
public class Player extends Actor
{
    
    // Angle relative to the center point of an imaginary circle
    double angle = 0;
    
    // Max distance the ball will be from the center of the circle
    private int radius;
    
    // Center of the circle
    private int xCenter;
    private int yCenter;
    
    // The instance variables above determine the player movement as the player moves in a circluar motion
    
    // Changes how big the changes in the angles are, which determines how fast the player moves around the circle
    private double speed;
    
    // 1 for clockwise and -1 for counter clockwise
    int direction = 1;
    
    // Player constructor. Takes in a 3 ints, radius and x/y position of the center that player orbits. Takes a double, which is the speed.
    public Player(int radius, int xCenter, int yCenter, double speed)
    {
        // Sets up instance variables
        this.radius = radius;
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.speed = speed;
        
        // Sets image and size
        GreenfootImage image = new GreenfootImage("images/Pink ball.png");
        image.scale(50,50);
        setImage(image);        
    }
    
    // Constantly moves the player, and checks for the user pressing space.
    public void act()
    {
        movePlayer();
        changeDirection();
    }
    
    // This method moves the player in a circular path. Uses cos for x position and sin for y position like unit circle.
    public void movePlayer()
    {
        // updates the angle from the center
        angle = angle + (speed * direction);
        
        /* Calculates the x position. xCenter is added to cos of the angle times radius to determine how far right or left 
        we are on the circle */
        int posX = (int)(xCenter + (radius * Math.cos(angle)));
        /* Calculates the y position. yCenter is added to sin of the angle times radius to determine how far up or down
        we are on the circle */
        int posY = (int)(yCenter + (radius * Math.sin(angle)));
        
        // Sets the location of the player
        setLocation(posX, posY);
    }
    
    // Stores whether or not space was down previously
    boolean wasSpaceDown = false;
    // This method allows the user to change the direction by pressing space but not holding
    public void changeDirection()
    {
        // Stores whether or not space is down right now
        boolean spaceDown = Greenfoot.isKeyDown("space");
        
        // Switches the direction when space is pressed
        if(spaceDown && !wasSpaceDown)
        {
            switchDirection();
        }
        
        // Updates the wasSpaceDown state to be the same as the spaceDown state right now
        wasSpaceDown = spaceDown;
        
    }
    
    // Method to switch direction. This method is also used in DizzyBlock class
    public void switchDirection()
    {
        direction = direction * -1;
    }
    
}
