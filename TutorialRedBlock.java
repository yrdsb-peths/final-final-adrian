import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/* This class is a subclass of Block. It is a obstacle block made specifically for the tutorial world to avoid showing game over screen
 in the tutorial */
public class TutorialRedBlock extends Block
{
    // Stores the sound that is played when they player collides with this block
    GreenfootSound damage = new GreenfootSound("damage.mp3");
    
    // Constructor. Same as parent class
    public TutorialRedBlock(String blockType, int speed)
    {
        // Sets up instance variable
        super(blockType, speed);
    }
    
    /**
     * Act - do whatever the TutorialRedBlock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
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
    
    // Overrides parent class method. On collision,the game doesn't end, instead the block just gets removed.
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
                // Plays damage sound
                damage.play();
                // Removes this object
                world.removeObject(this);
                return true;
            }
        }
        
        // If object is not removed
        return false;
        
    }
}
