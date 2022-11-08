package ir.ac.kntu.scene;

import ir.ac.kntu.Main;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class Menu extends Group {



    public Menu(){
        Button playSaved=new Button();
        Button playnew=new Button();
        Button scoreTable=new Button();
        Button exit=new Button();
        Text t=new Text();

        this.getChildren().add(playnew);
        this.getChildren().add(playSaved);
        this.getChildren().add(scoreTable);
        this.getChildren().add(exit);
        this.getChildren().add(t);


        t.setText("<< Space Invader >>");
        t.setX(220);
        t.setY(50);


        playSaved.setMaxSize(100,300);
        playSaved.setTranslateX(50);
        playSaved.setTranslateY(100);
        playSaved.setText("play saved game");

        playnew.setMaxSize(100,300);
        playnew.setTranslateX(50);
        playnew.setTranslateY(150);
        playnew.setText("play new game");

        scoreTable.setMaxSize(100,300);
        scoreTable.setTranslateX(50);
        scoreTable.setTranslateY(200);
        scoreTable.setText("score table");


        exit.setMaxSize(50,300);
        exit.setTranslateX(100);
        exit.setTranslateY(250);
        exit.setText("exit");

        playSaved.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Group g=new Group();
                Scene scene2=new Scene(g,600,600);
                Main.stageMain.setScene(scene2);
            }
        });

        playnew.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Group g=new Group();
                Scene scene2=new Scene(g,600,600);
                Main.stageMain.setScene(scene2);
            }
        });

        scoreTable.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Group g=new Group();
                Scene scene2=new Scene(g,600,600);
                Main.stageMain.setScene(scene2);
            }
        });

        exit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Group g=new Group();
                Scene scene2=new Scene(g,600,600);
                Main.stageMain.setScene(scene2);
            }
        });




    }
}
