package com.my_domain.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;

public class HomeWork6 extends AppCompatActivity {

    private static final String TAG = "HomeWork6";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.main_menu_add:
                NewElementActivity.show(HomeWork6.this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_work6);
        Log.d(TAG, "onCreate: started.");

        initImageBitmaps();

        getData();
    }

    private void getData(){
        if(getIntent().hasExtra("new_data") && getIntent().hasExtra("position") && getIntent().hasExtra("delete")){
            String str_data = getIntent().getStringExtra("new_data");
            String position = getIntent().getStringExtra("position");
            Boolean delete = getIntent().getBooleanExtra("delete", true);
            if (delete) {
                mImageUrls.remove(position);
                mNames.remove(position);
            } else {
                mNames.set( Integer.parseInt(position), str_data );
            }

        } else if(getIntent().hasExtra("url_image") && getIntent().hasExtra("name") && getIntent().hasExtra("create")){
            String urlImage = getIntent().getStringExtra("url_image");
            String names = getIntent().getStringExtra("name");
            mImageUrls.add(urlImage);
            mNames.add(names);

        }
    }


    private void initImageBitmaps(){


            mImageUrls.add("https://s16815.pcdn.co/wp-content/uploads/2017/06/iStock-609683672-studying.jpg");
            mNames.add("Olga Petrova");
            //

            mImageUrls.add("https://www.nssi.com/media/wysiwyg/images/2.jpg");
            mNames.add("Egor Zonozov");

            mImageUrls.add("https://www1.bournemouth.ac.uk/sites/default/files/assets/images/chinese-students-female.jpg");
            mNames.add("Mariya Sinicina");

            mImageUrls.add("http://onthehub.com/wp-content/uploads/product-course-ncss10.jpg");
            mNames.add("Mariya Starikova");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG, "initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
