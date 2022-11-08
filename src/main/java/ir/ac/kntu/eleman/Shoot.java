package ir.ac.kntu.eleman;


import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Shoot extends Entity {

    public static final String imageUrl="assets/shoot.jpg";
    public static final Image image=new Image(imageUrl,30,30,false,true);

    public Shoot(int layoutX,int layoutY) {

        super.setLayoutX(layoutX);
        super.setLayoutY(layoutY);
        super.setImage(image);
        super.setImageView(new ImageView(image));
}

    public int getImageXCenter(){
        return (super.getLayoutX()+15);
    }


}
