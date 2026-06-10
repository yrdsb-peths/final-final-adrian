import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class DizzyBlock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DizzyBlock extends Block
{
    public DizzyBlock(String blockType, int speed)
    {
        super(blockType, speed);
        
        for (int i = 0; i < expression.length; i++)
        {
            // Original image
            GreenfootImage original = new GreenfootImage("images/" + blockType + i + ".png");

            // Scale the visible block
            original.scale(55, 55);

            // Create larger white square image to so when the block rotates the corners do not get clipped
            GreenfootImage largerCanvas = new GreenfootImage(80, 80);

            // Draws original visible image onto the center of the white square making it one object
            largerCanvas.drawImage(original, 15, 15);

            // Store the clear canvas image
            expression[i] = largerCanvas;
        }
        
        animationTimer.mark();
        
        // Sets original image
        setImage(expression[0]);
        
    }
    
    // Overides parent method. When this block collides with the player the player switches direction.
    public boolean checkCollision()
    {
        // Gets this world
        World world = getWorld();
        // Creates a list of all players
        java.util.List<Player> players = world.getObjects(Player.class);
        
        // Ensures a player exists
        if(players.size() > 0)
        {
            /* This variable stores the player by
            Getting all players in this world (1) and storing it into an array and then getting the first player in the array */
            Player player = (Player)world.getObjects(Player.class).get(0);
            
            // Gets the horizontal distance between the player and the block
            int xDistance = getX() - player.getX();
            // Gets the vertical distance between the player and the block
            int yDistance = getY() - player.getY();
        
            // Gets the shortest distance between the player and the block (pythagorean theorem)
            double distance = (xDistance * xDistance) + (yDistance * yDistance);
            distance = Math.sqrt(distance);        
            
            // If the distance between the objects is less than a certain distance then the user gets a point
            if(distance < 45)
            {
                player.switchDirection();
                
                // Removes this object and returns true
                world.removeObject(this);
                return true;
            }
        }
        
        // Returns false when this block has not collided 
        return false;        
    }
    
    
    public void act()
    {
        // Add your action code here.
        
        /* These two if statements check if the object actually exists and has not been removed, before doing anything else with them
        to avoid crashing
        */
        if (checkCollision()) {
        return; 
        }

        if(removeIfOffScreen())
        {   
            // Checks if this world is the main world not the tutorial world
            return;
        } 
        
        // Animates the block
        animateBlock();
        // Moves the block down
        fall();
        // Rotates the block
        rotateBlock();
        // Applies all these things to the block sprite
        updateBlock();
    }
}
