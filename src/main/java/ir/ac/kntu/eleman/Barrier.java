package ir.ac.kntu.eleman;

import ir.ac.kntu.view.GameView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BackgroundImage;

public class Barrier extends Entity{
    private int heart;
    private Image image=new Image("assets/obstacle.png",70,70,false,true);
    private ImageView imageView=new ImageView();

    public static Barrier barrier1=new Barrier(100,420);
    public static Barrier barrier2=new Barrier(250,420);
    public static Barrier barrier3=new Barrier(400,420);


    public static Barrier getBarrier1() {
        return barrier1;
    }

    public static Barrier getBarrier2() {
        return barrier2;
    }

    public static Barrier getBarrier3() {
        return barrier3;
    }

    private Barrier(int layoutX, int layoutY){

        imageView.setImage(image);

        super.setLayoutX(layoutX);
        super.setLayoutY(layoutY);

        super.setImageView(imageView);
        super.setImage(image);

        super.getImageView().setLayoutX(layoutX);
        super.getImageView().setLayoutY(layoutY);

        super.setLength(70);
        super.setWidth(70);
        heart=3;

    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    public int getHeart() {
        return heart;
    }

    public void setHeart(int heart) {
        this.heart = heart;
    }

    @Override
    public ImageView getImageView() {
        if(heart<=0){
            return new ImageView();
        }
        return imageView;
    }

    @Override
    public void setImageView(ImageView imageView) {

        this.imageView = imageView;
    }
}
