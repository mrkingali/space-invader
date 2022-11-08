package ir.ac.kntu.eleman;

import ir.ac.kntu.view.GameView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Enemy1 extends Enemy {

    Image url1 = new Image("assets/alien_one_white.png", Constants.AlienLength, Constants.AlienWidth, true, false);
    Image url2=new Image("assets/alien_one_white_2.png",Constants.AlienLength,Constants.AlienWidth,false,true);
    ImageView image2 = new ImageView(url2);
    ImageView image1 = new ImageView(url1);

    public Enemy1(int layoutX, int layoutY) {
        imageState=true;
        super.setLayoutX(layoutX);
        super.setLayoutY(layoutY);
        super.setLength(Constants.AlienLength);
        super.setWidth(Constants.AlienWidth);
        super.setDx(0);
        super.setDy(0);
        super.setAlive(true);
        super.setImg1Url("assets/alien_one_white.png");
        super.setImg2Url("assets/alien_one_white_2.png");

        super.setImageView(image1);


    }
    public void chooseImage() {
        if (super.getAlive()) {
            if (imageState) {
                super.setImageView(image1);
            } else {
                super.setImageView(image2);
            }
        }

    }



}
