package com.ibc.android.demo.intent210324;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i  =  getIntent();
        int year  = i.getIntExtra("year",0);
        int month = i.getIntExtra("month",0);
        int day   = i.getIntExtra("day",0);
        String strWeekDay = i.getStringExtra("weekday");

        Person p = (Person)i.getSerializableExtra("person");
        TextView tv =(TextView)findViewById(R.id.textView2);
        tv.setText("Intent 로 받은 값 : " + year + "년 " + month + "월 " + day + "일 " + strWeekDay);

        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn3 = (Button)findViewById(R.id.btn3);

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i2 = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(i2);

            }
        });
    }
}