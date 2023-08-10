package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SharedPreferencesActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;

    private SharedPreferences sharedPreferences;

    // 文件名
    private String fileName = "my_file";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        textView = (TextView) findViewById(R.id.tv);
        editText = (EditText) findViewById(R.id.et);

        // 初始化SharedPreferences
        // MODE_APPEND：添加新数据时，不会覆盖旧数据，新旧数据共存
        // MODE_PRIVATE：以私有形式存储数据，新数据覆盖旧数据（多数情况使用该模式）
        sharedPreferences = getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    public void WriteSharedPreferences(View view) {
        String content = editText.getText().toString();
        // 第一步，获取编辑者对象
        SharedPreferences.Editor editor = sharedPreferences.edit();
        // 第二步，使用编辑者对象对数据进行编辑操作（写数据，改数据，删数据）
        editor.putString("content", content);
        // 第三步，提交编辑内容
        boolean isCommitSuccessful = editor.commit();
        //editor.apply();
/*这两个方法的区别在于：
1. apply没有返回值而commit返回boolean表明修改是否提交成功
2. apply是将修改数据原子提交到内存, 而后异步真正提交到硬件磁盘, 而commit是同步的提交到硬件磁盘，因此，在多个并发的提交commit的时候，他们会等待正在处理的commit保存到磁盘后在操作，从而降低了效率。而apply只是原子的提交到内容，后面有调用apply的函数的将会直接覆盖前面的内存数据，这样从一定程度上提高了很多效率。
3. apply方法不会提示任何失败的提示。
由于在一个进程中，sharedPreference是单实例，一般不会出现并发冲突，如果对提交的结果不关心的话，建议使用apply，当然需要确保提交成功且有后续操作的话，还是需要用commit的。*/
        Toast.makeText( SharedPreferencesActivity.this, "数据是否保存成功：" + isCommitSuccessful, Toast.LENGTH_SHORT).show();
    }

    public void ReadSharedPreferences(View view) {
        String content = sharedPreferences.getString("content", "default");
      //  default是默认数据,如果文件里没有数据你偏管人家要,就给你默认的.
                textView.setText(content);
    }

}