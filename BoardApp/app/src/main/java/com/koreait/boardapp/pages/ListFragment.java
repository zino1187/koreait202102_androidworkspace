package com.koreait.boardapp.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.koreait.boardapp.MainActivity;
import com.koreait.boardapp.R;
import com.koreait.boardapp.list.BoardListAdapter;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

//게시물 목록을 보여줄 리스트 페이지
public class ListFragment extends Fragment {
    ListView listView;
    BoardListAdapter boardListAdapter;

    @Override
    //반환값이 View는, 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_list, container, false);//인플레이션
        listView=view.findViewById(R.id.listView);

        //리스트뷰와 어댑터 연결
        boardListAdapter = new BoardListAdapter((MainActivity) this.getActivity());
        listView.setAdapter(boardListAdapter);

        //매요청마다 사용될 쓰레드 정의

        return view;
    }

    //웹서버로부터 데이터 가져오기
    public void getList(){
        URL url=null;
        HttpURLConnection con=null;
        BufferedReader buffr=null;

        try {
            url=new URL("http://172.30.1.53:8888/rest/board");
            con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("get");

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}









