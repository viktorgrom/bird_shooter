package com.mercurie.thicksuitcase;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.mercurie.thicksuitcase.GameView.screenRatioX;
import static com.mercurie.thicksuitcase.GameView.screenRatioY;

public class Bird {

    public int speed = 20;
    public boolean wasShot = true;
    int x=0, y, width, height, birdCounter = 1;
    Bitmap cas1, cas2, cas3, cas4;

    Bird (Resources res){
        cas1 = BitmapFactory.decodeResource(res, R.drawable.case1);
        cas2 = BitmapFactory.decodeResource(res, R.drawable.case2);
        cas3 = BitmapFactory.decodeResource(res, R.drawable.case3);
        cas4 = BitmapFactory.decodeResource(res, R.drawable.case4);

        width = cas1.getWidth();
        height = cas1.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        cas1 = Bitmap.createScaledBitmap(cas1, width, height, false);
        cas2 = Bitmap.createScaledBitmap(cas2, width, height, false);
        cas3 = Bitmap.createScaledBitmap(cas3, width, height, false);
        cas4 = Bitmap.createScaledBitmap(cas4, width, height, false);

        y = -height;
    }

    Bitmap getBird () {

        if (birdCounter == 1){
            birdCounter++;
            return cas1;
        }
        if (birdCounter == 2){
            birdCounter++;
            return cas2;
        }
        if (birdCounter == 3){
            birdCounter++;
            return cas3;
        }
        birdCounter = 1;

        return cas4;
    }

    Rect getCollisionShape (){
        return  new Rect (x, y, x + width, y + height);
    }
}
