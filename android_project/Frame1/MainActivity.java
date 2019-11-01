package com.mobile.frame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textView1;
    TextView textView2;
    TextView textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button)findViewById(R.id.button1);
        Button button2 = (Button)findViewById(R.id.button2);
        Button button3 = (Button)findViewById(R.id.button3);


        FrameLayout frame = (FrameLayout)findViewById(R.id.frame);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);


        button1.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                changeView(0);

            }
        });


    }
    private void changeView(int index) {
        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frame);
        frameLayout.removeViewAt(0);

        switch(index){
            case 0:
                frameLayout.addView(textView1);
                break;
            case 1:
                frameLayout.addView(textView2);
                break;
            case 2:
                frameLayout.addView(textView3);
                break;
        }

    }

}
