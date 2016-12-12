import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import controller.GUIController;
import view.ConverterAndGraphicsView;
import view.Scene_Type;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Ilua on 11.12.2016.
 */
public class CurrencyConverter extends Application {


    @Override
    public void start(Stage stage) {
        Map<Scene_Type,Scene> scenes=new HashMap<>();
        scenes.put(Scene_Type.CONVERTER_GRAPHICS_SCENE,new ConverterAndGraphicsView(1280,720).getScene());

        GUIController guiController=new GUIController(scenes, stage, "Currency Converter");
        guiController.showScene(Scene_Type.CONVERTER_GRAPHICS_SCENE);

    }

    public static void main(String[] args) throws Exception {
        Application.launch(args);
    }
}
