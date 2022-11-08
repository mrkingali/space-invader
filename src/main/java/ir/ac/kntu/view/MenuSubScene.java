package ir.ac.kntu.view;

import javafx.animation.TranslateTransition;
import javafx.scene.Parent;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.util.Duration;

public class MenuSubScene extends SubScene {

    private final static String BACKGROUND_IMAGE = "PNG/yellow_panel.png";

    private Boolean isHidden;

    public MenuSubScene() {

        super(new AnchorPane(), 550, 350);
        prefWidth(550);
        prefHeight(350);


        BackgroundImage backgroundImage = new BackgroundImage(new Image(BACKGROUND_IMAGE, 550, 350, false, true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);

        setLayoutX(400);
        setLayoutY(875);


        AnchorPane root2 = (AnchorPane) this.getRoot();
        root2.setBackground(new Background(backgroundImage));
        isHidden = true;

    }

    public void moveSubMenu() {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(.3));
        transition.setNode(this);
        if (isHidden) {
            isHidden = false;
            transition.setToY(-676);

        } else {
            isHidden = true;
            transition.setToY(+676);

        }

        transition.play();
    }

    public  AnchorPane getPane(){
        return (AnchorPane) this.getRoot();
    }


}
