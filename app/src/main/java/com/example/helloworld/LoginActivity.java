package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.text.BreakIterator;

import dao.UserDao;
//import db.AppDatabase;
//import db.AppDatabase;
import entity.User;
import fragment.ContainerActivity;
import fragment.UserInterfaceActivity;

public class LoginActivity extends AppCompatActivity {

    private ImageView mIv1;
    private CheckBox mCb1;
    private EditText mEt1, mEt2;
    private Button mBtn1, mBtn2, mBtn3;
    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.btn_1:
//                    login(); //登录
                    break;
            }
        }
    };

    //初始化
    public void init() {
        mEt1 = (EditText) findViewById(R.id.et_1);
        mEt2 = (EditText) findViewById(R.id.et_2);
        mCb1 = (CheckBox) findViewById(R.id.cb_1);
        mBtn1 = (Button) findViewById(R.id.btn_1);
        mBtn1.setOnClickListener(listener1);
    }

//    public void login() {
//        if (mCb1.isChecked()) {
//            rememberme(); //如果选中，将把数据保存到xml文件
//        } else {
//            unrememberme(); //如果取消选中，则清除xml文件数据
//        }
//        Log.d("flag", "正在登录...");
//        Toast.makeText(LoginActivity.this, "开始登录...", Toast.LENGTH_SHORT).show();
//
//        String phone = mEt1.getText().toString();
//        String password = mEt2.getText().toString();
//        User user = userDao.findUser( phone, password );
//        if ( user == null ) {
//            Toast.makeText(LoginActivity.this, "用户名或密码错", Toast.LENGTH_SHORT).show();
//        } else {
//            Toast.makeText(LoginActivity.this, "登录成功...", Toast.LENGTH_SHORT).show();
////startActivity…
//        }
//    }

    //保存数据（记住我）
    public void rememberme() {
        String phone = mEt1.getText().toString();
        String password = mEt2.getText().toString();
        SharedPreferences sp = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean("rememberme", true);
        editor.putString("phone", phone);
        editor.putString("password", password);
        editor.apply();
        Log.d("flag", "数据保存成功");
    }

    //清除数据（取消记住我）
    public void unrememberme() {
        SharedPreferences sp = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.apply();
        Log.d("flag", "数据已删除");
    }

    //读取数据（如果"记住我"为true，则在程序启动时，读取手机号+密码显示在界面输入框中）
    public void readSP() {
        SharedPreferences sp = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        Boolean remember = sp.getBoolean("rememberme", false);
        if (remember) {
            mCb1.setChecked(true);
            String phone = sp.getString("phone", "");
            String password = sp.getString("password", "");
            mEt1.setText(phone);
            mEt2.setText(password);
            Log.d("flag", "数据读取成功");
        }
    }

//    AppDatabase db; // 数据库实例
//    UserDao userDao; // DAO实例
//    public void initDB(){
//        db = Room.databaseBuilder( getApplicationContext(), AppDatabase.class, "mydb").allowMainThreadQueries().build();
////        userDao = db.userDao();
////    }
//    public void register(User user) {
//        userDao.insert(user);
//        Toast.makeText(LoginActivity.this, "注册成功", Toast.LENGTH_SHORT).show();
//    }


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //设置为全屏模式
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//ActionBar显示返回按钮
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        init();
//        readSP();
//
//
//        initDB(); // 先初始化DB
//        User user = new User();
//        user.phone = "18908643860";
//        user.password = "123456";
//        register(user); // 注册一个测试用户
//


        EditText et1=findViewById(R.id.et_1);
        EditText et2=findViewById(R.id.et_2);

//        //actionBar = getSupportActionBar();
//         actionBar.setTitle("欢迎使用"); //设置标题
//        actionBar.setDisplayHomeAsUpEnabled(true);
////        mBtn3=findViewById(android.R.id.home);
//        mBtn3.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//
//            }
//        });


//        Intent itent=getIntent();
//        String keyword=itent.getStringExtra("user");
//        //if(et1==null)
//
//            et1.setText(itent.getStringExtra("user"));
//       Toast.makeText(this, keyword+"123", Toast.LENGTH_SHORT).show();

        Intent intent=getIntent();
        String str=intent.getStringExtra("data");
        Toast.makeText(this, str+"登录成功", Toast.LENGTH_SHORT).show();
        et1.setText(intent.getStringExtra("data"));
        et2.setText(intent.getStringExtra("data"));


        //https://media.9game.cn/gamebase/2021/7/23/227847310.jpg
        mIv1=findViewById(R.id.iv_1);
        Glide.with(this).load("https://img1.baidu.com/it/u=4085104212,2392694432&fm=253&fmt=auto&app=138&f=JPEG?w=500&h=889").into(mIv1);
        mBtn2=findViewById(R.id.btn_2);
        mBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);

            }
        });
//        Intent intent=getIntent();

        mBtn1=findViewById(R.id.btn_1);
        mBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1=et1.getText().toString();
                String str2=et2.getText().toString();

                if(str1.equals("pp")&&str2.equals("666"))
                {
                    Intent intent=new Intent(LoginActivity.this, UserInterfaceActivity.class);
//                            Bundle bundle=intent.getExtras();
//                             String name=bundle.getString("users");
//                    Toast.makeText(LoginActivity.this, name, Toast.LENGTH_SHORT).show();
                    intent.putExtra("data",str1);
                           startActivity(intent);
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //ActionBar返回按钮的功能在onOptionsItemSelected()中触发


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.mian_menu, menu );

    return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case android.R.id.home:
                finish();
        }
        switch ( item.getItemId() ) {
            case R.id.menu_login:
                Toast.makeText( LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
                case R.id.menu_exit:
                    finish();
            case android.R.id.home:
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);}

}