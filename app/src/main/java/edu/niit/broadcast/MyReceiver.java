package edu.niit.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String info=intent.getStringExtra("info");
        Toast.makeText(context,"接收到的信息"+info,Toast.LENGTH_SHORT).show();

        if("有序".equals(info)){
            abortBroadcast();
        }
    }
}
