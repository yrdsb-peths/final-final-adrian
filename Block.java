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
    private int rotationSpeed = 1;
    
    /**
     * Act - do whatever the Block wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Block(String blockType, int speed)
    {
        // Sets instance variables
        this.speed = speed;
        this.blockType = blockType;
        
        for (int i = 0; i < expression.length; i++)
        {
            // Original image
            GreenfootImage original = new GreenfootImage("images/" + blockType + i + ".png");

            // Scale the visible block
            original.scale(55, 55);

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
        if(animationTimer.millisElapsed() < 500)
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
    public boolean removeIfOffScreen()
    {
        World world = getWorld();
        
        if(world == null)
        {
            return true;
        }
        
        if(getY() > 700)
        {
            getWorld().removeObject(this);
            return true;
        }
        
        return false;
    }
    
    // If the block is touching the player, the game ends
    public boolean checkCollision()
    {
        // Gets this world
        World world = getWorld();
        // Gets all players in this world (1) and stores it into a array and then get the first player in the array
        Player player = (Player)world.getObjects(Player.class).get(0);
        
        // Gets the horizontal distance between the player and the block
        int xDistance = getX() - player.getX();
        // Gets the vertical distance between the player and the block
        int yDistance = getY() - player.getY();
        
        // Gets the shortest distance between the player and the block
        double distance = (xDistance * xDistance) + (yDistance * yDistance);
        distance = Math.sqrt(distance);
        
        // Creates a list of all players
        java.util.List<Player> players = world.getObjects(Player.class);
        
        // Ensures a player exists
        if(players.size() > 0)
        {
            // If the distance between the objects is less than a certain distance then the game ends and returns true 
            // to tell the game that the object is removed
            if(distance < 45)
            {
                Greenfoot.stop();
                return true;
            }
        }
        
        // If object is not removed
        return false;
        
    }
    
    public void act()
    {
        // Add your action code here.
        
        // These two if statements check if the object actually exists and has not been removed, before doing anything else with them
        if (checkCollision()) 
        {
            return; 
        }
        
        if(removeIfOffScreen())
        {
            return;
        } 
        animateBlock();
        fall();
        rotateBlock();
        updateBlock();
    }
}
