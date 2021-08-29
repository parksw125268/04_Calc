package com.example.buttonappexcute;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button Button1 = (Button) findViewById(R.id.Button1);
        TextView textView = (TextView)findViewById(R.id.textView);
        Button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                PackageManager pkgMgr = getPackageManager();
                List<ResolveInfo> mApps;
                Intent intent1 = new Intent(Intent.ACTION_MAIN, null);
                intent1.addCategory(Intent.CATEGORY_LAUNCHER);
                mApps = pkgMgr.queryIntentActivities(intent1, 0);

                for (int i = 0; i < mApps.size(); i++) {
                    textView.setText(textView.getText()+mApps.get(i).activityInfo.loadLabel(pkgMgr).toString()+" : "+mApps.get(i).activityInfo.packageName+"\n");
                }

                Toast.makeText(getApplicationContext(),"완료",Toast.LENGTH_SHORT).show();

                /*PackageManager pkgMgr = getPackageManager();
                 Intent intent = pkgMgr.getLaunchIntentForPackage("com.android.settings");//네이버앱  페키지
                 if (intent == null){

                 }else{
                     startActivity(intent);}
                //openApp(getApplicationContext(),"org.thoughtcrime.securesms");*/


            }
        });
    }



}