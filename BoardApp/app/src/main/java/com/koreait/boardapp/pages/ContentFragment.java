package com.koreait.boardapp.pages;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.koreait.boardapp.R;

public class WriteFragment extends Fragment {
    @Override
    //반환값이 View는, 현재의 프레그먼트에서 보여줄 뷰를 의미
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_write, container, false);//인플레이션

        return view;
    }
}
