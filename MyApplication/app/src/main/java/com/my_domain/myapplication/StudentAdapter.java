package com.my_domain.myapplication;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{


    private ArrayList<Student> dataList;
    public StudentAdapter(ArrayList<Student> dataList) {
        this.dataList = dataList;
        notifyDataSetChanged();

    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater.from(parent.getContext()).inflate(R.layout.icon_student, false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Student student = dataList.get(position);
        Holder itemholder = (Holder)holder;
        itemholder = nameTextView.setText(student.getName());
        itemholder = nameTextView.setText(student.getSurname());
    }



    @Override
    public int getItemCount() {

        if(dataList == null) return 0;
        return dataList.size();
    }

    static class Holder extends  RecyclerView.ViewHolder{

        TextView nameTextView;
        TextView surnameTextView;

        public Holder (View itemView){
            super(itemView);

            nameTextView = itemView.findViewById(R.id.namet1);
            surnameTextView = itemView.findViewById(R.id.surnamet2);

        }
    }
}


