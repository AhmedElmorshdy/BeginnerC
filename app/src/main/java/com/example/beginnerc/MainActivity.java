package com.example.beginnerc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ModelAdapter.OnItemClickListener {

    /**
     * Do not forget to encapsulate the fields
     */

    private RecyclerView recyclerView;
    private ModelAdapter adapter;
    private ArrayList<Model> modelArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setRecyclerView();
    }

    private void initView() {
        recyclerView = findViewById(R.id.rv_data);
    }

    private void setRecyclerView() {

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        setData();
        adapter = new ModelAdapter(modelArrayList);
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    private void setData() {
        modelArrayList = new ArrayList<>();
        modelArrayList.add(new Model(R.drawable.image, "programming language", "there are alot of programming language suc as: Java"));
        modelArrayList.add(new Model(R.drawable.image1, "Programming Track", "there are alot of programming Track suc as: Android"));
        modelArrayList.add(new Model(R.drawable.p, "Flight", "Afunny image !"));

    }

    private void start_Activity(int position) {

        Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
        /*
         You can pass the whole model to the another activity
         by parcelable(best one) or serializable
        */
        passDataToAnotherActivity(intent, position);
        startActivity(intent);

    }

    private void passDataToAnotherActivity(Intent intent, int postion) {
        intent.putExtra("IMAGE", modelArrayList.get(postion).getImage());
        intent.putExtra("NAME", modelArrayList.get(postion).getName());
        intent.putExtra("DESCRIPTION", modelArrayList.get(postion).getDescription());
    }

    @Override
    public void OnItemClick(int position) {
        start_Activity(position);
    }
}