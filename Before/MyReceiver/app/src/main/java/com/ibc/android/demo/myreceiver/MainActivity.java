package com.ibc.android.demo.myreceiver;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.pedro.library.AutoPermissions;
import com.pedro.library.AutoPermissionsListener;

public class MainActivity extends AppCompatActivity implements AutoPermissionsListener {//Auto~ : 위험권한 물어보기.

    @Override //generate implements
    public void onDenied(int i, String[] strings) {//stirng: 거부된 permissio들의 배열
        showToast("권한 거부된것 : "+ Integer.toString(strings.length));

    }

    @Override //generate overridemethod
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        AutoPermissions.Companion.parsePermissions(this, requestCode, permissions,this);
    }

    @Override //generate implements
    public void onGranted(int i, String[] strings) {
        showToast("권한 허가된것 : "+ Integer.toString(strings.length));

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //위험권한으로 분류된것은 얘가 다 알아서 사용자에게 요청을 하게된다.
        AutoPermissions.Companion.loadAllPermissions(this,101);// 요청할땐 대화상자가 뜨게 된다. 101 : 코드는 알아서.


    }
    private void showToast(String data){
        Toast.makeText(getApplicationContext(),data,Toast.LENGTH_LONG).show();
    }
}