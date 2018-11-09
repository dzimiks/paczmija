package top.nemanja.paczmija;

import rafgfxlib.GameHost;

public class Main {
    public static void main(String[] args) {
        GameHost host = new GameHost("Snake", 800, 600, false);

        host.setUpdateRate(60);

        new MainState(host);

        host.setState("game");
    }
}
