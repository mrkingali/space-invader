package ir.ac.kntu.eleman;

import ir.ac.kntu.view.GameView;
import javafx.scene.image.ImageView;

public class EnemyGroup {

    Enemy[][] enemies=new Enemy[5][10];

    public  EnemyGroup(){

        for(int i=0;i<10;i++){
            for (int j = 0; j <5 ; j++) {
                if(j<2){
                    enemies[j][i]=new Enemy2(30+Constants.AlienWidth*i,40+Constants.AlienLength*j);
                }else{
                    enemies[j][i]=new Enemy1(30+Constants.AlienWidth*i,40+Constants.AlienLength*j);
                }
            }
        }
    }

    public Enemy[][] getEnemies() {
        return enemies;
    }

    public void setEnemies(Enemy[][] enemies) {
        this.enemies = enemies;
    }




}
