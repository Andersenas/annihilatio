package com.my_domain.homework;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Calendar;
import java.util.Date;

public class HW4_2 extends AppCompatActivity {

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, HW4_2.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw4_2);

        Date currentTime = Calendar.getInstance().getTime();
        Log.e("Cheburahkin", String.valueOf(currentTime));
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
