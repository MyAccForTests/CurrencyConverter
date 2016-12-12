package controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import view.Scene_Type;

import java.util.Map;

/**
 * Created by Ilua on 11.12.2016.
 */
public class GUIController {
    private Map<Scene_Type,Scene> scenes;
    private Stage stage;

    public GUIController(Map<Scene_Type, Scene> scenes, Stage stage, String title) {
        this.scenes = scenes;
        this.stage=stage;
        stage.setTitle(title);
    }
    public void showScene(Scene_Type scene)
    {
        stage.setScene(scenes.get(scene));
        stage.show();
    }
}
