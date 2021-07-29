package com.koreait.constraintapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
    String TAG=this.getClass().getName();
    ImageView imgView;
    static final int STORAGE_REQUEST=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lottie);
        imgView=findViewById(R.id.imgView);

        //createInternal();//내부 저장소에 메모장 파일 만들기!!
        //readInternal();

        //checkPermission();
        //readExternal();
        //readExternal();
    }

    //권한 요청 팝업에 대한 사용자의 선택결과를 받는 메서드!
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        //개발자가 요청한 사항에 대한 응답인지를 확인한다..(requestCode)
        if(requestCode==STORAGE_REQUEST){
            //유저가 권한 cancel하지 않았다면 grantResults는 0보다 크다!
            if(grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){ //권한의 수락
                readExternal();
                Log.d(TAG, "권한이 있으니 이미지 불러올께요");
            }
        }
    }

    //사용자에게 권한을 허락받기 위한 메서드 정의
    private void checkPermission(){
        //승인을 받은 사람인지 아닌지부터 판단...
        int result=ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);
        Log.d(TAG, "외부저장소 읽기 권한 보유 여부"+result);

        if(result != PackageManager.PERMISSION_GRANTED){ //권한이 없는 경우라면...(1.최최앱가동 2.일부러 거절)
            if(ActivityCompat.shouldShowRequestPermissionRationale(this,Manifest.permission.READ_EXTERNAL_STORAGE)){
                //일부러 거부할 경우인지 판단하는 메서드
                Toast.makeText(this,"외부저장소에 대한 권한을 수락하셔야 앱을 이용하실 수 있습니다.", Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_REQUEST);
            }else{
                //권한을 수락할 것을 요청해보자
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_REQUEST);
            }
        }
    }

    //내부저장소에 동적으로 메모장 파일 생성해보기
    public void createInternal(){
        //내부저장소를 접근하기 위해서는 openFileInput(읽기), openFileOuput(쓰기) 메서드를 이용할 수 있다
        BufferedWriter buffw=null;

        try {
            FileOutputStream fos=this.openFileOutput("memo.txt", Context.MODE_PRIVATE);
            buffw = new BufferedWriter(new OutputStreamWriter(fos));
            buffw.write("this is my memo text\n");
            buffw.write("using output stream\n");
            buffw.flush();
            Log.d(TAG, "내부저장소에 파일 만들고 내용을 작성했습니다");
        } catch (FileNotFoundException e) {
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

    //내부스토리지에 존재하는 메모장 파일을 읽어서 출력해보자!
    public void readInternal(){
        BufferedReader buffr=null;

        try {
            FileInputStream fis=this.openFileInput("memo.txt");
            buffr = new BufferedReader(new InputStreamReader(fis));

            String data=null;
            StringBuilder sb = new StringBuilder();

            while(true){
                data = buffr.readLine();
                if(data==null)break;
                sb.append(data);
            }
            //최종 결과 출력
            Log.d(TAG, sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(buffr!=null){
                try {
                    buffr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //외부저장소의 이미지 접근하여 화면에 출력하기
    public void readExternal(){
        String state=Environment.getExternalStorageState();
        Log.d(TAG, "외부저장소의 마운트 상태는 "+state);

        if(state.equals(Environment.MEDIA_MOUNTED)){//장치가 연결되어 있다면...
            //storage/emulated/0 를 접근하는 전용메서드가 따로 있다...
            File extDir=Environment.getExternalStorageDirectory();
            Log.d(TAG, "현재 폰의 외부저장소의 위치는 "+extDir);

            File file=new File(extDir+"/Pictures", "hulk.png");

            Log.d(TAG, "사진 디렉토리에 들어간 사진의 풀경로는 "+file.getAbsolutePath());

            InputStream is=null;
            try {
                is=new FileInputStream(file);//파일만 있다면 스트림 만드는건 누워떡먹기
                Bitmap bitmap= BitmapFactory.decodeStream(is);
                imgView.setImageBitmap(bitmap);
                Log.d(TAG, "이미지 불러오기 성공");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                Log.d(TAG, "이미지 불러오기 실패");
            }finally{
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
}







