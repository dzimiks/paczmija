package top.nemanja.paczmija.layers.graphicObjects;

import top.nemanja.paczmija.Drawable;
import top.nemanja.paczmija.Main;

import java.awt.*;
import java.security.SecureRandom;

public class Snowflake implements Drawable {
    private double xPos;
    private double yPos;

    private double[] velocity;
    private double[] acceleration;

    public Snowflake(){
        int width = Main.getGameHost().getWidth();
        int height = Main.getGameHost().getHeight();

        SecureRandom rnd = new SecureRandom();

        this.xPos = rnd.nextInt(width);
        //this.yPos = rnd.nextInt(height);
        this.yPos = rnd.nextInt(100) - 100;

        this.velocity = new double[2];
        this.velocity[0] = (rnd.nextDouble() * 2) - 1;
        this.velocity[1] = Math.sqrt(1 - Math.pow(Math.abs(this.velocity[0]), 2));
    }

    public boolean isInScreen(){
        int width = Main.getGameHost().getWidth();
        int height = Main.getGameHost().getHeight();

        if(this.xPos < 0 || this.xPos > width){
            return false;
        }

        if(this.yPos > height){
            return false;
        }

        return true;
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        graphics2D.setColor(Color.white);
        graphics2D.fillOval((int)this.xPos, (int)this.yPos, 2, 2);
    }

    @Override
    public void tick() {
        this.xPos += this.velocity[0];
        this.yPos += this.velocity[1];
    }
}
