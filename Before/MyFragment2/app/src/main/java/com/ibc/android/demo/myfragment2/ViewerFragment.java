package com.ibc.android.demo.myfragment2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ViewerFragment extends Fragment {
    ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       // return super.onCreateView(inflater, container, savedInstanceState);
        ViewGroup rootView = (ViewGroup)  inflater.inflate(R.layout.fragment_viewer,container,false);
        imageView = rootView.findViewById(R.id.imageView);
        return rootView;
    }
    public void setImage(int resId){  // resId : 이미지 index
        imageView.setImageResource((resId));
    }
}
