package ir.ac.kntu.picker;

import ir.ac.kntu.eleman.Level;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javax.swing.text.StyledEditorKit;

public class LevelPicker extends VBox {
    private ImageView circle;
    private Text text;
    private Level level;

    private  String circleChoosed="PNG/green_boxTick.png";
    private  String circleEmpty="PNG/grey_circle.png";

    private Boolean isCicleSelect;

    public LevelPicker(Level level){
        this.level=level;
        circle=new ImageView(circleEmpty);
        text=new Text();
        text.setText(level.getLevel());
        isCicleSelect=false;
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.getChildren().add(circle);
        this.getChildren().add(text);


    }
    public Level getLevel(){
        return level;
    }

    public Boolean getIsCicleSelect(){
        return  isCicleSelect;
    }
    public void setIsCicleSelect(Boolean isCicleSelect){
        this.isCicleSelect=isCicleSelect;
        String imageToSet;
        if(isCicleSelect){
            imageToSet=circleChoosed;
        }else {
            imageToSet=circleEmpty;
        }
        circle.setImage(new Image(imageToSet));

    }

}
