package com.my_domain.homework.hw6;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.my_domain.homework.R;

public class GalleryActivity extends AppCompatActivity {

    private static final String TAG = "GalleryActivity";
    MenuItem button_save;
    MenuItem button_edit;
    EditText data_edit;
    TextView data_show;
    String str_data;
    String imageUrl;
    String position;
    Boolean delete = false;



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.edit_menu, menu);
        button_save = menu.findItem(R.id.main_menu_save);
        button_edit = menu.findItem(R.id.main_menu_edit);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_edit:
                button_edit.setVisible(false);
                button_save.setVisible(true);
                data_show.setVisibility(View.INVISIBLE);
                data_edit.setVisibility(View.VISIBLE);

                break;
            case R.id.main_menu_save:
                button_edit.setVisible(true);
                button_save.setVisible(false);
                data_show.setVisibility(View.VISIBLE);
                data_edit.setVisibility(View.INVISIBLE);
                data_show.setText(str_data);
                changeData(delete);
                break;
            case R.id.main_menu_delete:
                delete = true;
                changeData(delete);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        data_edit = (EditText) findViewById(R.id.image_description_edit);

        getIncomingIntent();

    }

    private void changeData(Boolean delete){
        Intent intent = new Intent(this, HomeWork6.class);
        intent.putExtra("new_data", data_edit.getText().toString());
        intent.putExtra("position", position);
        intent.putExtra("delete", delete);
        data_show.setText(data_edit.getText().toString());
        this.startActivity(intent);
    }

    private void getIncomingIntent(){

        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("position")  && getIntent().hasExtra("position")){

            imageUrl = getIntent().getStringExtra("image_url");
            str_data = getIntent().getStringExtra("image_name");
            position = getIntent().getStringExtra("position");
            setImage(imageUrl, str_data);
        }
    }


    private void setImage(String imageUrl, String str_data){

        data_show = findViewById(R.id.image_description);
        data_show.setText(str_data);
        data_edit.setText(str_data);

        ImageView image = findViewById(R.id.image);
        Glide.with(this)
                .asBitmap()
                .load(imageUrl)
                .into(image);
    }

}