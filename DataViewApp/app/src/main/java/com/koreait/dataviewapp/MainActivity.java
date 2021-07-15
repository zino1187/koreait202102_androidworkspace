package com.koreait.dataviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout container;
    LayoutInflater layoutInflater;
    //String[] writerArray={"바바리안","배트맨","빔","데드풀","헐크","아이언맨","매그니토","스파이더맨","울버린","원더우먼"};//작성자 배열
    //이미지배열

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
        for(int i=0;i<25;i++) {
            View view = layoutInflater.inflate(R.layout.item_board, null, false);
            TextView t_writer=(TextView)view.findViewById(R.id.t_writer); //그룹형 뷰는 자식 뷰를 아이디로 접근할 수 있다
            t_writer.setText("마블히어로"+i);

            container.addView(view);
        }
    }
}