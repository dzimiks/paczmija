package top.nemanja.paczmija.layers;

import top.nemanja.paczmija.Drawable;
import top.nemanja.paczmija.layers.graphicObjects.Snowflake;

import java.awt.*;

public class SnowLayer implements Drawable {
    Snowflake[] flakes;
    private int flakeCount = 150;

    public SnowLayer() {
        this.flakes = new Snowflake[flakeCount];

        for (int i = 0; i < flakeCount; i++) {
            this.flakes[i] = new Snowflake();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        for (Snowflake flake : flakes) {
            flake.draw(graphics2D, i, i1);
        }
    }

    @Override
    public void tick() {
        for (int i = 0; i < flakes.length; i++) {
            if (!flakes[i].isInScreen()) {
                flakes[i] = new Snowflake();
            }

            flakes[i].tick();
        }
    }
}
