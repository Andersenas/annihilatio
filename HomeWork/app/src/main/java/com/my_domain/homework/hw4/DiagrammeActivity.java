package com.my_domain.homework.hw4;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.my_domain.homework.R;

public class DiagrammeActivity extends AppCompatActivity {
    private CircleDiagram diagramme;
    private EditText a;
    private EditText b;
    private EditText c;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, DiagrammeActivity.class);
        activity.startActivity(intent);
    }

    private View.OnClickListener showDiagramme = (View v) -> {
        try {
            diagramme.setData(a.getText(), b.getText(), c.getText());
        }catch (NumberFormatException e) {
            Toast.makeText(this, "Values are empty.", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diagramme);
        Button showDiagramme = findViewById(R.id.buttonDiagramme);
        diagramme = findViewById(R.id.viewDiagramme);
        a = findViewById(R.id.EditTextA);
        b = findViewById(R.id.EditTextB);
        c = findViewById(R.id.EditTextC);
        showDiagramme.setOnClickListener(this.showDiagramme);
    }
}
