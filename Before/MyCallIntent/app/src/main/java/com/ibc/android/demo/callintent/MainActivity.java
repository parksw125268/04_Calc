package com.ibc.android.demo.callintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             //   Intent intent =  new Intent(Intent.ACTION_VIEW, Uri.parse("tel:010-8271-7530"));
             //   startActivity(intent);
                //startActivity는 직접화면을 띄우는게 아니고 시스템쪽으로 전달된다.
                // 그러면 안드로이드안에 ActivityManager라고 하는애가 이 정보(전화번호)를 받게된다.
                // 그래서 이미 단말에 설치 되어있는 전화걸기 앱이 실행 된다.

                //Intent라고 하는애는 시스템이 이해할 수 있도록 만들어진 어떤 객채다 라고 생각하면된다.
                // 화면정보 없이 그냥 전화번호만 있는데 그에 해당하는 앱을 자동으로 띄워준다.
                // 아니면 특정 화면을 지정해주면 특정 화면을 직접 띄워주기도 한다.


                Intent intent =  new Intent();
                ComponentName name = new ComponentName("com.ibc.android.demo.callintent","com.ibc.android.demo.callintent.MenuActivitiy");
                intent.setComponent(name);
                startActivityForResult(intent,101);
            }
        });
    }
}