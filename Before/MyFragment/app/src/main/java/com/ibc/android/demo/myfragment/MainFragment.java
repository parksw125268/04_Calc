package com.ibc.android.demo.myfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class MainFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       //return inflater.inflate(R.layout.fragment_main, container, false); // 수정하고 맨밑에서 다시  return

        //인플레이션으로서 xml레이아웃을 메모리에 올려주는 과정.
        ViewGroup rootView = (ViewGroup)inflater.inflate(R.layout.fragment_main, container, false);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //여기서 MenuFragment를 실행하려고 하는데 직접하지 않고 액티비티에게 위임해서 액티비티에 구현된 메소드를 쓴다.
                MainActivity activity = (MainActivity)getActivity();
                //0을넣으면 메인프래그멑느, 1을 넣으면 메뉴프래그먼트를 띄우는 기능. 이건 메인액티비티에 구현할거임.
                activity.onFragmentChanged(1);
            }
        });
        return rootView;
    }
}