package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
        import android.annotation.SuppressLint;
        import android.content.Intent;
        import android.content.SharedPreferences;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

//登陆界面
public class aActivity extends AppCompatActivity {
    private EditText editName;
    String userEmail;
    String userPassword;
    String username;
    String userPhone;
    private EditText editPassWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //在MainActivity中初始化，第一个参数为要获取的Activity的包名
        SharedPreferences sh = getSharedPreferences("mys",MODE_PRIVATE);
        //这样就可以对第一个activity2中的在数据库中存放的用户名、手机号、邮箱和密码
        userEmail=sh.getString("email","");
        userPassword=sh.getString("password","");
        username=sh.getString("username","");
        userPhone=sh.getString("phone","");

        judge();
    }
    //初始化控件以及判断是否存在该用户的信息
    @SuppressLint("SuspiciousIndentation")
    private void judge() {
        //初始化控件
        editName = findViewById(R.id.ed1);
        editPassWord = findViewById(R.id.ed2);
        //注册
        Button button1 = findViewById(R.id.bt1);
        if(button1!=null)
        button1.setOnClickListener(new ButtonListener());


        Button button2 = findViewById(R.id.bt2);
        if(button2!=null)
        button2.setOnClickListener(new ButtonListener());
    }
    private class ButtonListener implements View.OnClickListener {
        @SuppressLint("NonConstantResourceId")
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bt1:
                    Intent intent = new Intent();
                    intent = new Intent(aActivity.this, bActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case R.id.bt2:
                    Intent intent1 = new Intent();
                    String name = editName.getText().toString();
                    String password = editPassWord.getText().toString();
                    if ((name.equals(userEmail)|| name.equals(username)|| name.equals(userPhone) )&& password.equals(userPassword)) {
                        Toast.makeText(aActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        //跳转界面，进入登陆界面

                        intent1.setClass(getApplicationContext(), cActivity.class);
                        startActivity(intent1);
                    } else {
                        Toast.makeText(aActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
            }
        }
    }
}
