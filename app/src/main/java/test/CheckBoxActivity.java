package test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import com.example.helloworld.R;

public class CheckBoxActivity extends AppCompatActivity {

    private CheckBox mCb5,mCb6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        mCb5=(CheckBox) findViewById(R.id.cb_5);
        mCb6=findViewById(R.id.cb_6);
        mCb5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Toast.makeText(CheckBoxActivity.this, isChecked?"5选中":"5未选中", Toast.LENGTH_SHORT).show();
            }
        });
        mCb6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Toast.makeText(CheckBoxActivity.this, isChecked?"6.选中":"6未选中", Toast.LENGTH_SHORT).show();
            }
        });

    }
}