package com.gsl.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {

    TextView txtAnim1,txtAnim2;
    Animation Anim1,Anim2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        Intent iNext = new Intent(LoadingActivity.this, MainActivity.class);

        txtAnim1 = findViewById(R.id.txtAnim1);
        txtAnim2 = findViewById(R.id.txtAnim2);

        Anim1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.alphaanim);
        Anim2 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.scaleanim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                txtAnim1.startAnimation(Anim1);
                txtAnim2.startAnimation(Anim1);
                txtAnim1.startAnimation(Anim2);
                txtAnim2.startAnimation(Anim2);
                startActivities(new Intent[]{iNext});
                finish();
            }
        },4000);
    }
}