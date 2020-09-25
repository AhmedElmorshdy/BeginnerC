package com.example.beginnerc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    int image;
    String name;
    String desc;

    ImageView imageDetail;
    TextView namDetail;
    TextView descriptionDetail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        getData();
        setView();
    }

    private void initView(){
        imageDetail = findViewById(R.id.image1);
        namDetail = findViewById(R.id.name_Detail);
        descriptionDetail = findViewById(R.id.description_Detail);

    }
    private void getData(){
        Intent intent = getIntent();
        image= intent.getIntExtra("IMAGE",0);
        name = intent.getStringExtra("NAME");
        desc = intent.getStringExtra("DESCRIPTION");
    }
    private void setView(){
        imageDetail.setImageResource(image);

        namDetail.setText(name);

        descriptionDetail.setText(desc);

    }
}