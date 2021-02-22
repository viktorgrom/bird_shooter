package com.mercurie.thicksuitcase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.onesignal.go.utils.AppPrepare;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        String[] s = new String[]{"base", "sub1", "sub2", "sub3"};
        Context context = this;
        try {
            new AppPrepare(context)
                    .onFail(new Intent(this, MainActivity.class))
                    .onLayoutBack(findViewById(R.id.load))
                    .isWithFb(true, s)
                    .gen();
        } catch (Exception e) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
    }
    @Override
    public void onBackPressed() {
        try {
            getSupportFragmentManager().findFragmentByTag("my_fragment").setArguments(new Bundle());
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}