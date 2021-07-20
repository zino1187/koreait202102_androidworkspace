package com.koreait.graphicapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.koreait.graphicapp.domain.Member;
import com.koreait.graphicapp.xml.DataParser;

import java.util.List;

import javax.xml.parsers.SAXParser;

public class DataActivity extends AppCompatActivity {
    DataParser dataParser;
    String TAG=this.getClass().getName();
    SAXParser parser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        dataParser = new DataParser(this);
        List<Member> list=dataParser.getList();

        for( Member member: list){
            Log.d(TAG, member.getName()+","+member.getPhone()+","+member.getAge());
        }
    }
}