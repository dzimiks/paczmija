package snake;

import rafgfxlib.GameHost;

public class Main {
    private static GameHost gameHost = null;

    public static void main(String[] args) {
        GameHost host = new GameHost("Snake", 800, 600, false);
        Main.gameHost = host;

        host.setUpdateRate(60);

        new MainState(host);

        host.setState("game");
    }

    public static GameHost getGameHost() {
        return Main.gameHost;
    }
}
