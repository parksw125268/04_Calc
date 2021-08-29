package com.ibc.android.demo.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {
    LinearLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        container = findViewById(R.id.container); //
        Button button2 = findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addLayout(); // 레이아웃을 직접 inflator 해줄거임.
            }
        });
    }
    public void addLayout(){
        //Service라는것은 뒤에서 동작하는것. getSystemService는 앱이 실행되는 동안 뒤에서 동작 하는것
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                        //new가 아니라 이미 동작하고 있는것을 참조 하겠다는 뜻.
        inflater.inflate(R.layout.sub1, container, true);// True : 인플레이션 한다음에 바로 붙여라.

        Toast.makeText(this,"부분화면이 추가되엇습니다. ", Toast.LENGTH_LONG).show();

    }

}