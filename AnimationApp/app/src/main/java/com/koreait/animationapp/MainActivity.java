package com.koreait.animationapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.intro);
    }

    public void trans(View view){
        //에니메이션을 버튼에 적용하여 구현
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.trans); //에니메이션의 내용..
        view.startAnimation(animation); //클릭한 버튼에게 에니메이션 적용
    }
}