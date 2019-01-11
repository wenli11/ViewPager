package dg.bin.com.banner_viewpager.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

public class ViewPagerActivity extends AppCompatActivity {

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    public void setContentView() {
//        setContentView(R.layout.activity_main);
//    }

    private int getWidth(){
        return getResources().getDisplayMetrics().widthPixels;
    }

//    public int getHeight(){
//        return getResources().getDisplayMetrics().heightPixels;
//    }

    /**
     * 根据图片大小设置 viewpager 的 LayoutParams
     * 图片大小为 1024*567
     * @return viewpager 要设置的布局
     */
    LinearLayout.LayoutParams viewPagerLayoutParams(){
        return new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, getWidth()*567/1024);
    }

}
