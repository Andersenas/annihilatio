package com.my_domain.homework;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.my_domain.homework.hw4.DiagrammeActivity;
import com.my_domain.homework.hw6.HomeWork6;
import com.my_domain.homework.hw8.HW8;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button7;
    Button button8;
    Button button9;
    Button button10;


    private View.OnClickListener knopka = (View v) -> {

            if (v.getId() == R.id.button){
                HW1.show(MainActivity.this);
            }else if (v.getId() == R.id.button2){
                HW2.show(MainActivity.this);
            }else if (v.getId() == R.id.button3){
                HW3.show(MainActivity.this);
            } else if (v.getId() == R.id.button4){
                HW4.show(MainActivity.this);
            } else if (v.getId() == R.id.button5){
                HW5.show(MainActivity.this);
            } else if (v.getId() == R.id.button7){
                HW4_2.show(MainActivity.this);
            } else if (v.getId() == R.id.button8){
                HomeWork6.show(MainActivity.this);
            } else if (v.getId() == R.id.button9){
                DiagrammeActivity.show(MainActivity.this);
            } else if (v.getId() == R.id.button10){
                HW8.show(MainActivity.this);
            }
            overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);
        button5 = (Button)findViewById(R.id.button5);
        button7 = (Button)findViewById(R.id.button7);
        button8 = (Button)findViewById(R.id.button8);
        button9 = (Button)findViewById(R.id.button9);
        button10 = (Button)findViewById(R.id.button10);


        button1.setOnClickListener(knopka);
        button2.setOnClickListener(knopka);
        button3.setOnClickListener(knopka);
        button4.setOnClickListener(knopka);
        button5.setOnClickListener(knopka);
        button7.setOnClickListener(knopka);
        button8.setOnClickListener(knopka);
        button9.setOnClickListener(knopka);
        button10.setOnClickListener(knopka);


        Log.e("Chebur", "onCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("Chebur", "onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("Chebur", "onStart");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("Chebur", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("Chebur", "onStop");
    }
}
