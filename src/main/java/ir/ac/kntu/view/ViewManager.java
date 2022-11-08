package ir.ac.kntu.view;

import ir.ac.kntu.Button.SpaceButton;
import ir.ac.kntu.eleman.Level;
import ir.ac.kntu.picker.LevelPicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class ViewManager {
    private AnchorPane mainPane;
    private Scene mainScene;
    private Stage mainStage;

    private final static int MENU_BUTTON_X = 100;
    private final static int MENU_BUTTON_Y = 200;

    List<SpaceButton> spaceButtonList;

    private static MenuSubScene newSubScene;
    private static MenuSubScene scorSubScene;
    private static MenuSubScene helpSubScene;

    private static MenuSubScene sceneToHide;

    private Level choosenLevel;
    List<LevelPicker> levelList;
    public ViewManager() {
        spaceButtonList = new ArrayList<>();
        mainPane = new AnchorPane();
        mainScene = new Scene(mainPane, 1024, 764);
        mainStage = new Stage();
        mainStage.setScene(mainScene);
        creatButton();
        creatBackground();
        creatLogo();
        creatSubScene();
        creatTextForHelpScene();

    }

    private void creatSubScene() {
        helpSubScene = new MenuSubScene();
        mainPane.getChildren().add(helpSubScene);
        newSubScene = new MenuSubScene();
        mainPane.getChildren().add(newSubScene);
        scorSubScene = new MenuSubScene();
        mainPane.getChildren().add(scorSubScene);

        creatLevelPicker();
    }

    private void creatTextForHelpScene(){
        Text helpText=new Text();
        helpText.setText("hi ! " +
                "\nthis is the space invader " +
                "\ngame you should kill the alien " +
                "\nand get point there are three type" +
                "\nof them in the game touch play " +
                "\nnew gamme if you are new either " +
                "\ntouch score and select you game");
        helpText.setX(40);
        helpText.setY(50);
        try {
            helpText.setFont(Font.loadFont(new FileInputStream("src/main/resources/Font/kenvector_future_thin.ttf"),25));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        helpSubScene.getPane().getChildren().add(helpText);
    }


    private void creatLevelPicker() {
        newSubScene = new MenuSubScene();
        mainPane.getChildren().add(newSubScene);
        newSubScene.getPane().getChildren().add(creatLevelToChoose());

    }
    private HBox creatLevelToChoose(){
        HBox box=new HBox();
        box.setSpacing(20);
        levelList=new ArrayList<>();
        for(Level level:Level.values()){
            LevelPicker levelPicker=new LevelPicker(level);
            levelList.add(levelPicker);
            box.getChildren().add(levelPicker);
            levelPicker.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    for(LevelPicker levelPicker1:levelList){
                        levelPicker1.setIsCicleSelect(false);

                    }
                    levelPicker.setIsCicleSelect(true);
                    choosenLevel=levelPicker.getLevel();
                }
            });

        }
        box.setLayoutX(100);
        box.setLayoutY(100);

        return box;
    }

    public Stage getMainStage() {
        return mainStage;
    }

    private void addMenuButton(SpaceButton spaceButton) {
        spaceButton.setLayoutX(MENU_BUTTON_X);
        spaceButton.setLayoutY(MENU_BUTTON_Y + spaceButtonList.size() * 100);
        spaceButtonList.add(spaceButton);
        mainPane.getChildren().add(spaceButton);

    }

    private void creatButton() {

        creatStartButton();
        creatScoreButton();
        creatHelpButton();
        creatExitButton();

    }

    private void showScene(MenuSubScene menuSubScene) {
        if (sceneToHide == null) {
            menuSubScene.moveSubMenu();
            sceneToHide = menuSubScene;
        } else if (sceneToHide.equals(menuSubScene)) {
            sceneToHide.moveSubMenu();
            sceneToHide=null;
        } else {
            sceneToHide.moveSubMenu();
            menuSubScene.moveSubMenu();
            sceneToHide = menuSubScene;
        }
    }

    private void creatStartButton() {

        SpaceButton startButton = new SpaceButton("Play");

        addMenuButton(startButton);
        startButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SpaceButton b=new SpaceButton("next");
                b.setTranslateX(300);
                b.setTranslateY(280);
                newSubScene.getPane().getChildren().add(b);
                showScene(newSubScene);
                b.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        if(choosenLevel!=null) {
                            GameView g = new GameView();
                            g.creatNewGame(mainStage, choosenLevel);
                        }
                    }
                });
            }
        });

    }

    private void creatScoreButton() {

        SpaceButton scoreButton = new SpaceButton("Scores");
        addMenuButton(scoreButton);
        scoreButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showScene(scorSubScene);
            }
        });

    }

    private void creatHelpButton() {

        SpaceButton helpButton = new SpaceButton("Help");
        addMenuButton(helpButton);
        helpButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                showScene(helpSubScene);
            }
        });

    }

    private void creatExitButton() {

        SpaceButton exitButton = new SpaceButton("Exit");
        addMenuButton(exitButton);
        exitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                mainStage.close();
            }
        });

    }


    private void creatBackground() {
        Image image = new Image("assets/background.jpg", 256, 256, false, true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        mainPane.setBackground(new Background(background));

    }

    private void creatLogo() {
        ImageView imageView = new ImageView("space-invaders2.png");
        mainStage.getIcons().add(new Image("space-invaders2.png"));
        imageView.setLayoutX(350);
        imageView.setLayoutY(30);

        imageView.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setEffect(new DropShadow());
            }
        });
        imageView.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                imageView.setEffect(null);
            }
        });

        mainPane.getChildren().add(imageView);

    }
}
