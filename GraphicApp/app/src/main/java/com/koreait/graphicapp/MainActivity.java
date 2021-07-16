package com.koreait.graphicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity{
    MyCanvas myCanvas;
    Thread thread; //자동 에니메이션 구현을 위한 쓰레드

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_move); // 인플레이션 + 뷰로 사용

        myCanvas = findViewById(R.id.myCanvas);
        //리니어 레이아웃에 그림을 그려보자!! 자바 SE와 마찬가지로 그래픽의 요소가 동일
        /*
        * 그래픽의 주체 : 컴포넌트 즉 뷰다!!
        * 그래픽 행위 : 컴포넌트가 가진 그리는 메서드 swing:paint(),  android:View가 onDraw()
        * 그래픽스타일: swing: Graphics ,  onDraw(?)
        * 그래픽대상 : swing:  컴포넌트, andriod:View
        * */
        thread = new Thread(){
            public void run() {
                //에니메이션 구현!!!
                while(true) {
                    move();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };

    }

    public void move(){
        //커스텀뷰의 x,y 값을 변경시키고, repaint() 메서드 명칭 틀림
        myCanvas.x+=1;
        myCanvas.y+=1;
        myCanvas.invalidate();
    }
    //xml에서 onClick 등으로 인한 호출시엔, 반드시 메서드에 View를 매개변수로 선언해야  xml에서 호출한 메서드로
    //인정해준다..
    public void manual(View view){
        Log.d("MainActivity",  "버튼 눌렀어?");
        move();
    }

    public void auto(View view){
        thread.start();
    }

}













