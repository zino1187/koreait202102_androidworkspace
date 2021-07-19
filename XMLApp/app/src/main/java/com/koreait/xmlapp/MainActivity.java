package com.koreait.xmlapp;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class MainActivity extends AppCompatActivity {
    SAXParserFactory factory;
    SAXParser saxParser;
    MemberHandler memberHandler;
    ListView listView;
    MyAdapter myAdapter;
    AssetManager assetManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //프로그램이 가동되자 마자, 리스트뷰와 어댑터가 연결되어 있게 처리
        listView=findViewById(R.id.listView);
        myAdapter=new MyAdapter(this);
        listView.setAdapter(myAdapter); //연결!!
        assetManager =this.getResources().getAssets();
    }

    public void loadData(View view){

        factory = SAXParserFactory.newInstance();
        InputStream is=null;

        //파서 수행~~~
        try {
            saxParser = factory.newSAXParser();
            is=assetManager.open("members.xml");
            saxParser.parse(is, memberHandler = new MemberHandler()); //파싱 시작!!
            //파싱이 완료되면, list가 채워져 있을 것이고, 이  list를 MyAdapter가 보유한 list 대신에 대입하자!!
            myAdapter.list = memberHandler.list; //대체

            myAdapter.notifyDataSetChanged();//어댑터에게 데이터가 변경되었음을 알리는 메서드
            listView.invalidate();//리스트뷰 refresh
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}