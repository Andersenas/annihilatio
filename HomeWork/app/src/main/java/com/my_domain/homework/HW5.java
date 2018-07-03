package com.my_domain.homework;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.AnimationDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;
import android.content.ServiceConnection;

import java.util.Objects;

public class HW5 extends AppCompatActivity {
    TextView textView;

    private AnimationDrawable mAnimationDrawable;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, HW5.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw5);
        textView = findViewById(R.id.textView3);

    }


    @Override
    protected void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(broadcastReceiver, intentFilter);

        bindService(new Intent(this, Servise.class), serviceConnection, BIND_AUTO_CREATE);

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);

        unbindService(serviceConnection);
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.e("Cheburahkin", "onServiceConnected");
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.e("Cheburahkin", "onServiceDisconnected");
        }
    };

    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ConnectivityManager connMgr = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            assert connMgr != null;
            NetworkInfo wifi = connMgr.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
            boolean isConnected = wifi != null && wifi.isConnectedOrConnecting();

            if (isConnected) {
                textView.setText("Wifi on");
                Log.e("Cheburaha", "Wifi on");
                Toast.makeText(context, "Wifi on", Toast.LENGTH_SHORT).show();
            } else {
                textView.setText("Wifi off");
                Log.e("Cheburaha", "Wifi off");
                Toast.makeText(context, "Wifi off", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
