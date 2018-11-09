package top.nemanja.paczmija;

import rafgfxlib.GameHost;
import rafgfxlib.GameState;
import top.nemanja.paczmija.layers.BackgroundLayer;
import top.nemanja.paczmija.layers.SnowLayer;

import java.awt.*;

public class MainState extends GameState {
    public MainState(GameHost host){
        super(host);
    }

    @Override
    public boolean handleWindowClose() {
        return false;
    }

    @Override
    public String getName() {
        return "game";
    }

    @Override
    public void resumeState() {

    }

    @Override
    public void suspendState() {

    }

    Drawable[] drawables = {
            new BackgroundLayer(),
            new SnowLayer()
    };

    @Override
    public void render(Graphics2D graphics2D, int i, int i1) {
        for (Drawable drawable : drawables) {
            drawable.draw(graphics2D, i, i1);
        }
    }

    @Override
    public void update() {
        for (Drawable drawable : drawables) {
            drawable.tick();
        }
    }

    @Override
    public void handleMouseDown(int i, int i1, GameHost.GFMouseButton gfMouseButton) {

    }

    @Override
    public void handleMouseUp(int i, int i1, GameHost.GFMouseButton gfMouseButton) {

    }

    @Override
    public void handleMouseMove(int i, int i1) {

    }

    @Override
    public void handleKeyDown(int i) {

    }

    @Override
    public void handleKeyUp(int i) {

    }
}
