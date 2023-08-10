package test;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.helloworld.R;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView mIv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        mIv2 = (ImageView) findViewById(R.id.iv_2);


        Glide.with(this).load("https://media.9game.cn/gamebase/2021/7/23/227847310.jpg").into(mIv2);
    }
}
//https://pic3.zhimg.com/80/v2-5c26b3495268041643d2f551ff4e6602_720w.webp
//https://pic3.zhimg.com/80/v2-5c26b3495268041643d2f551ff4e6602_720w.webp
//https://ts1.cn.mm.bing.net/th/id/R-C.b6fefbed4d0491dc0f9e309aaa36183d?rik=ZDQDogoxzOo5Rg&riu=http%3a%2f%2fimg.hanmaidj.com%2fupload%2f202108%2f30%2f30172651f0ae1NI2qPi3oK1glty.jpg&ehk=kktB70GfdfDF7RB1iY6ZeuNhTrkPK0F83tMLPgYmaM8%3d&risl=&pid=ImgRaw&r=0