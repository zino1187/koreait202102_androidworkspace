package com.koreait.boardapp.list;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.koreait.boardapp.MainActivity;
import com.koreait.boardapp.R;

//ListView 가 보여줄 게시물 목록에 대한 정보를 제공하는 어댑터
public class BoardListAdapter extends BaseAdapter {
    MainActivity mainActivity;
    LayoutInflater layoutInflater;

    public BoardListAdapter(MainActivity mainActivity) {
        this.mainActivity=mainActivity;
        layoutInflater=mainActivity.getLayoutInflater();
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //getCount만큼 호출하면서 각 아이템 자리에 들어갈 View를 반환해주자!! 하지만
        //이 뷰들이 xml로 구성되어 잇으므로, 인플레이션이 필요하다..
        View view=null;

        if(convertView==null) {
            view = layoutInflater.inflate(R.layout.item_board, null, false); //새로운 뷰 생성
        }else{
           view=convertView; //기존 뷰로 대체
        }

        return view;
    }
}
