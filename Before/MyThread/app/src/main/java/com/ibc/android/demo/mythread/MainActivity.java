package com.ibc.android.demo.mythread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    Handler handler = new Handler(); //핸들러를 객체로 인스턴스화 해버림
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackgroundThread thread = new BackgroundThread();
                thread.start();//start메소드가 실행되는게 아니고 run메소드가 실행된다.
            }
        });
    }

    class BackgroundThread extends Thread {
        int value = 0;
        public void run(){
            for (int i=0;i<100;i++){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){ }
                value+=1;
                Log.d("MyThread","value : "+value);
                //textView.setText(value);
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        textView.setText("값"+value);
                    }
                });
            }
        }
    }

}