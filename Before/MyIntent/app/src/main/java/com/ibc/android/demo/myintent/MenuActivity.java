package com.ibc.android.demo.myintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                       //엑스트라 : 주인공아닌 친구 .... 부가 정보. 가는김에 가져가라... 데이터...
                intent.putExtra("name", "mike");//name이라는 key값으로 mike라는 데이터를 저장.

                setResult(RESULT_OK,intent);
              //  setResult(200,intent); // 200: 응답코드. 다시 메인으로 돌아갈 때 메인에 200이라는 코드가 전달됨.

                finish(); // 안드로이드는 Intent해서 새로 Activity를 생성하면 기존 Activity는 밑에 깔려있다.
                         // finish() 하게되면 현재 Activity가 사라지는데 이전에 밑에 깔려잇는 MainActivity가 보이게 된다.
            }
        });
    }
}