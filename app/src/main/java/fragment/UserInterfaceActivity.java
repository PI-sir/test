package fragment;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.helloworld.LoginActivity;
import com.example.helloworld.R;
import com.example.helloworld.RegisterActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragment.HomeFragment;
import fragment.MusicFragment;
import fragment.NoteFragment;

public class UserInterfaceActivity extends AppCompatActivity {
    private HomeFragment homeFragment;
    private MusicFragment musicFragment;
    private NoteFragment noteFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_interface);
        homeFragment=new HomeFragment();
        musicFragment=new MusicFragment();
        noteFragment=new NoteFragment();
         ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("欢迎使用"); //设置标题
        actionBar.setDisplayHomeAsUpEnabled(true);

        final TextView tv_whichItemSelected = (TextView) findViewById(R.id.tv_whichItemSelected);
        BottomNavigationView bnv_001 = (BottomNavigationView) findViewById(R.id.nav_view);
        //为底部导航设置条目选中监听
        bnv_001.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.navigation_item1:
                        tv_whichItemSelected.setText(item.getTitle());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,musicFragment).commitNowAllowingStateLoss();
                        break;
                    case R.id.navigation_item2:
                        tv_whichItemSelected.setText(item.getTitle());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,noteFragment).commitNowAllowingStateLoss();
                        break;
                    case R.id.navigation_item3:
                        tv_whichItemSelected.setText(item.getTitle());
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl_container,homeFragment).commitNowAllowingStateLoss();
                        break;
                }

                return true;    //这里返回true，表示事件已经被处理。如果返回false，为了达到条目选中效果，还需要下面的代码
                // item.setChecked(true);  不论点击了哪一个，都手动设置为选中状态true（该控件并没有默认实现)
                // 。如果不设置，只有第一个menu展示的时候是选中状态，其他的即便被点击选中了，图标和文字也不会做任何更改

            }
        });


        //默认选中底部导航栏中的第三个
        bnv_001.getMenu().getItem(2).setChecked(true);
    }
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch ( item.getItemId() ) {
            case android.R.id.home:
                Intent intent=new Intent(UserInterfaceActivity.this, LoginActivity.class);
                startActivity(intent);

        }
        return super.onOptionsItemSelected(item);}
}

