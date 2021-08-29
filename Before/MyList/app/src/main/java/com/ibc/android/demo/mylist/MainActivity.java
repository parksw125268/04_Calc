package com.ibc.android.demo.mylist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.security.identity.PersonalizationData;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    PersonAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        //리사이클러 뷰는 리스트모양, 그리드모양 두가지로 보여줄 수 있다. 리스트로 설정해보자
       ///LinearLayoutManager layoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        GridLayoutManager layoutManager = new GridLayoutManager(this,2);//2는 칼럼이 2개 .
        recyclerView.setLayoutManager(layoutManager);

        adapter  = new PersonAdapter();
        adapter.addItem(new Person("김민수","010-1000-1000"));
        adapter.addItem(new Person("김민수1","010-1000-1001"));
        adapter.addItem(new Person("김민수2","010-1000-1002"));
        adapter.addItem(new Person("김민수3","010-1000-1003"));
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(new OnPersonItemClickListener() {
            @Override
            public void onItemClick(PersonAdapter.ViewHolder holder, View view, int position) {
                Person item = adapter.getItem(position);
                showToast("아이템 선택됨 : "+item.getName());
            }
        });
    }
    public void showToast(String data){
        Toast.makeText(getApplicationContext(), data, Toast.LENGTH_SHORT).show();
    }
}