package top.nemanja.paczmija.layers;

import top.nemanja.paczmija.Drawable;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BlurLayer implements Drawable {
    private BufferedImage frost;

    public BlurLayer() {
        try {
            frost = ImageIO.read(new File("images/frost.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics2D graphics2D, int i, int i1) {
        graphics2D.drawImage(this.frost, 0, 0, this.frost.getWidth(), this.frost.getHeight(), null);
    }

    @Override
    public void tick() {

    }
}
