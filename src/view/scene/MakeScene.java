package view.scene;

import javafx.scene.Scene;

import java.util.Observable;

public interface MakeScene {
    Scene scene = null;

    Scene getScene();
    void update(Observable o, Object arg);
}
