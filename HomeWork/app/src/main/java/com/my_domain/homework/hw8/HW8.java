package com.my_domain.homework.hw8;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.my_domain.homework.R;

public class HW8 extends AppCompatActivity {

    Button rx_first;
    Button rx_second;

    private View.OnClickListener knopka = (View v) -> {
            if (v.getId() == R.id.rx_first_but){
                RxFirstActivity.show(HW8.this);
            }else if (v.getId() == R.id.rx_second_but){
                RxSecondActivity.show(HW8.this);
            }
    };

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, HW8.class);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw8);

        rx_first = (Button)findViewById(R.id.rx_first_but);
        rx_second = (Button)findViewById(R.id.rx_second_but);

        rx_first.setOnClickListener(knopka);
        rx_second.setOnClickListener(knopka);
    }
}
