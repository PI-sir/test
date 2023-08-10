package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Test1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test1);


        TextView tv_1;
        Intent i = getIntent();

        tv_1 = findViewById(R.id.tv_1);

        tv_1.setText(i.getStringExtra("date"));

//        Intent intent=getIntent();
//        Bundle bundle=intent.getExtras();
//        String name=bundle.getString("users");
//        Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }
}