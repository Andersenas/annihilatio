package com.my_domain.homework;

import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class MyService extends Service {

    private final IBinder binder = new LocalBinder();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Cheburahkin", "onBind");
        return binder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Cheburahkin", "onUnbind");
        return super.onUnbind(intent);
    }
    public class LocalBinder extends Binder {
        MyService getService() {
            return MyService.this;
        }
    }

}
