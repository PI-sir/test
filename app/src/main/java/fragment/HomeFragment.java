package fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.example.helloworld.R;

public class HomeFragment extends Fragment {
    private TextView mTvTitle;
    private ImageView mIv_1;
    private ImageView mIv_2;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home,container,false);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //mIv_1= getView().findViewById(R.id.iv_1);

       // Glide.with(this).load("https://tse1-mm.cn.bing.net/th/id/OIP-C.2XCU13etgcehnehH5rnqzgHaQC?pid=ImgDet&rs=1").into(mIv_2);
    }

}
