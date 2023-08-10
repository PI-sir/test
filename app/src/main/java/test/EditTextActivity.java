package test;

import androidx.appcompat.app.AppCompatActivity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.helloworld.R;

public class EditTextActivity extends AppCompatActivity {

    private Button mBtLogin;
    private EditText mEtUserName;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
       mBtLogin=findViewById(R.id.btn_login);
       mBtLogin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Toast.makeText(EditTextActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
           }
       });
       mEtUserName=findViewById(R.id.et_1);
       mEtUserName.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {

               Log.d("edittext",s.toString());
           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });


    }
}