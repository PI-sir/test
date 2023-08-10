package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class TestActivity extends AppCompatActivity {

    private Button mBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        EditText et1=findViewById(R.id.et_1);
//        Intent intent=new Intent(TestActivity.this,Test1Activity.class);
//        Bundle bundle=intent.getExtras();
//        String name=bundle.getString("users");
//        startActivity(intent);
        String str="123";
        mBtn1=findViewById(R.id.btn_1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TestActivity.this,Test1Activity.class);
                intent.putExtra("date",str);
                startActivity(intent);
            }
        });

    }
}