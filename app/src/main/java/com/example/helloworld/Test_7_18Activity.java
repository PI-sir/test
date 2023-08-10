package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import dao.UserDao;
import db.AppDatabase;
import entity.User;

public class Test_7_18Activity extends AppCompatActivity {
    private EditText et_phone;
    private EditText et_password;
    private CheckBox cb_remember;
    private Button bt_login;
    private View.OnClickListener listener1 = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch ( view.getId() ) {
                case R.id.login:
                    login(); //登录
                    break;
            }
        }
    };

    //初始化
    public void init() {
        et_phone = (EditText) findViewById(R.id.phone);
        et_password = (EditText) findViewById(R.id.password);
        cb_remember = (CheckBox) findViewById(R.id.remember);
        bt_login = (Button) findViewById(R.id.login);
        bt_login.setOnClickListener(listener1);
    }
    //模拟登录
    public void login() {
        if ( cb_remember.isChecked() ) {
            rememberme(); //如果选中，将把数据保存到xml文件
        } else {
            unrememberme(); //如果取消选中，则清除xml文件数据
        }
        Log.d("flag","正在登录...");
        Toast.makeText(Test_7_18Activity.this,"开始登录...",Toast.LENGTH_SHORT).show();
        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();
        User user = userDao.findUser( phone, password );
        if ( user == null ) {
            Toast.makeText( Test_7_18Activity.this, "用户名或密码错", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText( Test_7_18Activity.this, "登录成功...", Toast.LENGTH_SHORT).show();
//startActivity…
        }



    }


    //保存数据（记住我）
    public void rememberme() {
        String phone = et_phone.getText().toString();
        String password = et_password.getText().toString();
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
        if( remember ) {
            cb_remember.setChecked(true);
            String phone = sp.getString("phone", "");
            String password = sp.getString("password", "");
            et_phone.setText(phone);
            et_password.setText(password);
            Log.d("flag", "数据读取成功");
        }
    }

    AppDatabase db; // 数据库实例
    UserDao userDao; // DAO实例
    public void initDB(){
        db = Room.databaseBuilder( getApplicationContext(), AppDatabase.class, "mydb").allowMainThreadQueries().build();
        userDao = db.userDao();
    }
    public void register(User user) {
        userDao.insert(user);
        Toast.makeText(Test_7_18Activity.this, "注册成功", Toast.LENGTH_SHORT).show();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test718);
//设置为全屏模式

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
//ActionBar显示返回按钮
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        init();
        readSP();
        initDB(); // 先初始化DB
        User user = new User();
        user.phone = "18908643860";
        user.password = "123456";
        register(user); // 注册一个测试用户

    }




    //ActionBar返回按钮的功能在onOptionsItemSelected()中触发
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case android.R.id.home:
                finish();
        }
        return super.onOptionsItemSelected(item);
    }
} //end activity

