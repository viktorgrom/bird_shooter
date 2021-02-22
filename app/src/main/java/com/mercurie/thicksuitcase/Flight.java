package com.mercurie.thicksuitcase;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.mercurie.thicksuitcase.GameView.screenRatioX;
import static com.mercurie.thicksuitcase.GameView.screenRatioY;

public class Flight {

    boolean isGoingUp = false;
    int toShoot = 0;

    int x, y, width, height, wingCounter = 0, shootCounter = 1;
    Bitmap thickfly1, thickfly2, thickshoot1, thickshoot2, thickshoot3, thickshoot4, dead;
    private GameView gameView;

    Flight (GameView gameView, int screenY, Resources res){

        this.gameView = gameView;

        thickfly1 = BitmapFactory.decodeResource(res, R.drawable.thick_fly1);
        thickfly2 = BitmapFactory.decodeResource(res, R.drawable.thick_fly2);

        width = thickfly1.getWidth();
        height = thickfly1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        thickfly1 = Bitmap.createScaledBitmap(thickfly1, width, height, false);
        thickfly2 = Bitmap.createScaledBitmap(thickfly2, width, height, false);

        thickshoot1 = BitmapFactory.decodeResource(res, R.drawable.thi_sho1);
        thickshoot2 = BitmapFactory.decodeResource(res, R.drawable.thi_sho2);
        thickshoot3 = BitmapFactory.decodeResource(res, R.drawable.thi_sho3);
        thickshoot4 = BitmapFactory.decodeResource(res, R.drawable.thi_sho4);


        thickshoot1 = Bitmap.createScaledBitmap(thickshoot1, width, height, false);
        thickshoot2 = Bitmap.createScaledBitmap(thickshoot2, width, height, false);
        thickshoot3 = Bitmap.createScaledBitmap(thickshoot3, width, height, false);
        thickshoot4 = Bitmap.createScaledBitmap(thickshoot4, width, height, false);


        dead = BitmapFactory.decodeResource(res, R.drawable.boom);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }

    Bitmap getFlight (){

        if (toShoot != 0){
            if (shootCounter == 1){
                shootCounter++;
                return thickshoot1;
            }
            if (shootCounter == 2){
                shootCounter++;
                return thickshoot2;
            }
            if (shootCounter == 3){
                shootCounter++;
                return thickshoot3;
            }

            shootCounter = 1;
            toShoot --;
            gameView.newBullet();

            return thickshoot4;
        }

        if (wingCounter == 0) {
            wingCounter++;
            return thickfly1;
        }
        wingCounter--;
        return thickfly2;
    }

    Rect getCollisionShape (){
        return  new Rect (x, y, x + width, y + height);
    }

    Bitmap getDead (){
        return  dead;
    }
}
