package view;

import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Created by Ilua on 11.12.2016.
 */
public abstract class AbstractView{
    private Integer width;
    private Integer height;

    public AbstractView(Integer width, Integer height) {
        this.width = width;
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Scene getScene() {
        return new Scene(buildScene(),width,height);
    }

    protected abstract Parent buildScene();
}
