package com.koreait.intentstudy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //SecondActivity로 데이터를 전달해보자
    public void another(View view){
        Intent intent = new Intent(this, SecondActivity.class);

        Member member = new Member(); //Parcelable 화시켜야 한다..
        member.setId("Scott");
        member.setPass("1234");
        member.setName("스캇");

        //안드로이드에서는  Intent 에 데이터를 전달시 기본자료형을 전달할수 잇음이 원칙.
        //만일 객체자료형을 전달하려면? 해당 객체를 Parcel 화 시켜야 한다..(직렬화와 비슷)
        intent.putExtra("member", member);


        startActivity(intent); //지정된 액티비티로 화면 전환!!
    }

}