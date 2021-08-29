package com.ibc.android.demo.mysliding;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    LinearLayout page ;
    Animation translateLeftAnim;
    Animation translateRightAnim;
    Button button;
    boolean isPageOpen = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        page = findViewById(R.id.page);
        translateLeftAnim = AnimationUtils.loadAnimation(this,R.anim.translate_left);
        translateRightAnim = AnimationUtils.loadAnimation(this,R.anim.translate_right);

        SlidingAnimationListener animListener = new SlidingAnimationListener();
        translateLeftAnim.setAnimationListener(animListener);
        translateRightAnim.setAnimationListener(animListener);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPageOpen){
                    page.startAnimation(translateRightAnim);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateLeftAnim); //오른쪽에서 왼쪽으로 튀어나옴.
                }
            }
        });

    }
    class SlidingAnimationListener implements Animation.AnimationListener{ //implements method...
        @Override
        public void onAnimationStart(Animation animation) {//애니메이션 시작되는시점

        }

        @Override
        public void onAnimationEnd(Animation animation) {//애니메이션 끝나는시점
            if (isPageOpen){ //페이지 열림
                page.setVisibility(View.INVISIBLE);
                button.setText("열기");
                isPageOpen = false;
            }else { //페이지 닫침.

                button.setText("닫기");
                isPageOpen = true;

            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {//애니메이션 반복되는 시점.

        }
    }
}