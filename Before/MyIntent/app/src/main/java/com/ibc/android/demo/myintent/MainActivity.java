package com.ibc.android.demo.myintent;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
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
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MenuActivity.class);
                //startActivity(intent);
                startActivityForResult(intent,101); //화면을 띄우고 그곳으로부터 어떤 응답을 받고자 할 때
                                                                // (그게 어떤 화면인지 구부할때 유용한데 줄 그서져 잇네??)
            }
        });
    }

    @Override //menuACtivity -> MainActivity로 다시 돌아 올때 실행됨.
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 101) {
            if (data!=null){
                String name = data.getStringExtra("name");
                if(name != null){
                    Toast.makeText(this, "응답으로 받은 데이터 : "+name, Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}