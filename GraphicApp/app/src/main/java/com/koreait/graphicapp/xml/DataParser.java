package com.koreait.graphicapp.xml;

import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

import com.koreait.graphicapp.domain.Member;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class DataParser {
    AssetManager assetManager;
    String TAG=this.getClass().getName();

    public DataParser(Context context) {
        assetManager = context.getAssets();

    }

    public List getList(){

        XmlPullParserFactory factory = null;
        XmlPullParser parser=null;
        InputStream is=null;
        boolean isName=false;
        boolean isPhone=false;
        boolean isAge=false;
        ArrayList<Member> list=null;
        Member member=null;

        try {
            is=assetManager.open("data.xml");
            factory = XmlPullParserFactory.newInstance();
            parser = factory.newPullParser();
            parser.setInput(is, "UTF-8");

            while(true){
                int eventType=parser.getEventType();
                String tag=parser.getName();

                if(eventType==XmlPullParser.END_DOCUMENT){
                    break;
                }

                if(eventType==XmlPullParser.START_TAG){
                    if(tag.equals("members")){
                        list = new ArrayList<Member>();
                    }else if(tag.equals("member")){
                        member = new Member();
                    }else if(tag.equals("name")){
                        isName=true;
                    }else if(tag.equals("phone")){
                        isPhone=true;
                    }else if(tag.equals("age")){
                        isAge=true;
                    }
                }else if(eventType==XmlPullParser.TEXT){
                    String text = parser.getText();

                    if(isName && tag!=null){
                        member.setName(text);
                    }else if(isPhone&& tag!=null){
                        member.setPhone(text);
                    }else if(isAge&& tag!=null){
                        member.setAge(Integer.parseInt(text));
                    }
                }else if(eventType==XmlPullParser.END_TAG){
                     if(tag.equals("name")){
                        isName=false;
                    }else if(tag.equals("name")){
                        isPhone=false;
                    }else if(tag.equals("phone")){
                        isAge=false;
                    }else if(tag.equals("member")){
                        list.add(member);
                    }
                }
                parser.next();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        }finally {
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return list;
    }
}
