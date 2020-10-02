package com.example.beginnerc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class DetailsActivity extends AppCompatActivity {
    /**
     * Do not forget to encapsulate the fields
     */
    private int image;
    private String name;
    private String desc;

    private ImageView imageDetail;
    private TextView namDetail;
    private TextView descriptionDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        initView();
        getData();
        setView();
    }

    private void initView() {
        imageDetail = findViewById(R.id.image1);
        namDetail = findViewById(R.id.name_Detail);
        descriptionDetail = findViewById(R.id.description_Detail);

    }

    private void getData() {
        Intent intent = getIntent();
        image = intent.getIntExtra("IMAGE", 0);
        name = intent.getStringExtra("NAME");
        desc = intent.getStringExtra("DESCRIPTION");
    }

    private void setView() {
        imageDetail.setImageResource(image);
        namDetail.setText(name);
        descriptionDetail.setText(desc);

    }
}