package com.koreait.boardapp.pages;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.koreait.boardapp.MainActivity;
import com.koreait.boardapp.R;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class WriteFragment extends Fragment implements View.OnClickListener {
    String TAG=this.getClass().getName();
    Button bt_list, bt_write;
    MainActivity mainActivity;

    //반환값이 View는, 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write, container, false);//인플레이션
        //버튼과 리스너와의 연결
        bt_list = view.findViewById(R.id.bt_list);
        bt_write = view.findViewById(R.id.bt_write);
        bt_list.setOnClickListener(this);
        bt_write.setOnClickListener(this);
        mainActivity = (MainActivity) this.getActivity(); //호스트 액티비티 얻어다 놓기

        return view;
    }
    //웹서버에 등록 요청
    public void regist(){
        URL url=null;
        HttpURLConnection con=null;
        BufferedWriter buffw=null;

        try {
            url=new URL("http://192.168.55.227:8888/client/cs/board/regist");
            con=(HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");//요청 방법 지정(post, get ... )
            con.setRequestProperty("Content-Type","application/json;charset=utf-8");
            con.setDoOutput(true); //post방식은 데이터를 전송함이 목적...

            //string형으로 서버에 json문자열을 전송하자!!
            StringBuilder sb = new StringBuilder();
            sb.append("{");
            sb.append("\"title\":\"안드로이드제목\",");
            sb.append("\"writer\":\"홍길동\",");
            sb.append("\"content\":\"내용없슴\"");
            sb.append("}");

            //con객체로부터 스트림을 뽑은후, 데이터 출력
            buffw = new BufferedWriter(new OutputStreamWriter(con.getOutputStream(), "UTF-8"));
            buffw.write(sb.toString()+"\n");
            buffw.flush();

            int code=con.getResponseCode(); //서버의 응답코드 200 등등
            Log.d("WriteFragment","등록후 결과 코드"+code);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            if(buffw!=null){
                try {
                    buffw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void onClick(View v) {
        if(v.getId() ==  R.id.bt_list){
            Log.d(TAG, "목록으로 갈까요?");
            //MainActivity의 showPage(0);
            Log.d(TAG, "현재 이 프레그먼트의 주인 액티비티는 "+this.getActivity());
            mainActivity.showPage(0);
        }else if(v.getId() == R.id.bt_write){
            Log.d(TAG, "등록할까요?");
        }
    }

}
