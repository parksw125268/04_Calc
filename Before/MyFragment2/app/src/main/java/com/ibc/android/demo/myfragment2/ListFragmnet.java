package com.ibc.android.demo.myfragment2;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragmnet extends Fragment {
    ImageSelectionCallback callback;
    @Override
    public void onAttach(@NonNull Context context) { //프래그먼트거 액티비티에 붙을때 실행 됨.
        super.onAttach(context);
        if (context instanceof ImageSelectionCallback){
            callback = (ImageSelectionCallback)context; // 실제로는 메인 액티비티가 열로 넘어옴.
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView =  (ViewGroup)inflater.inflate(R.layout.fragment_list,container,false); //xml파일과 java를 연결해주는 부분.
        Button button  =  rootView.findViewById(R.id.button);
        Button button2  =  rootView.findViewById(R.id.button2);
        Button button3 =  rootView.findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback !=null){
                    callback.onImageSelected(0);
                }
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback !=null){
                    callback.onImageSelected(1);
                }

            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback !=null){
                    callback.onImageSelected(2);
                }

            }
        });
        return  rootView;
    }
}
