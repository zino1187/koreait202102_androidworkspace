package com.koreait.xmlapp.customnavi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.koreait.xmlapp.R;

public class CustomMain extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_main);
    }

    public void showPage(View view){
        switch (view.getId()){
            case R.id.img1:
                //웹요청 액티비티 띄우기
                ;break;
            case R.id.img2:
                //소켓채팅 액티비티 띄우기
                ;break;
            case R.id.img3:
                //고객센터 액티비티 띄우기
                ;break;
            case R.id.img4:
                //환경설정 액티비티 띄우기
                ;break;
        }
    }
}