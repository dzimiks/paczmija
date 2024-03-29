package snake;

import rafgfxlib.GameHost;
import rafgfxlib.GameState;

import snake.layers.BackgroundLayer;
import snake.layers.BlurLayer;
import snake.layers.SnakeLayer;
import snake.layers.SnowLayer;
import snake.layers.*;

import java.awt.*;

public class MainState extends GameState {
    public MainState(GameHost host) {
        super(host);
    }

    @Override
    public boolean handleWindowClose() {
        return true;
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
            new SnowLayer(),
            new SnowLayer(),
            new SnowLayer(),
            new BlurLayer(),
            new SnakeLayer(),
            new SnakeLayer(3, 3)
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
        switch (i) {
            case 38:
                KeyEmitter.callListeners("up");
                break;
            case 40:
                KeyEmitter.callListeners("down");
                break;
            case 37:
                KeyEmitter.callListeners("left");
                break;
            case 39:
                KeyEmitter.callListeners("right");
                break;
        }
    }

    @Override
    public void handleKeyUp(int i) {

    }
}
