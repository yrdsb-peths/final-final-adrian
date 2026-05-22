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
        
        // These two if statements check if the object actually exists and has not been removed, before doing anything else with them
        if (checkCollision()) {
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
    
    public boolean checkCollision()
    {
        // Gets this world
        World world = getWorld();
        // Creates a list of all players
        java.util.List<Player> players = world.getObjects(Player.class);
        
        // Ensures a player exists
        if(players.size() > 0)
        {
            // Gets all players in this world (1) and stores it into a array and then get the first player in the array
            Player player = (Player)world.getObjects(Player.class).get(0);
            
            // Gets the horizontal distance between the player and the block
            int xDistance = getX() - player.getX();
            // Gets the vertical distance between the player and the block
            int yDistance = getY() - player.getY();
        
            // Gets the shortest distance between the player and the block
            double distance = (xDistance * xDistance) + (yDistance * yDistance);
            distance = Math.sqrt(distance);        
            
            // If the distance between the objects is less than a certain distance then the use gets a point
            if(distance < 38)
            {
                world.removeObject(this);
                return true;
            }
        }
        
        return false;        
    }
}
