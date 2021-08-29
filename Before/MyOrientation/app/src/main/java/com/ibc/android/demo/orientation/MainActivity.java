package com.ibc.android.demo.orientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    String name;
    EditText editText;
    TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView2 = findViewById(R.id.textView2);
        Button button = findViewById(R.id.button);
        if (button != null) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (editText != null) {
                        name = editText.getText().toString();
                    }
                }
            });
        }
        if (savedInstanceState != null) {
            if (textView2 != null) {
                name =savedInstanceState.getString("aName");
                textView2.setText(name);// savedInstanceState에 aName이라는 이름을 가진 값을 textView2에 넣어줌.
            }
        }
     }
    @Override // 우클릭 generate -> override->
    protected void onSaveInstanceState(@NonNull Bundle outState) { //메인 Activity가 메모리에서 없어지는 순간에 이 함수가 호출되면서 저장됨.
        super.onSaveInstanceState(outState);
        outState.putString("aName", name);// aName이라는 이름으로  name값을 bunddle에 저장. 위의 onCreate에 Bundle과 같은것.
    }
}