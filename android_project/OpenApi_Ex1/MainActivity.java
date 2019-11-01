package com.mobile.openapi_ex1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {
    EditText editText = null;
    TextView textView = null;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = (TextView)findViewById(R.id.textView);
        editText = (EditText)findViewById(R.id.editText);
    }

    public void buttonClicked(View v) {

        switch( v.getId()) {
            case R.id.button:
                //  쓰레드를 생성하여 돌리는 구간
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        data = getData(); //  하단의 getData  메소드를 통해 데이터를
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                textView.setText(data);
                            }
                        });

                    }
                }).start();
                break;
        }
    }


    String getData(){

        StringBuffer buffer = new StringBuffer();


        String str =  editText.getText().toString();
        //String str="전력로";

        String location = URLEncoder.encode(str);

        System.out.println(location);

        String queryUrl="http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?"
                +"addr="+location
                +"&pageNo=1&numOfRows=1000&ServiceKey=Unh%2FyUg8meuasWDz4ppIZmJuBq5C7JthVDIk%2BYzKO4FWawwo3ljZ%2FObyZGUB9HvzUue%2FHeiTtpeE5XtUsfYZYg%3D%3D";
        //String queryUrl= "http://openapi.kepco.co.kr/service/EvInfoServiceV2/getEvSearchList?addr=%EC%A0%84%EB%A0%A5%EB%A1%9C&pageNo=1&numOfRows=10&ServiceKey=37FrLbpDFWXc10fObIANnaC3YJ7gmTU41nQrmXuaptS8LUzd3prOnEZhzYnhbb4iBfmNAf4k5ux%2FkcqbrH1XpQ%3D%3D";


        try {

            URL url= new URL(queryUrl); // 문자열로 된 요청 url을 URL 객체로 생성.

            InputStream is= url.openStream(); // url 위치로 인풋스트림 연결

            XmlPullParserFactory factory= XmlPullParserFactory.newInstance();

            XmlPullParser xpp= factory.newPullParser();

            // inputstream 으로부터 xml 입력받기

            xpp.setInput( new InputStreamReader(is, "UTF-8") );

            String tag;

            xpp.next();

            int eventType= xpp.getEventType();

            while( eventType != XmlPullParser.END_DOCUMENT ){

                switch( eventType ){

                    case XmlPullParser.START_DOCUMENT:

                        buffer.append("파싱 시작 단계 \n\n");

                        break;

                    case XmlPullParser.START_TAG:

                        tag= xpp.getName(); // 태그 이름 얻어오기

                        if(tag.equals("item")) ;

                        else if(tag.equals("addr")){

                            buffer.append("주소 : ");

                            xpp.next();

                            // addr 요소의 TEXT 읽어와서 문자열버퍼에 추가

                            buffer.append(xpp.getText());

                            buffer.append("\n"); // 줄바꿈 문자 추가

                        }

                        else if(tag.equals("chargeTp")){

                            buffer.append("충전소타입 : ");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("cpId")){

                            buffer.append("충전소ID :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("cpNm")){

                            buffer.append("충전기 명칭 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("cpStat")){

                            buffer.append("충전기 상태 코드 :");

                            xpp.next();

                            buffer.append(xpp.getText());//

                            buffer.append("\n");

                        }

                        else if(tag.equals("cpTp")){

                            buffer.append("충전 방식 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("  ,  ");

                        }

                        else if(tag.equals("csId")){

                            buffer.append("충전소 ID :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("cpNm")){

                            buffer.append("충전소 명칭 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("lat")){

                            buffer.append("위도 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("longi")){

                            buffer.append("경도 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        else if(tag.equals("statUpdateDatetime")){

                            buffer.append("충전기상태갱신시각 :");

                            xpp.next();

                            buffer.append(xpp.getText());

                            buffer.append("\n");

                        }

                        break;

                    case XmlPullParser.TEXT:

                        break;

                    case XmlPullParser.END_TAG:

                        tag= xpp.getName(); // 태그 이름 얻어오기

                        if(tag.equals("item")) buffer.append("\n"); // 첫번째 검색결과종료 후 줄바꿈

                        break;

                }

                eventType= xpp.next();

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        buffer.append("파싱 종료 단계 \n");

        return buffer.toString(); // 파싱 다 종료 후 StringBuffer 문자열 객체 반환

    }
}