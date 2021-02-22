package com.mercurie.thicksuitcase;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x=0, y=0;
    Bitmap bgrd;

    Background (int screenX, int screenY, Resources res){
        bgrd = BitmapFactory.decodeResource(res, R.drawable.fon);
        bgrd = Bitmap.createScaledBitmap(bgrd, screenX, screenY, false);
    }
}
