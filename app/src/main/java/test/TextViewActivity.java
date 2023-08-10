package test;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.helloworld.R;

public class TextViewActivity extends AppCompatActivity {
    private TextView mTv4,mTv5,mTv6;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        mTv4 = (TextView) findViewById(R.id.tv_4);
        mTv4.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        mTv4.getPaint().setAntiAlias(true);
        mTv5 = (TextView)findViewById(R.id.tv_5);
        mTv5.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        mTv6 =findViewById(R.id.tv_6);
        mTv6.setText(Html.fromHtml("<u>az</u>"));

    }
}