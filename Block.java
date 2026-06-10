import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

// This is the obstacle block that the user will try and dodge
public class Block extends Actor
{
    // Array that stores all the poses of this block
    GreenfootImage [] expression = new GreenfootImage[2];
    // Sets up a timer used for animations
    SimpleTimer animationTimer = new SimpleTimer();
    
    // Stores the Block's image
    private String blockType;
    // How fast the block falls
    private int speed;
    
    // Stores what rotation offset we are on
    private int rotation = 0;
    // Rotation speed
    private int rotationSpeed = 1;
    
    // Constructor. Takes a string that is used to determine the image, and a int that controlls the speed.
    public Block(String blockType, int speed)
    {
        // Sets up instance variables
        this.speed = speed;
        this.blockType = blockType;
        
        // Adjusts all poses of the block to make animation, and block movement and rotation smooth.
        for (int i = 0; i < expression.length; i++)
        {
            // Original pose
            GreenfootImage original = new GreenfootImage("images/" + blockType + i + ".png");

            // Scale the visible block pose
            original.scale(55, 55);

            // Create larger white square image so when the block rotates the corners do not get clipped
            GreenfootImage largerCanvas = new GreenfootImage(80, 80);

            // Draws original visible pose onto the center of the white square
            largerCanvas.drawImage(original, 15, 15);

            // Store the whole new image
            expression[i] = largerCanvas;
        }
        
        // Marks the current moment of the animation timer
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
        // Marks the current time
        animationTimer.mark();
        
        // Loops through and back the array to keep a constant animation
        imageIndex = (imageIndex + 1) % expression.length;
    
    }
    
    // Updates the block sprite with the new rotation
    public void updateBlock()
    {
        // Create a copy of the current pose to not mess with the animations
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
    
    // Checks for collisions with the player. If the block is touching the player, world changes to GameOver world 
    public boolean checkCollision()
    {
        // Gets this world
        World world = getWorld();
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
        
        // Creates a list of all players
        java.util.List<Player> players = world.getObjects(Player.class);
        
        // Ensures a player exists
        if(players.size() > 0)
        {
            // If the distance between the objects is less than a certain distance then the game ends and returns true 
            // to tell the game that the object is removed
            if(distance < 45)
            {
                // Calls gameOver method in MyWorld class that changes the world to the GameOver world
                ((MyWorld)world).gameOver();
                return true;
            }
        }
        
        // If object is not removed
        return false;
        
    }
    
    /* Constantly moves the block downwards while animating it and rotating it. Also checks whether it has colliding with the player
     or has fallen off the world */
    public void act()
    {
        
        // These two if statements check if the object actually exists and has not been removed, before doing anything else with them
        if (checkCollision()) 
        {
            return; 
        }
        
        if(removeIfOffScreen())
        {
            return;
        }
        
        // Animate the block
        animateBlock();
        // Move it downwards
        fall();
        // Rotates it
        rotateBlock();
        // Add all updates to the block
        updateBlock();
    }
}
