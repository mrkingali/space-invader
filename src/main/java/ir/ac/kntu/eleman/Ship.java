package ir.ac.kntu.eleman;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Ship extends Entity {

    public Ship() {
        super.setLayoutX(Constants.X_POS_SHIP);
        super.setLayoutY(Constants.Y_POS_SHIP);
        super.setLength(Constants.SHIP_LENGTH);
        super.setLength(Constants.SHIP_WIDTH);
        super.setDx(0);
        super.setDy(0);

        super.setImg1Url("assets/spaceship.png");
        super.setImage(new Image(super.getImg1Url(),Constants.SHIP_LENGTH,Constants.SHIP_WIDTH ,true,true));
        super.setImageView(new ImageView(super.getImage()));

        super.setAlive(true);

    }



}
