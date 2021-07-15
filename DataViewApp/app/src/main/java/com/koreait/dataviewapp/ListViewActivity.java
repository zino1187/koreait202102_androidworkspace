package com.koreait.dataviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class ListViewActivity extends AppCompatActivity {
    HeroAdapter adapter;
    ListView listView;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = (ListView)findViewById(R.id.listView);
        adapter = new HeroAdapter(this);
        listView.setAdapter(adapter);//리스트뷰와 어댑터와 연결
    }
}




