package com.my_domain.homework;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    Button button3;
    Button button4;


    private View.OnClickListener knopka = new View.OnClickListener(){
        @Override
        public void onClick(View v){
            if (v.getId() == R.id.button){
                HW1.show(MainActivity.this);
            }else if (v.getId() == R.id.button2){
                HW2.show(MainActivity.this);
            }else if (v.getId() == R.id.button3){
                HW3.show(MainActivity.this);
            } else if (v.getId() == R.id.button4){
                HW3.show(MainActivity.this);
            }
//            Intent intent = new Intent(MainActivity.this, HW2.class);
//            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = (Button)findViewById(R.id.button);
        button2 = (Button)findViewById(R.id.button2);
        button3 = (Button)findViewById(R.id.button3);
        button4 = (Button)findViewById(R.id.button4);

        button1.setOnClickListener(knopka);
        button2.setOnClickListener(knopka);
        button3.setOnClickListener(knopka);
        button4.setOnClickListener(knopka);

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
