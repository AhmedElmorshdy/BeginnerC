package com.example.beginnerc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ModelAdapter adapter;
    ArrayList<Model>modelArrayList;
    Intent intent;
    int postion;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRecyclerView();
        onClickedAdater();

    }
    private void initView(){
        recyclerView = findViewById(R.id.recy);
    }
    private void setRecyclerView(){

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        setData();
        adapter = new ModelAdapter(modelArrayList,this);
        recyclerView.setAdapter(adapter);

    }
    private void setData(){


        modelArrayList = new ArrayList<>();
        modelArrayList.add(new Model(R.drawable.image,"programming language","there are alot of programming language suc as: Java"));
        modelArrayList.add(new Model(R.drawable.image1,"Programming Track","there are alot of programming Track suc as: Android"));
        modelArrayList.add(new Model(R.drawable.p,"Flight","Afunny image !"));

    }
    private void start_Activity(int position){


                intent = new Intent(MainActivity.this,DetailsActivity.class);
                     passDataToAnotherActivity(position);
                     startActivity(intent);


    }
    private void passDataToAnotherActivity(int postion){

        intent.putExtra("IMAGE",modelArrayList.get(postion).getImage());
        intent.putExtra("NAME",modelArrayList.get(postion).getName());
        intent.putExtra("DESCRIPTION",modelArrayList.get(postion).getDescription());

    }
    private void onClickedAdater(){

        adapter.setOnItemClickListener(new ModelAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(int position) {
                start_Activity(position);
              passDataToAnotherActivity(position);

            }
        });
    }
}