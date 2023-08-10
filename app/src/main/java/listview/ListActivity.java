package listview;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import androidx.annotation.Nullable;

import com.example.helloworld.R;

public class ListActivity extends Activity {
     private ListView mLv1;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview);
        mLv1=findViewById(R.id.lv_1);
        //mLv1.setAdapter();
    }
}
