package com.ibc.android.demo.myspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;
    String[] items = {"mike","crow","john","apple","banana"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);
        Spinner spinner= findViewById(R.id.spinner);

        //Spinner도 선택 위젯이므로 adapter를 쓴다. 얘는 만들어 졌있는게 있다.(ArrayAdapter)
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(    //ArrayAdapter에 생성자 파라메터가 여러개
                this,
                android.R.layout.simple_spinner_item, //layout중에 미리 제공되는게 있는데 그중하나가 바로 이것임 // 화면에 보이는 모양을 얘기하는것
                items                                 //simple_spinner_item : 글자 하나 들어가는 spinner (워낙많이 써서 만들어져있음 TextView 하나가 들어간다. )
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);//spinner_dropdwon_item : 드랍다운되는 레이아웃. 미리 만들어져있음.

        //어뎁터를 만들었으니 시피너에 붙이자.
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() { //스피너에 아이템을 선택하면 이 이벤트가 발생됨
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                textView.setText(items[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) { //아무것도 선택 안됬을때(이미 실행시 0번을 물고있음.. 한번 선택된것은 다른것으로 바꿀순 있어도 아얘뺄순없음.)
                textView.setText("");

            }
        });
    }

}