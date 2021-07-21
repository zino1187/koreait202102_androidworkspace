package com.koreait.fragmentapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.koreait.fragmentapp.fragments.RedFragment;

public class MainActivity extends AppCompatActivity {
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프레그먼트 생성 및 뷰안에 넣기!!
        redFragment = new RedFragment();

        //기본적으로 액티비티는 프레그먼트를 사용할수 있기 때문에 메니저를 얻어오는 능력이 있다
        FragmentManager manager=this.getSupportFragmentManager();

        FragmentTransaction transaction =manager.beginTransaction();
        //화면에 프레그먼트를 등장시킬지 여부를확정지을 수 있는 객체
        transaction.add(R.id.fragment_container, redFragment);
        transaction.commit(); //확정짓기
    }

    //액션 아이템 생성
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=this.getMenuInflater();
        menuInflater.inflate(R.menu.main_navi, menu);

        return true;
    }

    //아이템 이벤트처리

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item_red:
                ;break;
            case R.id.item_yellow:
                ;break;
            case R.id.item_blue:
                ;break;
        }
        return super.onOptionsItemSelected(item);
    }
}














