package com.my_domain.recyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class NewElementActivity extends AppCompatActivity {

    EditText url_image;
    EditText data_edit;

    public static void show(Activity activity) {
        Intent intent = new Intent(activity, NewElementActivity.class);
        activity.startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.create_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.create_student:

                createData();

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_element);
        url_image = (EditText) findViewById(R.id.image_url);
        data_edit = (EditText) findViewById(R.id.name_create_student);

    }

    private void createData(){

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("url_image", url_image.getText().toString());
        intent.putExtra("name", data_edit.getText().toString());
        intent.putExtra("create", true);
        this.startActivity(intent);

    }
}
