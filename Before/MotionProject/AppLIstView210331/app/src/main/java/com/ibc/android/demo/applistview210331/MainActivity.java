package com.ibc.android.demo.applistview210331;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView ListView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView1  = (ListView)findViewById(R.id.ListView1);

        ArrayList<String> data = new ArrayList<>();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,data);
        ListView1.setAdapter(adapter);

        PackageManager pkgMgr = getPackageManager();
        List<ResolveInfo> mApps;
        Intent intent1 = new Intent(Intent.ACTION_MAIN, null);
        intent1.addCategory(Intent.CATEGORY_LAUNCHER);
        mApps = pkgMgr.queryIntentActivities(intent1, 0);

        for (int i = 0; i < mApps.size(); i++) {
            //textView.setText(textView.getText()+mApps.get(i).activityInfo.loadLabel(pkgMgr).toString()+" : "+mApps.get(i).activityInfo.packageName+"\n");
            //mApps.get(i).activityInfo.loadIcon()
            data.add(mApps.get(i).activityInfo.loadLabel(pkgMgr).toString()+" : "+mApps.get(i).activityInfo.packageName);
        }

        ListView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(),data.get(position),Toast.LENGTH_SHORT).show();
            }
        });





    }
}