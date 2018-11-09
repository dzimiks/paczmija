package top.nemanja.paczmija.layers;

import rafgfxlib.Util;
import top.nemanja.paczmija.Drawable;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Random;

import static java.awt.image.BufferedImage.TYPE_4BYTE_ABGR;

public class BackgroundLayer implements Drawable {
    public BufferedImage background;

    public static int clamp(int value, int min, int max) {
        if (value < min) return min;
        if (value > max) return max;
        return value;
    }

    public static int saturate(int value) {
        return clamp(value, 0, 255);
    }

    public BackgroundLayer() {
        BufferedImage image = new BufferedImage(800, 800, TYPE_4BYTE_ABGR);
        WritableRaster target = Util.createRaster(image.getWidth(), image.getHeight(), false);

        double noise = 100 / 255.0;
        int rgb[] = new int[3];

        Random rnd = new Random();

        for (int y = 0; y < target.getHeight(); y++) {
            for (int x = 0; x < target.getWidth(); x++) {
                double factor = 1.0 + rnd.nextDouble() * noise - noise / 2.0;

                rgb[0] = saturate((int) (30 * factor));
                rgb[1] = saturate((int) (30 * factor));
                rgb[2] = saturate((int) (30 * factor));

                target.setPixel(x, y, rgb);
            }
        }

        this.background = Util.rasterToImage(target);
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        graphics2D.drawImage(this.background, 0, 0, this.background.getWidth(), this.background.getHeight(), null);
    }

    @Override
    public void tick() {

    }
}
