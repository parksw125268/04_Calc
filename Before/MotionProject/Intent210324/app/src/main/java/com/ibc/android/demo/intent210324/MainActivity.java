package com.ibc.android.demo.intent210324;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn1 = (Button)findViewById(R.id.btn1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);
                i.putExtra("year",2021);
                i.putExtra("month",3);
                i.putExtra("day",24);
                i.putExtra("weekday","토요일");

                Person p = new Person();
                p.name = "고길동";
                p.age = 43;
                p.sex = true;
                i.putExtra("person",p);

                startActivity(i);
            }
        });
    }
}
class Person implements Serializable{
    String name;
    int age;
    boolean sex;
}