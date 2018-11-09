package snake.layers;

import snake.Drawable;
import snake.KeyEmitter;
import snake.KeyEmitterListener;

import java.awt.*;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.LinkedList;

public class SnakeLayer implements Drawable, KeyEmitterListener {
    LinkedList<Segment> segments;

    int tick;
    private SecureRandom rnd;

    int headX;
    int headY;

    int speedX = 0;
    int speedY = 0;

    public SnakeLayer() {
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
        graphics2D.drawString("Score: " + segments.size() * 5, 20, 40);

        Color[] colors = {
                Color.red,
                Color.green,
                Color.blue,
                Color.orange
        };

        int in = 0;

        for (Segment segment : segments) {
            in++;
            graphics2D.setColor(colors[(segments.size() + in) % colors.length]);
            graphics2D.fillRect(15 + segment.getX() * 10, 15 + segment.getY() * 10, 9, 9);
        }
    }

    @Override
    public void tick() {
        tick++;

        if (tick % 10 == 0) {
            if (headX + speedX > 76 || headX + speedX < 0) {
                return;
            }

            if (headY + speedY > 56 || headY + speedY < 0) {
                return;
            }

            if (tick % 100 != 0) {
                segments.removeFirst();
            }

            headX += speedX;
            headY += speedY;

            boolean hit = false;

            for (Segment segment : segments) {
                if (segment.getX() == headX && segment.getY() == headY) {
                    hit = true;
                }
            }

            if (hit) {
                ArrayList<Segment> toDelete = new ArrayList<>();

                for (Segment segment : segments) {
                    toDelete.add(segment);

                    if (segment.getX() == headX && segment.getY() == headY) {
                        break;
                    }
                }

                segments.removeAll(toDelete);
            }

            segments.add(new Segment(headX, headY));
        }
    }

    private String direction = "right";

    @Override
    public void keyPressed(String key) {
        switch (key) {
            case "up":
                if (direction != "down") {
                    speedX = 0;
                    speedY = -1;

                    direction = key;
                }
                break;
            case "down":
                if (direction != "up") {
                    speedX = 0;
                    speedY = 1;

                    direction = key;
                }
                break;
            case "left":
                if (direction != "right") {
                    speedX = -1;
                    speedY = 0;

                    direction = key;
                }
                break;
            case "right":
                if (direction != "left") {
                    speedX = 1;
                    speedY = 0;

                    direction = key;
                }
                break;
            default:
        }
    }
}

class Segment {
    private int x;
    private int y;

    public Segment(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
