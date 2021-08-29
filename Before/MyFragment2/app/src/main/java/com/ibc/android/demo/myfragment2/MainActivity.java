package com.ibc.android.demo.myfragment2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements ImageSelectionCallback{
    ListFragmnet listFragmnet;
    ViewerFragment viewerFragment;
    int[] images = {R.drawable.dream1 , R.drawable.dream2  , R.drawable.dream3};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = getSupportFragmentManager();
        listFragmnet = (ListFragmnet) manager.findFragmentById(R.id.listFragment);
        viewerFragment = (ViewerFragment ) manager.findFragmentById(R.id.viewFragment);
    }

    @Override
    public void onImageSelected(int position) {
        viewerFragment.setImage(images[position]);

    }
}