package top.nemanja.paczmija.layers;

import top.nemanja.paczmija.Drawable;
import top.nemanja.paczmija.layers.graphicObjects.Snowflake;

import java.awt.*;

public class SnowLayer implements Drawable {
    Snowflake[] flakes;

    public SnowLayer(){
        // TODO: fix width and height

        this.flakes = new Snowflake[100];

        for(int i = 0; i < 100; i++){
            this.flakes[i] = new Snowflake();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        for(Snowflake flake: flakes){
            flake.draw(graphics2D, i, i1);
        }
    }

    @Override
    public void tick() {
        for(int i = 0; i < flakes.length; i++){
            if(!flakes[i].isInScreen()){
                flakes[i] = new Snowflake();
            }

            flakes[i].tick();
        }
    }
}
