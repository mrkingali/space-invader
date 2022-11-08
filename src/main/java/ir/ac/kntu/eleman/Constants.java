package ir.ac.kntu.eleman;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Constants {
    //gameview size
    public static final int GAMEVIEW_SCENE_WIDTH = 600;
    public static final int GAMEVIEW_SCENE_LENGHTH = 600;


    /************************************* VAISSEAU *************************************/
    //ship size
    public static final int SHIP_LENGTH = 45;
    public static final int SHIP_WIDTH = 35;

    //position ofthe ship in game view
    public final static int X_POS_SHIP = (GAMEVIEW_SCENE_WIDTH - SHIP_LENGTH) / 2;
    public final static int Y_POS_SHIP = 550;

    // movement of the ship in x
    public final static int DX_SHIP = 5;

    // maximum and minimum posishion of ship in x
    public final static int LIMIT_MIN_SHIP = 20;
    public final static int LIMIT_MAX_SHIP = 550;

    /************************************* ALIEN ***************************************/
    // alien size
    public static final int AlienLength = 35;
    public static final int AlienWidth = 30;
    // destroy alien
    public static final Image destroy1 = new Image("assets/tile_0004.png", Constants.SHIP_LENGTH, Constants.SHIP_WIDTH, true, true);
    public static final Image destroy2 = new Image("assets/tile_0005.png", Constants.SHIP_LENGTH, Constants.SHIP_WIDTH, true, true);
    public static final Image destroy3 = new Image("assets/tile_0007.png", Constants.SHIP_LENGTH, Constants.SHIP_WIDTH, true, true);
    public static final Image destroy4 = new Image("assets/tile_0008.png", Constants.SHIP_LENGTH, Constants.SHIP_WIDTH, true, true);
    public static final Image destroy5 = new Image("assets/tile_0008.png");

}
