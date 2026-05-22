import greenfoot.*;

public class MyWorld extends World {

    private int blockSpawnTimer = 0;
    
    public MyWorld() {
        super(600, 750, 1);
        
        Player ball = new Player();
        addObject(ball, 300, 420);
        
        PointBlock b = new PointBlock("Point", 3);
        addObject(b, 300, 420);
        
        
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
            int posX = Greenfoot.getRandomNumber((getWidth() - 120 ) + 60);
            int posY = 30;
            
            // Spawn block
            addObject(new Block("Red", 5), posX, posY);
        }
        
        
    }
}
