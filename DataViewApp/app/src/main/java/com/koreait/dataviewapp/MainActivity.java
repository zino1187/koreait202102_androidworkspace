package com.koreait.dataviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater layoutInflater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //인플레이션+ 뷰로 사용

        //스크롤뷰 안쪽의 리니어 레이아웃 가져오기
        container = (LinearLayout) findViewById(R.id.container);
        layoutInflater = this.getLayoutInflater();

        getList();
    }

    public void getList(){
        //item_board.xml 을 인플레이션 시켜 반복문으로 채워넣자!!
        for(int i=0;i<10;i++) {
            View view = layoutInflater.inflate(R.layout.item_board, null, false);
            container.addView(view);
        }
    }
}