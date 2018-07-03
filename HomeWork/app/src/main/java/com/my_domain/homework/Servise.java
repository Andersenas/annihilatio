package com.my_domain.homework;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

public class Servise extends Service {


    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e("Cheburahkin", "onBind");
        return null;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e("Cheburahkin", "onUnbind");
        return super.onUnbind(intent);
    }
}
