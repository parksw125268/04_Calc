package com.ibc.android.demo.mytab;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //====== Actionbar에 Toolbar넣기. ================================================================
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar); //Actionbar에 Toolbar넣기.

        ActionBar actionBar =getSupportActionBar(); //위의 액션바를 가져 올 수 있음.
        actionBar.setDisplayShowTitleEnabled(false);//타이틀이 보일지 말지
        //==============================================================================================

        fragment1 = new Fragment1();
        fragment2 = new Fragment2();
        fragment3 = new Fragment3();

        //default로 fragment1이 화면에 보이도록.
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); //첫번째 fragment가 FrameLayout안에 들어가게 됨.

        //====== Actionbar 밑에 tab넣기. ================================================================
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.addTab(tabs.newTab().setText("통화기록"));//탭추가
        tabs.addTab(tabs.newTab().setText("스팸기록"));
        tabs.addTab(tabs.newTab().setText("연락처"));

        tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) { //탭버튼이 클릭됬을때
                int position = tab.getPosition();//몇번째 탭인지 나옴.
                if(position == 0){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment1).commit(); //첫번째 fragment가 FrameLayout안에 들어가게 됨.
                } else if(position == 1){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment2).commit(); //첫번째 fragment가 FrameLayout안에 들어가게 됨.
                } else if(position == 2){
                    getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment3).commit(); //첫번째 fragment가 FrameLayout안에 들어가게 됨.
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) { //탭버튼이 선택되지 않았을때

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) { //탭이 다시 선택됬을 때

            }
        });




    }
}