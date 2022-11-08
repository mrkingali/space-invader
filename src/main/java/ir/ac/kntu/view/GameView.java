package ir.ac.kntu.view;

import com.sun.scenario.effect.impl.state.AccessHelper;
import ir.ac.kntu.eleman.*;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.awt.image.AreaAveragingScaleFilter;
import java.sql.Struct;
import java.util.ArrayList;

public class GameView {
    public static AnchorPane gamePane;
    private Scene gameScene;
    private Stage gameStage;
    private Stage menuStage;
    private static final Ship ship = new Ship();
    private static final EnemyGroup enemies = new EnemyGroup();

    public static String scoreText = "0";

    public boolean isShieldAvailable = false;
    public boolean isBomberdAvailable = false;
    public boolean isLaserdAvailable = false;
    public boolean isHeartAvailable = false;

    public static ImageView imageViewShip;
    public static ImageView[][] imageViewEnemy;

    public static ArrayList<ImageView> shoots;
    public boolean isAliveGame = true;
    Text scoreNumber;

    Text score;
    public int shipXLayout = 0;


    public GameView() {


        initializeGameScene();
        creatHeart();
        creatBackGround();
        imageViewShip = ship.getImageView();
        imageViewShip.setLayoutY(ship.getLayoutY());
        imageViewShip.setLayoutX(ship.getLayoutX());
        gameStage.setTitle("shoot the alien");
        gameStage.getIcons().add(new Image("space-invaders2.png"));
        gamePane.getChildren().add(imageViewShip);
        imageViewEnemy = new ImageView[5][10];

        score = new Text();
        score.setText("score :");
        score.setLayoutX(300);
        score.setLayoutY(35);
        score.setFont(Font.font("verdana", 25));
        score.setFill(Color.GREEN);

        gamePane.getChildren().add(score);

        scoreNumber = new Text();
        scoreNumber.setText(scoreText);
        scoreNumber.setLayoutX(400);
        scoreNumber.setLayoutY(35);
        scoreNumber.setFont(Font.font("verdana", 25));
        scoreNumber.setFill(Color.GREEN);


        //
        gamePane.getChildren().add(scoreNumber);

        shoots = new ArrayList<>();

        initialaizeImageViewEnemy();
        moveImageAlien(30);

        addBarier();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                keyListener();
            }
        };
        timer.start();

        //putRandomShield();

    }

    public void setScoreText(String text) {
        scoreText = Integer.toString(Integer.parseInt(scoreText) + Integer.parseInt(text));
        scoreNumber.setText(scoreText);
    }


    public void addBarier() {
        gamePane.getChildren().addAll(Barrier.barrier1.getImageView(), Barrier.barrier2.getImageView(), Barrier.barrier3.getImageView());
    }

    private void moveImageAlien(int dx) {

        class A extends Thread {
            public A() {
            }

            @Override
            public void run() {

                for (int k = 0; k < 8; k++) {
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 5; j++) {

                            enemies.getEnemies()[j][i].setLayoutX(enemies.getEnemies()[j][i].getLayoutX() + dx);
                            enemies.getEnemies()[j][i].chooseImage();


                        }
                    }
                    Enemy.imageState = !Enemy.imageState;
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    updateEnemies();

                }
                for (int i = 0; i < 10; i++) {
                    for (int j = 0; j < 5; j++) {

                        enemies.getEnemies()[j][i].setLayoutY(enemies.getEnemies()[j][i].getLayoutY() + 35);
                        enemies.getEnemies()[j][i].chooseImage();


                    }
                }
                Enemy.imageState = !Enemy.imageState;
                try {
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                updateEnemies();


            }
        }
        A a = new A();

        a.start();


    }

    private void initialaizeImageViewEnemy() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {

                imageViewEnemy[j][i] = enemies.getEnemies()[j][i].getImageView();


                //imageViewEnemy[j][i].setLayoutY(enemies.getEnemies()[j][i].getLayoutY());
                imageViewEnemy[j][i].setLayoutX(enemies.getEnemies()[j][i].getLayoutX());
                gamePane.getChildren().add(imageViewEnemy[j][i]);

            }
        }

    }

    private void updateEnemies() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 5; j++) {


                // gamePane.getChildren().remove(imageViewEnemy[j][i]);
                //  imageViewEnemy[j][i]=enemies.getEnemies()[j][i].getImageView();
                imageViewEnemy[j][i].setLayoutY(enemies.getEnemies()[j][i].getLayoutY());
                imageViewEnemy[j][i].setLayoutX(enemies.getEnemies()[j][i].getLayoutX());
                // gamePane.getChildren().add(imageViewEnemy[j][i]);


            }
        }
    }

    private void initializeGameScene() {
        gamePane = new AnchorPane();
        gameScene = new Scene(gamePane, Constants.GAMEVIEW_SCENE_LENGHTH, Constants.GAMEVIEW_SCENE_WIDTH);
        gameStage = new Stage();
        gameStage.setScene(gameScene);

    }

    public void updateShipXY() {
        imageViewShip.setLayoutY(ship.getLayoutY());
        imageViewShip.setLayoutX(ship.getLayoutX());
    }

    public void creatHeart() {
        Image image = new Image("assets/heart.png", 30, 30, false, true);
        ImageView heart1 = new ImageView(image);
        ImageView heart2 = new ImageView(image);
        ImageView heart3 = new ImageView(image);
        heart1.setLayoutY(10);
        heart1.setLayoutX(510);
        heart2.setLayoutY(10);
        heart2.setLayoutX(540);
        heart3.setLayoutY(10);
        heart3.setLayoutX(570);
        gamePane.getChildren().addAll(heart1, heart2, heart3);


    }

    private void keyListener() {

        gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {

                if (keyEvent.getCode() == KeyCode.LEFT) {

                    if (ship.getLayoutX() >= Constants.LIMIT_MIN_SHIP) {
                        ship.setLayoutX(ship.getLayoutX() - Constants.DX_SHIP);
                        shipXLayout = ship.getLayoutX();

                    }

                } else if (keyEvent.getCode() == KeyCode.RIGHT) {

                    if (ship.getLayoutX() <= Constants.LIMIT_MAX_SHIP) {
                        ship.setLayoutX(ship.getLayoutX() + Constants.DX_SHIP);
                        shipXLayout = ship.getLayoutX();
                    }
                }

                updateShipXY();

                if (keyEvent.getCode() == KeyCode.SPACE) {
                    ImageView imageView = new ImageView(new Image("assets/shoot.jpg", 30, 30, false, true));
                    imageView.setLayoutX(ship.getLayoutX());
                    imageView.setLayoutY(ship.getLayoutY() - 30);
                    gamePane.getChildren().add(imageView);
                    for (int i = 0; i < 119; i++) {
                        imageView.setLayoutY(imageView.getLayoutY() - 5);


                    }


                }


            }
        });


    }

    public void creatNewGame(Stage menuStage, Level level) {
        this.menuStage = menuStage;
        menuStage.hide();
        gameStage.show();
    }

    public void creatBackGround() {
        Image image = new Image("assets/background.jpg", 256, 256, false, true);
        BackgroundImage background = new BackgroundImage(image, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, null);
        gamePane.setBackground(new Background(background));


    }

    public Boolean chekBorderLeft() {
        if (imageViewEnemy[0][0].getLayoutX() < 10) {
            return true;

        } else {
            return false;
        }
    }

    public boolean checkBorderRight() {
        if (imageViewEnemy[0][9].getLayoutX() > 500) {
            return true;
        } else {
            return false;
        }
    }


    public void putRandomShield() {
        class TTimer extends Thread {
            @Override
            public void run() {
                try {
                    sleep(15000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                double a = Math.random();
                if (a < .25) {
                    Image image = new Image("assets/heart.png", 30, 30, false, true);
                    ImageView imageView = new ImageView(image);
                    imageView.setY(550);
                    imageView.setY(a * 100);
                    gamePane.getChildren().addAll(imageView);
                    isHeartAvailable = true;
                    try {
                        sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    imageView.setLayoutX(1000);
                    isHeartAvailable = false;

                } else if (a < .5 && 0.25 < a) {
                    Image image = new Image("assets/lasergun.png", 30, 30, false, true);
                    ImageView imageView = new ImageView(image);
                    imageView.setY(550);
                    imageView.setY(a * 100);
                    gamePane.getChildren().addAll(imageView);
                    isLaserdAvailable = true;
                    try {
                        sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    imageView.setLayoutX(1000);
                    isLaserdAvailable = false;

                } else if (0.5 < a && a < 0.75) {
                    Image image = new Image("assets/bombergun.png", 30, 30, false, true);
                    ImageView imageView = new ImageView(image);
                    imageView.setY(550);
                    imageView.setY(a * 50);
                    gamePane.getChildren().addAll(imageView);
                    isBomberdAvailable = true;
                    try {
                        sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    imageView.setLayoutX(1000);
                    isBomberdAvailable = false;
                } else {
                    Image image = new Image("assets/shield.png", 30, 30, false, true);
                    ImageView imageView = new ImageView(image);
                    imageView.setY(550);
                    imageView.setY(a * 50);
                    gamePane.getChildren().addAll(imageView);
                    isShieldAvailable = true;
                    try {
                        sleep(15000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    isShieldAvailable = false;
                    imageView.setLayoutX(1000);

                }

            }
        }

        TTimer t = new TTimer();
        while (isAliveGame) {
            t.start();
            try {
                t.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if ((isAliveGame == false)) {
                break;
            }
        }
    }
}
