package edu.niit.broadcast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private MyReceiver myReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //发送标准广播按钮的监听事件
        Button btnNormal =findViewById(R.id.btn_normal);
        btnNormal.setOnClickListener(this);

        //发送有序广播按钮的监听事件
        Button btnOrdered =findViewById(R.id.btn_ordered);
        btnOrdered.setOnClickListener(this);

        //发送本地广播按钮的监听事件
        Button btnLocal =findViewById(R.id.btn_local);
        btnLocal.setOnClickListener(this);



        //广播接收器的动态注册
        myReceiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("edu.niit.broadcast.MY_NORMAL_BROADCAST");
        this.registerReceiver(myReceiver,filter);
    }


    @Override
    public void onClick(View v) {
        super.onDestroy();
        //注销自定义广播接收器
        switch (v.getId()){
            case R.id.btn_normal:
                Intent intent =new Intent("edu.niit.broadcast.MY_NORMAL_BROADCAST");
                intent.putExtra("info","标准广播");
                this.sendBroadcast(intent);
                break;

            case R.id.btn_ordered:
                intent =new Intent("edu.niit.broadcast.MY_ORDERED_BROADCAST");
                intent.putExtra("info","有序广播");
                this.sendBroadcast(intent,null);
                break;

            case R.id.btn_local:

                break;
        }
    }
}
