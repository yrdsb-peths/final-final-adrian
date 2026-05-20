import greenfoot.*;

public class MyWorld extends World {
    public MyWorld() {
        super(600, 700, 1);
        
        Player ball = new Player();
        addObject(ball, 300, 420);
    }
}
