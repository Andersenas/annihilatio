package com.my_domain.homework;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class HW1 extends AppCompatActivity {
    Button button;
    TextView textView;
    TextView textView2;
    String replace_text1;
    String replace_text2;
    ColorDrawable replace_color1;
    ColorDrawable replace_color2;
    ConstraintLayout layout;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, HW1.class);
        activity.startActivity(intent);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(HW1.this, "Круто да?)", Toast.LENGTH_SHORT).show();
            replace_text1 = button.getText().toString();
            replace_text2 = textView2.getText().toString();
            replace_color1 = (ColorDrawable) button.getBackground();
            replace_color2 = (ColorDrawable) textView2.getBackground();
            button.setText(replace_text2);
            textView2.setText(replace_text1);
            int id_col1 = replace_color1.getColor();
            int id_col2 = replace_color2.getColor();
            button.setBackgroundColor(id_col2);
            textView2.setBackgroundColor(id_col1);
        }
    };

    private View.OnClickListener clickLayout = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(HW1.this, "Жмакните на цветное!)", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hw1);
        button = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.textView);
        textView2 = (TextView)findViewById(R.id.textView2);
        layout = (ConstraintLayout)findViewById(R.id.mylayout);
        textView.setOnClickListener(clickListener);
        layout.setOnClickListener(clickLayout);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(HW1.this, "Круто да?)", Toast.LENGTH_SHORT).show();
                replace_text1 = textView.getText().toString();
                replace_text2 = textView2.getText().toString();
                replace_color1 = (ColorDrawable) textView.getBackground();
                replace_color2 = (ColorDrawable) textView2.getBackground();
                textView.setText(replace_text2);
                textView2.setText(replace_text1);
                int id_col1 = replace_color1.getColor();
                int id_col2 = replace_color2.getColor();
                textView.setBackgroundColor(id_col2);
                textView2.setBackgroundColor(id_col1);
            }
        });
    }

    public void myOnClick(View v) {
        Toast.makeText(HW1.this, "Круто да?)", Toast.LENGTH_SHORT).show();
        replace_text1 = textView.getText().toString();
        replace_text2 = button.getText().toString();
        replace_color1 = (ColorDrawable) textView.getBackground();
        replace_color2 = (ColorDrawable) button.getBackground();
        textView.setText(replace_text2);
        button.setText(replace_text1);
        int id_col1 = replace_color1.getColor();
        int id_col2 = replace_color2.getColor();
        textView.setBackgroundColor(id_col2);
        button.setBackgroundColor(id_col1);
    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
    }
}
