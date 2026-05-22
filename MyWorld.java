import greenfoot.*;

public class MyWorld extends World {
    
    // Timer that increases ever frame
    private int blockSpawnTimer = 0;
    
    // Stores the users score
    private int score = 0;
    
    // Label of the score
    private Label scoreLabel;
    
    
    public MyWorld() {
        super(560, 720, 1);
        
        // Set background colour
        getBackground().setColor(new Color(199, 174, 210));
        getBackground().fill();

        scoreLabel = new Label("0",120);
        addObject(scoreLabel, 280, 80);
        scoreLabel.setFillColor(new Color(148, 168, 190));
        scoreLabel.setLineColor(new Color(148, 168, 190)); 
        
        Path playerPath = new Path();
        addObject(playerPath, 280, 390);
        
        Player ball = new Player();
        addObject(ball, 280, 390); 
        
    }
    
    
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
            
            // Spawn block
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
    
    public void addScore(int points)
    {
        score += points;
        scoreLabel.setValue("" + score);
    }
}
