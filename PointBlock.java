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
    // Contructor
    public PointBlock(String blockType, int speed)
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
    
    // Checks for collisions, if this block is off screen, animates the block, moves it downwards and rotates it
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
    
    // Overide the parent class method. This method not only removes the block but also resets the streak
    public boolean removeIfOffScreen()
    {
        World world = getWorld();
        
        if(world == null)
        {
            return true;
        }
        
        if(getY() > 700)
        {
            if(getWorld() instanceof MyWorld)
            {
                // Resets the players streak
                ((MyWorld)world).resetStreak();
            }
            getWorld().removeObject(this);
            return true;
        }
        
        return false;
    }
    
    // Overide the parent class method. This method inrceases score and streak on collision wiht player instead of showing the game over screen.
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
                /* Uses a method from the MyWorld world to update the score label (in MyWorld) only if it is in myWorld
                not tutorial world */
                if(world instanceof MyWorld)
                {
                    ((MyWorld)world).addScore();
                }
                // Removes this object and returns true
                world.removeObject(this);
                return true;
            }
        }
        
        // Returns false when this block has not collided 
        return false;        
    }
}
