package com.mercurie.thicksuitcase;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

import static com.mercurie.thicksuitcase.GameView.screenRatioX;
import static com.mercurie.thicksuitcase.GameView.screenRatioY;

public class Bullet {

    int x, y, width, height;
    Bitmap nettos;

    Bullet (Resources res){
        nettos = BitmapFactory.decodeResource(res, R.drawable.netto);

        width = nettos.getWidth();
        height = nettos.getHeight();

        width /= 6;
        height /= 6;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        nettos = Bitmap.createScaledBitmap(nettos, width, height, false);
    }
    Rect getCollisionShape (){
        return  new Rect (x, y, x + width, y + height);
    }
}
