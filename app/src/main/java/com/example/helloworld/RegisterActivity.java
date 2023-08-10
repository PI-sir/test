package com.example.helloworld;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;


public class RegisterActivity extends AppCompatActivity {

    private Button mBtnRegister,mBtnreturn;
    private ImageView mIv_1,mIv_2;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        EditText et1 = (EditText) findViewById(R.id.et_1);
        String str1=et1.getText().toString();

        ActionBar actionBar = getSupportActionBar(); //获取ActionBar
        actionBar.setTitle("欢迎使用"); //设置标题
        actionBar.setDisplayHomeAsUpEnabled(true);



        // context表示当前所在活动，例如MainActivity.this
// url表示图片资源网址或本地资源R.drawable.icon等
// apply应用圆形变换方法
// image表示布局中的ImageView控件
//        context = RegisterActivity.this;
//        url = "https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fimg.jj20.com%2Fup%2Fallimg%2F4k%2Fs%2F02%2F2109242332225H9-0-lp.jpg&refer=http%3A%2F%2Fimg.jj20.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1652004122&t=70e3b52d14b9bf1bb2d795b7e1d32bf5"
//        image = (ImageView) findViewById(R.id.image);




        mIv_2=findViewById(R.id.iv_2);
          Glide.with(this).load("https://tse1-mm.cn.bing.net/th/id/OIP-C.2XCU13etgcehnehH5rnqzgHaQC?pid=ImgDet&rs=1").into(mIv_2);
        mIv_1=findViewById(R.id.iv_1);
        //Glide.with(this).load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fci.xiaohongshu.com%2F40a4d378-bd37-fdb6-82c3-cf418fce7a26%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fci.xiaohongshu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686277474&t=f7adf4fba4c55f4935ffbdd3a15df491").into(mIv_1);
        Glide.with(this)
                .load("https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fci.xiaohongshu.com%2F40a4d378-bd37-fdb6-82c3-cf418fce7a26%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fci.xiaohongshu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686277474&t=f7adf4fba4c55f4935ffbdd3a15df491")
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(mIv_1);


        //https://gimg2.baidu.com/image_search/src=http%3A%2F%2Fci.xiaohongshu.com%2F40a4d378-bd37-fdb6-82c3-cf418fce7a26%3FimageView2%2F2%2Fw%2F1080%2Fformat%2Fjpg&refer=http%3A%2F%2Fci.xiaohongshu.com&app=2002&size=f9999,10000&q=a80&n=0&g=0n&fmt=auto?sec=1686277474&t=f7adf4fba4c55f4935ffbdd3a15df491
//        mBtnreturn=findViewById(R.id.btn_2);
//        mBtnreturn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
//                intent.putExtra("user",str1);
//
//                startActivity(intent);
//            }

//        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
//        Bundle bundle = new Bundle();
//        bundle.putString("user",str);
//        intent.putExtras(bundle);
        //startActivity(intent);
        mBtnRegister=findViewById(R.id.btn_1);
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                String str=et1.getText().toString();
                //intent.putExtra("user",str);
//                        Bundle bundle = new Bundle();
//                        bundle.putString("user",str);
//                        intent.putExtras(bundle);

                intent.putExtra("data",str);

                Toast.makeText(RegisterActivity.this, str+"注册成功", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
//        Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate( R.menu.mian_menu, menu );

        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case R.id.menu_login:
                Toast.makeText( RegisterActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menu_exit:
                finish();
            case android.R.id.home:
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);}
}



