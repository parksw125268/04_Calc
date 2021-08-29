package com.ibc.android.demo.mylayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class Layout1 extends LinearLayout {
    ImageView imageView;
    TextView textView;
    TextView textView2;
    public Layout1(Context context) {
        super(context);

        init(context);
    }

    public Layout1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    public void init(Context context){
        // xml과 이 java소스파일을 열결해줘야한다. -> 그것이 바로 인플레이션 작업.
        LayoutInflater inflater =(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.layout1, this, true);// true는 즉시 바로.
        //==== 지금 위의 작업으로 실제로 메모리에 xml파일과 그위의View들이 만들어졌다.

        imageView=findViewById(R.id.imageView);
        textView=findViewById(R.id.textView);
        textView2=findViewById(R.id.textView2);
    }
    public void setImage(int resId){
        imageView.setImageResource(resId);// drawble 밑에있는 이미지로 변경할 수 있따.
    }

    public void setName(String name){
        textView.setText(name);
    }

    public void setMobile(String mobile){
        textView2.setText(mobile);
    }

}

