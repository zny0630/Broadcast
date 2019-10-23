package edu.niit.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MyReceiver myReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myReceiver=new MyReceiver();
        IntentFilter filter=new IntentFilter();
        filter.addAction("edu.niit.android.broadcast.MY_NORMAL_BROADCAST");
        filter.addAction("edu.niit.android.broadcast.MY_ORDERED_BROADCAST");
        filter.setPriority(50);
        this.registerReceiver(myReceiver,filter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if(myReceiver!=null){
            unregisterReceiver(myReceiver);
        }
    }


}
