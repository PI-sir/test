package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterSuccessActivity extends AppCompatActivity {

    private Button mBtn1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_success);
        Intent intent=getIntent();
        String str=intent.getStringExtra("data");

        Toast.makeText(this, str+"登录成功", Toast.LENGTH_SHORT).show();
//        TextView tv_1;
//        tv_1=findViewById(R.id.tv_1);
//        tv_1.setText(intent.getStringExtra("data")+"欢迎回来");
        ActionBar actionBar = getSupportActionBar(); //获取ActionBar
        actionBar.setTitle(str+"欢迎回来"); //设置标题
        actionBar.setDisplayHomeAsUpEnabled(true);

        //setActionBar(intent.getStringExtra("data")+"欢迎回来");
        
//        mBtn1=findViewById(R.id.btn_1);
//        mBtn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(RegisterSuccessActivity.this,LoginActivity.class);
//                startActivity(intent);
//            }
//        });
//        Intent intent=getIntent();
//        Bundle bundle=intent.getExtras();
//        String name=bundle.getString("users");

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.mian_menu, menu );


        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.menu_login:
                Toast.makeText( RegisterSuccessActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                finish();
            case android.R.id.home:
                Intent intent=new Intent(RegisterSuccessActivity.this,LoginActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);}
}