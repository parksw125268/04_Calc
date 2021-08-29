package com.ibc.android.demo.myreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class SmsActivity extends AppCompatActivity {
    TextView textView2;
    TextView textView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms);
        textView2 = findViewById(R.id.textView2); //발신번호 표시할 textview
        textView3 = findViewById(R.id.textView3);//문자내용.

        Intent intent = getIntent();
        processIntent(intent);
    }

    @Override // 현재 액티비티가 이미 떠있었다면 onCreate는 실행되지 않고 인텐트는 onNewIntent로 전달된다.
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        processIntent(intent)  ;

    }

    public void processIntent(Intent intent){
        if (intent != null){
            String sender =  intent.getStringExtra("sender");
            String contents =  intent.getStringExtra("contents");
            textView2.setText(sender);
            textView3.setText(contents);
        }
    }
}