package fragment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.R;

public class ContainerActivity extends AppCompatActivity {
    private AFagment aFagment;
    private Button mBtnChange;
    private BFagment bFagment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        mBtnChange=findViewById(R.id.btn_change);

        mBtnChange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFagment==null)
                {
                    bFagment= new BFagment();
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,bFagment).commitNowAllowingStateLoss();
            }
        });
        aFagment=new AFagment();
        getSupportFragmentManager().beginTransaction().add(R.id.fl_container,aFagment).commitNowAllowingStateLoss();
    }
}