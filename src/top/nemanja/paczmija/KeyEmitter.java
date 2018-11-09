package top.nemanja.paczmija;

import java.util.ArrayList;
import java.util.HashMap;

public class KeyEmitter {
    private static HashMap<String, ArrayList<KeyEmitterListener>> listeners = null;

    public static HashMap<String, ArrayList<KeyEmitterListener>> getListeners() {
        if (KeyEmitter.listeners == null) {
            KeyEmitter.listeners = new HashMap<String, ArrayList<KeyEmitterListener>>();
        }

        return KeyEmitter.listeners;
    }

    public static void callListeners(String key) {
        HashMap<String, ArrayList<KeyEmitterListener>> listeners = KeyEmitter.getListeners();

        if (listeners.containsKey(key)) {
            ArrayList<KeyEmitterListener> listenerArray = listeners.get(key);

            for (KeyEmitterListener listener : listenerArray) {
                listener.keyPressed(key);
            }
        }
    }

    public static void listen(String key, KeyEmitterListener listener) {
        HashMap<String, ArrayList<KeyEmitterListener>> listeners = KeyEmitter.getListeners();

        if (listeners.containsKey(key)) {
            ArrayList<KeyEmitterListener> listenerArray = listeners.get(key);
            listenerArray.add(listener);
        } else {
            ArrayList<KeyEmitterListener> listenerArray = new ArrayList<>();
            listenerArray.add(listener);
            listeners.put(key, listenerArray);
        }
    }
}
