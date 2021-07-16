package com.koreait.dataviewapp;


import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//View 인 ListView에게 데이터에 대한 정보를 제공해주는 어댑터
//swing 에서의 TableModel과 그 역할이 같다!!
public class HeroAdapter extends BaseAdapter {
    LayoutInflater layoutInflater=null; //Activity를 통해 얻어야 한다..
    Context context;
    //보여질 데이터 준비 (추후 이 데이터는 공공데이터 포털이나, 우리의 웹서버로부터 가져올예정)
    String[] writerArray={"바바리안","배트맨","빔","데드풀","헐크","아이언맨","매그니토","스파이더맨","울버린","원더우먼"};//작성자 배열
    int[] drawables={
            R.drawable.babarian,
            R.drawable.batman,
            R.drawable.beam,
            R.drawable.deadpool,
            R.drawable.hulk,
            R.drawable.iron,
            R.drawable.magni,
            R.drawable.spider,
            R.drawable.wolf,
            R.drawable.woman
    };
    Resources res;

    //생성자에서 Activity를 이용하자!!
    public HeroAdapter(Context context) {
        this.context=context;
        Activity ac=(Activity)context;
        layoutInflater = ac.getLayoutInflater();
        res=context.getResources();
    }

    //총 아이템 갯수 반환
    public int getCount() {
        //Log.d("HeroAdapter", "총 데이터 갯수는 "+writerArray.length);
        return writerArray.length;
    }

    //지정한 위치의 아이템 반환
    public Object getItem(int position) {
        return null;
    }

    //각 아이템에 부여된 아이디 반환
    public long getItemId(int position) {
        return 0;
    }

    //swing의 TableModel 에서의 getValueAt() 과 역할
    public View getView(int position, View convertView, ViewGroup parent) {

        //대체될 뷰가 없다면 즉 convertView가  null이라면 생성하고, null이 아니라면 기존의 뷰를 재사용하자!!
        View view=null;
        if(convertView==null){
            //아이템으로 사용할 뷰를 반환하자!!(우리의 경우 item_board 의 인플레이션 결과물...)
            view=layoutInflater.inflate(R.layout.item_board, null, false);
        }else{
            view=convertView;
        }
        Log.d("HeroAdapter", "view:"+view+",convertView:"+convertView);

        ImageView img=(ImageView)view.findViewById(R.id.img);
        TextView t_writer = (TextView)view.findViewById(R.id.t_writer);
        //이미지는 drawable에 있으므로, drawable안의 리소스를 접근할수 있어야 한다..
        Drawable d=res.getDrawable(drawables[position]);
        img.setImageDrawable(d);
        t_writer.setText(writerArray[position]);

        return view;
    }
}
