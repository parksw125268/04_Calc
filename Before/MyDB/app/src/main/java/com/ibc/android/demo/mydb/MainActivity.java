package com.ibc.android.demo.mydb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.os.Bundle;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textView;

    GestureDetector detector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.textView);

        View view = findViewById(R.id.view);
        view.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();

                float curX = event.getX();
                float curY = event.getY();

                if (action == MotionEvent.ACTION_DOWN){
                    println("손가락 눌림 : " + curX + ","+curY);
                }else if (action == MotionEvent.ACTION_MOVE){
                    println("손가락 움직임 : "+curX+","+curY);
                }else if (action == MotionEvent.ACTION_UP){
                    println("손가락 뗌 : "+curX+","+curY);
                }
                return true;
            }
        });

        detector = new GestureDetector(this, new GestureDetector.OnGestureListener() {
            @Override
            public boolean onDown(MotionEvent e) {
                println("onDown 호출됨");
                return true;
            }

            @Override
            public void onShowPress(MotionEvent e) {
                println("onShowPress 호출됨");
            }

            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                println("onSingleTapUp 호출됨");
                return true;
            }

            @Override
            public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
                println("onScroll 호출됨");
                return false;
            }

            @Override
            public void onLongPress(MotionEvent e) {
                println("onLongPress 호출됨");

            }

            @Override
            public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
                println("onFling 호출됨 : "+velocityX+","+velocityY);
                return true;
            }
        });

        View view2 = findViewById(R.id.view2);
        view2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                detector.onTouchEvent(event); //위의 제스처 이벤트로 위임.
                return true;
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            println("시스템 [back] 버튼이 눌렸어용");
            return true;
        }
        return false;

    }

    public void println(String data) {
        textView.append(data + "\n");

    }
}