package com.my_domain.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Student> studentsList = new ArrayList<>();
        studentsList.add(new Student("Vasya", "Petrov"));
        studentsList.add(new Student("Vasiliy", "Petrov"));
        studentsList.add(new Student("Vasyas", "Petrov"));
        studentsList.add(new Student("Vasyan", "Petrov"));
        studentsList.add(new Student("Vaska", "Petrov"));
        studentsList.add(new Student("Vaskin", "Petrov"));
        studentsList.add(new Student("Vas", "Petrov"));

        StudentAdapter studentAdapter = new StudentAdapter();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(studentAdapter);


    }
}
