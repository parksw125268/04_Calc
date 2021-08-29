package com.ibc.android.demo.myservice;

import android.Manifest;
import android.app.Service;
import android.content.Intent;
import android.nfc.Tag;
import android.os.IBinder;
import android.os.Parcelable;
import android.util.Log;

public class MyService extends Service {
    public static final String Tag = "MyService";

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(Tag, "onCreate 호출됨");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(Tag, "onStartCommand 호출됨");
        if (intent != null) {
            processComand(intent);
        } else {
            return Service.START_STICKY; // 자동으로 재시작.
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void processComand(Intent intent) {
        String command = intent.getStringExtra("command");
        String name = intent.getStringExtra("name");

        Log.d(Tag, "commnad : " + command + " , name : " + name);

        try {
            Thread.sleep(5000); //5초 쉬기. try catch로 감싸줘야됨.
        } catch (Exception e) {
            e.printStackTrace();
        }

        Intent showIntent = new Intent(getApplicationContext(), MainActivity.class); // 서비스에서 화면을 다시 띄우기. 다시 띄울때는  이미 존재하면  새로 만들지 않고
        // Flag를 이용해서 재활용한다. 3
        showIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | //화면이 연속적으로 보이도록?
                Intent.FLAG_ACTIVITY_SINGLE_TOP | //이미 액티비티가 존재하면 그대로 보여줘라.
                Intent.FLAG_ACTIVITY_CLEAR_TOP); //같은 액티비티가 여러개 싸여있으면 없애줘라.
        showIntent.putExtra("command","show");
        showIntent.putExtra("name",name + "from service");
        startActivity(showIntent);

    }



}