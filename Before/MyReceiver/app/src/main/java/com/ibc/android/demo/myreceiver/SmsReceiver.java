package com.ibc.android.demo.myreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {
    private static final String TAG = "SmsReceiver";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
       // throw new UnsupportedOperationException("Not yet implemented");
        Log.d(TAG, "onReceive 호출됨");
        // 파라메타로 intent가 전달됨.
        Bundle bundle = intent.getExtras(); //intent의 정보가 번들(통째)로 들어온다.

        //Bundle을 파싱해줘야한다.
        SmsMessage[] messages = parseSmsMessage(bundle);

        if (messages != null && messages.length>0){
            String sender = messages[0].getOriginatingAddress(); //보내는 사람의 전화번호
            String contents = messages[0].getMessageBody(); //메세지 내용

            Log.d(TAG,"발신번호 : "+sender +", 내용 : ");

            sendToActivity(context, sender, contents);

        }

    }
    public void sendToActivity(Context context, String sender, String contents) {
        Intent intent = new Intent(context, SmsActivity.class); //이 화면을 띄워달라.
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        //맨처음 말들때는 new         // 두번째는 이미있으니 생성 no
        intent.putExtra("sender",sender);
        intent.putExtra("contents",contents);

        context.startActivity(intent);
    }


    private SmsMessage[] parseSmsMessage(Bundle bundle){
        Object[] objs = (Object[] )bundle.get("pdus"); //pdus라는 키값으로 데이터를 받아옴.
        SmsMessage[] messages = new SmsMessage[objs.length];
        int smsCount = objs.length;
        for (int i=0;i<smsCount;i++){
            // 만약 버전이 높아져서 다르게 써야한다면
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {  //SDK_INT 단말기의 OS버전 // 23이후 버전이라면 아래코드.
                String format = bundle.getString("format");
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i],format); //pdu라는 표준 프로토콜 로 데이터가 넘어온다.
            } else{ //23버전보다 낮은경우
                messages[i] = SmsMessage.createFromPdu((byte[])objs[i]); //pdu라는 표준 프로토콜로 데이터가 넘어온다.
            }
        }
        return messages;
    }
}