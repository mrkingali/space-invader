package ir.ac.kntu;

import ir.ac.kntu.scene.Menu;
import ir.ac.kntu.view.ViewManager;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.awt.*;
import java.io.FileInputStream;

public class Main extends Application {
    public static Stage stageMain;


    @Override
    public void start(Stage primaryStage) throws Exception {
        ViewManager manager=new ViewManager();
        primaryStage=manager.getMainStage();
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
