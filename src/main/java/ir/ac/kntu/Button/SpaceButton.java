package ir.ac.kntu.Button;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class SpaceButton extends Button {

    private final String pathOfPress = "-fx-background-image: url('PNG/yellow_button03.png');";
    private final String pathOfRelease = "-fx-background-image: url('PNG/yellow_button04.png');";
    private final String pathOfEntered= "-fx-background-image: url('PNG/yellow_button02.png');";


    public SpaceButton(String text) {
        this.setText(text);
        setPrefHeight(49);
        setPrefWidth(190);
       this.setStyle(pathOfRelease);
       this.buttonListener();
        Font font;
        try {
           font=Font.loadFont(new FileInputStream("src/main/resources/Font/kenvector_future.ttf"),25);
            this.setFont(font);
        } catch (FileNotFoundException e) {
            this.setFont(Font.font("Verdana0,25"));
        }



    }

    private void setButtonPressed() {
        this.setStyle(pathOfPress);

        setPrefHeight(45);
        setLayoutY(getLayoutY() + 4);

    }

    private void setButtonReleased() {
        this.setStyle(pathOfRelease);

        setPrefHeight(49);
        setLayoutY(getLayoutY() - 4);
    }
    private void setButtonEntered() {
        this.setStyle(pathOfEntered);
        this.setEffect(new DropShadow());
    }
    private void setButtonExit() {
        this.setStyle(pathOfRelease);
        this.setEffect(null);
    }

    private void buttonListener() {

        setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {

                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonPressed();
                }
            }
        });

        setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    setButtonReleased();
                }
            }
        });

        setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonEntered();
            }
        });
        setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setButtonExit();
            }
        });
    }
}
