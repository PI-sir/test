package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeActivity extends AppCompatActivity {
    private TextView timeET,mTv_2;
    private Button mBtnTime;
    private TextView mTv_1,mTv_3,mTv_5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        mBtnTime=findViewById(R.id.btn_1);
        mBtnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(TimeActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });


        timeET=findViewById( R.id.timeET );
        mTv_3=findViewById(R.id.tv_3);
        mTv_1=findViewById(R.id.tv_1);



        int n=1;
//        Handler handler = new Handler();
//        handler.postDelayed(new Runnable() { @Override public void run() { //你要做的事情
//
//
//             } }, 1);//间隔时间
        Handler mHandler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                //要做的事情
                SimpleDateFormat sdf = new SimpleDateFormat("YYYY/MM/dd");
                SimpleDateFormat time1=new SimpleDateFormat("HH:mm");
                SimpleDateFormat time2=new SimpleDateFormat("ss");
                Date date = new Date();
                String currentTime = sdf.format(date);
                String currentTime1 = time1.format(date);
                String currentTime2 = time2.format(date);

                timeET.setText(currentTime);
                mTv_3.setText(currentTime2);
                mTv_1.setText(currentTime1);
                mHandler.postDelayed(this, 1000);
            }
        };
        mHandler.postDelayed(runnable, 1000);//每三秒执行一次runnable.

   //     String a,b,c,d,e,f;
        //       a=currentTime.substring(0,4);
//        b=currentTime.substring(6,8);
//        c=currentTime.substring(9,11);
//        d=currentTime.substring(12,14);
//        e=currentTime.substring(15,17);
//        f=currentTime.substring(18,20);

//        System.out.println(a);TextView mTv_1=findViewById(R.id.tv_1);
//        mTv_3=findViewById(R.id.tv_3);
//        mTv_5=findViewById(R.id.tv_5);
//        a="4";
//        mTv_1.setText(a);





    }
}