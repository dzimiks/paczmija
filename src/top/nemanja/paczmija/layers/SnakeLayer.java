package top.nemanja.paczmija.layers;

import top.nemanja.paczmija.Drawable;
import top.nemanja.paczmija.KeyEmitter;
import top.nemanja.paczmija.KeyEmitterListener;

import java.awt.*;
import java.security.SecureRandom;
import java.util.LinkedList;

public class SnakeLayer implements Drawable, KeyEmitterListener {
    LinkedList<Segment> segments;

    int tick;
    private SecureRandom rnd;

    int headX;
    int headY;

    int speedX = 0;
    int speedY = 0;

    public SnakeLayer(){
        this.tick = 0;
        segments = new LinkedList<>();
        segments.add(new Segment(5, 5));

        headX = 5;
        headY = 5;

        speedX = 1;
        speedY = 0;

        rnd = new SecureRandom();

        KeyEmitter.listen("up", this);
        KeyEmitter.listen("down", this);
        KeyEmitter.listen("left", this);
        KeyEmitter.listen("right", this);
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

        if(tick % 10 == 0) {
            if (tick % 100 != 0) {
                segments.removeFirst();
            }

            headX += speedX;
            headY += speedY;

            segments.add(new Segment(headX, headY));
        }
    }

    @Override
    public void keyPressed(String key) {
        switch(key){
            case "up":
                speedX = 0;
                speedY = -1;
                break;
            case "down":
                speedX = 0;
                speedY = 1;
                break;
            case "left":
                speedX = -1;
                speedY = 0;
                break;
            case "right":
                speedX = 1;
                speedY = 0;
                break;
            default:
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
