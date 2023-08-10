package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import test.CheckBoxActivity;
import test.ImageViewActivity;
import test.TextViewActivity;

public class MainActivity extends AppCompatActivity {
    private Button mBtnTextView;
    private Button mBtnButton;
    private Button mBtnEditText;
    private Button mBtnRadioButton;
    private Button mBtnExample;
    private Button mBtnTime;
    private Button mBtCheckBox;
    private Button mBtnImageView;
    private Button mBtnMy,mBtnWork,mBtnTest,mBtnBigTest,mBtnFragment,mBtnExample1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnTextView = findViewById(R.id.btn_textview);
        mBtnTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, InternetActivity.class);
                startActivity(intent);
            }
        });

//        mBtnTextView = (Button) findViewById(R.id.btn_edittext);
//        mBtnTextView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,TextViewActivity.class);
//                  startActivity(intent);
//            }
//        });
//        mBtnRadioButton=findViewById(R.id.btn_radiobutton);
//        mBtnRadioButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,RadioButtonActivity.class);
//                startActivity(intent);
//            }
//        });
//        mBtnExample=findViewById(R.id.btn_example);
//        mBtnExample.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(MainActivity.this,ExampleActivity.class);
//                startActivity(intent);
//            }
//        });
        mBtnTime=findViewById(R.id.btn_time);
        mBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TimeActivity.class);
                startActivity(intent);
            }
        });
        mBtCheckBox=findViewById(R.id.btn_checkbox);
        mBtCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, CheckBoxActivity.class);
                startActivity(intent);
            }
        });
        mBtnImageView=findViewById(R.id.btn_imageview);
        mBtnImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, ImageViewActivity.class);
                startActivity(intent);
            }
        });
        mBtnMy=findViewById(R.id.btn_myactivity);
        mBtnMy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,MyActivity.class);
                startActivity(intent);
            }
        });
        mBtnWork=findViewById(R.id.btn_work);
        mBtnWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnTest=findViewById(R.id.btn_test);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,TestActivity.class);
                startActivity(intent);
            }
        });
        mBtnBigTest=findViewById(R.id.btn_test);
        mBtnBigTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        mBtnFragment=findViewById(R.id.btn_fragment);
        mBtnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, Test_7_18Activity.class);
                startActivity(intent);
            }
        });
        mBtnExample1=findViewById(R.id.btn_example);
        mBtnExample1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,SharedPreferencesActivity.class);
                startActivity(intent);
            }
        });
    }
    //下面招网上打的出错
//    private void setListeners(){
//
//        OnClick onClick=new OnClick();
//        mBtnTextView.setOnClickListener(onClick);
//        mBtnRadioButton.setOnClickListener(onClick);
//        mBtnButton.setOnClickListener(onClick);
//        mBtnEditText.setOnClickListener(onClick);
//    }
//    private class OnClick implements View.OnClickListener{
//
//        @Override
//        public void onClick(View v) {
//            Intent intent = null;
//            switch (v.getId()){
//                case R.id.btn_textview:
//                    intent = new Intent(MainActivity.this, TextViewActivity.class);
//                    break;
//                case R.id.btn_button:
//                    intent = new Intent(MainActivity.this, ButtonActivity.class);
//                    break;
//                case R.id.btn_edittext:
//                    intent = new Intent(MainActivity.this, EditTextActivity.class);
//                    break;
//                case R.id.btn_radiobutton:
//                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
//                    break;
//            }
//            startActivity(intent);
//        }
//    }
}