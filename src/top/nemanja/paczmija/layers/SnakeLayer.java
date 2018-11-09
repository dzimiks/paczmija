package top.nemanja.paczmija.layers;

import top.nemanja.paczmija.Drawable;

import java.awt.*;
import java.security.SecureRandom;
import java.util.LinkedList;

public class SnakeLayer implements Drawable {
    LinkedList<Segment> segments;

    int tick;
    private SecureRandom rnd;

    public SnakeLayer(){
        this.tick = 0;
        segments = new LinkedList<>();
        segments.add(new Segment(5, 5));

        rnd = new SecureRandom();
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        for(Segment segment: segments){
            graphics2D.setColor(Color.green);
            graphics2D.fillRect(segment.getX() * 10, segment.getY() * 10, 10,10);
        }
    }

    @Override
    public void tick() {
        tick++;

        if(tick % 10 == 0){
            segments.add(new Segment(this.rnd.nextInt(80), this.rnd.nextInt(60)));
            System.out.println("New Segment");
        }
    }
}

class Segment{
    private int x;
    private int y;

    public Segment(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }
}
