import greenfoot.*;

public class MyWorld extends World {
    
    // Timer that increases ever frame to control how long before a block spawns
    private int blockSpawnTimer = 0;
    
    // Stores the users score
    private int score = 0;
    
    // Label of the score
    private Label scoreLabel;
    
    // Stores the player streak
    private int streak = 0;
    
    
    public MyWorld() {
        super(560, 720, 1);
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();
        
        // Creates the score label and starts it at 0
        scoreLabel = new Label("0",120);
        addObject(scoreLabel, 280, 80);
        scoreLabel.setFillColor(Color.PINK);
        scoreLabel.setLineColor(Color.PINK); 
        
        // Creates the path (ring) that the user follows
        Path playerPath = new Path();
        addObject(playerPath, 280, 390);
        
        // Creates the player instance
        Player ball = new Player(181, 280, 390, 0.055);
        addObject(ball, 280, 390); 
        
    }
    
    // Continiously spawns blocks
    public void act()
    {
        spawnBlocks();
    }
    
    // spawns block every 70 frames
    public void spawnBlocks()
    {
        blockSpawnTimer ++;
        
        if(blockSpawnTimer % 70 == 0)
        {
            // Sets random x position except for some space on the edges of screen
            int posX = Greenfoot.getRandomNumber((getWidth() - 180 ) + 90);
            int posY = 30;
            
            // Generates a random number used to determine which block spawns
            int random = Greenfoot.getRandomNumber(100);
            
            // Spawns either red or point block depending on the random number generated above
            if(random < 70)
            {
                addObject(new Block("Red", 5), posX, posY);
            }
            else if(random > 71)
            {
                addObject(new PointBlock("Point", 5), posX, posY);
            }
        }
        
        
    }
    
    // This method updates the score. It is called in the point block class
    public void addScore()
    {
        streak++;
        
        int points = 1;
        
        if(streak >= 20)
        {
            points = 4;
        }
        else if(streak >= 10)
        {
            points = 2;
        }
        
        score += points;
        scoreLabel.setValue("" + score);
    }
    
    // This method resets the players streak. It is called in the point block class
    public void resetStreak()
    {
        streak = 0;
    }
}
