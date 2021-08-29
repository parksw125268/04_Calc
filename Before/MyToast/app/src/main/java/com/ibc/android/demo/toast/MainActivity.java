package com.ibc.android.demo.toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { //토스트를 바로 쓰지 않고 직접 만들어서 써보자.
                Toast toastView = Toast.makeText(MainActivity.this, "토스트 메세지입니다.",Toast.LENGTH_LONG); // .show(); 안씀
                toastView.setGravity(Gravity.TOP|Gravity.LEFT,100, 300);
                                    // 토스트 메세지를 위, 왼쪽에 붙이고, x축으로 100만큼, y축으로 300 만큼 떨어뜨려서 보이기
                toastView.show();
            }
        });

    }
}