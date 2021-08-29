package com.ibc.android.demo.inflater;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //setContentView에서 R.layout.activity_main.xml에 있는 View(버튼 등)을
        // 메모리에 올림 (제조법 대로 실제 버튼을 만드는 것이라고 생각하면 됨. xml이 설명서. )
        // 이것을 인플레이션이라고 함.

        // 인플레이션 된 버튼이 어디 있는지 현재 이 자바 소스코드에서는 모른다.
        // 그래서 그것을 메모리에서 찾아오는것이 findViewById이다.
        Button button = findViewById(R.id.button);
        // 그래서 만약 위의 setContView(R.layout.activity_main)을 findViewById보다 밑으로 내리면
        // 아직 Button을 만들지도 않았는데 찾으려고 하니 에러가 남. 

    }
}