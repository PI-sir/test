package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Context;
        import android.content.Intent;
        import android.os.Bundle;
        import android.text.PrecomputedText;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.RadioButton;
        import android.widget.RadioGroup;
        import android.widget.Toast;

        import androidx.annotation.Nullable;

        import java.util.Map;
//注册界面
public class bActivity  extends MainActivity{

    private EditText editName;
    private EditText editPassWord;
    private EditText editConfirmPassWord;
    private EditText editPhone;
    private EditText editEmail;
    private EditText editAddress;
    private RadioGroup choice;
    private RadioButton radioButton;

    private String name;
    private String password;
    private String confirmPassword;
    private String phone;
    private String email;
    private String address;
    private SharedPreference sh;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bactivity);
        Context mContext = getApplicationContext();
        sh = new SharedPreference(mContext);
        bindViews();
    }

    private void bindViews() {
        //初始化控件
        editName = (EditText)findViewById(R.id.edit1);
        editPassWord = (EditText)findViewById(R.id.edit2);
        editConfirmPassWord = (EditText)findViewById(R.id.edit3);
        editPhone = (EditText)findViewById(R.id.edit4);
        editEmail = (EditText)findViewById(R.id.edit5);
        editAddress = (EditText)findViewById(R.id.edit6);
        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = editName.getText().toString();
                password = editPassWord.getText().toString();
                confirmPassword=editConfirmPassWord.getText().toString();
                phone=editPhone.getText().toString();
                email=editEmail.getText().toString();
                address=editAddress.getText().toString();
                //保存数据
                sh.save(name, password, confirmPassword, phone, email, address);
                //密码一致则跳转界面
                if(password.equals(confirmPassword)) {
                    Toast.makeText(bActivity.this,"注册成功，您的信息已经保存",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent();
                    intent = new Intent(bActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
        //配置RadioGroup的监听
        choice=(RadioGroup) findViewById(R.id.choice);
        choice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selected = choice.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selected);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        Map<String,String> data = sh.read();
        editName.setText(data.get("username"));
        editPassWord.setText(data.get("password"));
        editConfirmPassWord.setText(data.get("ConfirmPassword"));
        editPhone.setText(data.get("phone"));
        editEmail.setText(data.get("email"));
        editAddress.setText(data.get("address"));
    }
}
