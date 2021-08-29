package com.ibc.android.demo.myview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;

public class MyButton extends AppCompatButton {

    //context : 버튼이 있다면 버튼주변에 환경에 대한 정보를 담고있는.
    public MyButton(@NonNull Context context) { //자바파일에서 new로 인스턴스를 생성할때.
        super(context);
        init(context);
    }

    public MyButton(@NonNull Context context, @Nullable AttributeSet attrs) { //attrs : xml에서 <Button... /> 으로 생성할때
        super(context, attrs);
        init(context);                                            //거기있는 속성들이 넘어온다.
    }

    void init(Context context){
        setBackgroundColor(Color.CYAN);
        setTextColor(Color.BLACK);

        //TextSize px 말고 sp 단위로 지정해주기.
        float textSize=getResources().getDimension(R.dimen.text_size); //30sp라고 하는단위가 단말에 맞게pixel로 변환되서 들어옴.
        setTextSize(textSize);
    }

    @Override
    protected void onDraw(Canvas canvas) { //무언가를 그려줄 때
        super.onDraw(canvas);
        Log.d("MyButton","onDraw 호출됨");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) { //터치했을때
        Log.d("MyButton","onTouch 호출됨");
        int action = event.getAction();
        switch (action){
            case MotionEvent.ACTION_DOWN: //눌림.
                setBackgroundColor(Color.BLUE);
                setTextColor(Color.RED);
                break;
            case MotionEvent.ACTION_OUTSIDE:
            case MotionEvent.ACTION_CANCEL:
            case MotionEvent.ACTION_UP:
                setBackgroundColor(Color.CYAN);
                setTextColor(Color.BLACK);
                break;

        }
        invalidate(); //화면에 버튼을 다시 그려준다. 그리고 이때 위의 onDraw 이벤트가 발생한다.
        return true;
    }
    //View를 상속할 때 재정의 할 수 있는  함수들이 있다.
    //그 함수들은 어떤 상황이 되면 자동으로호출된다.
    //그중에 중요한 것이 온래저라는게 있따. 온래저는 이 버트의 크기를 결정해 준다.
    //온레저에서 사이즈를 리턴하면 그 지정해준 사이즈로 보인다.
}
