package com.ibc.android.demo.myfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public class MenuFragment extends Fragment {
    @Override  //얘가 xml을 메모리에 올려주고 여기와 연결해 주는 부분.
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_menu, container, false);
        //xml파일을 container라는 view그룹안에 넣어달라 // false : 바로 넣지 않는다. 대충그런갑다 해라.
    }
}