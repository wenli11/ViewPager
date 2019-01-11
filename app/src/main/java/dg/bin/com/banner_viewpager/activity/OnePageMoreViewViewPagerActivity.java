package dg.bin.com.banner_viewpager.activity;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.banner_viewpager.R;
import dg.bin.com.banner_viewpager.adapter.OnePageMoreViewViewPagerAdapterImpl;
import dg.bin.com.banner_viewpager.adapter.OrdinaryViewPagerAdapterImpl;
import dg.bin.com.banner_viewpager.settings.ViewPagerDuration;

public class OnePageMoreViewViewPagerActivity extends ViewPagerActivity {

    List<Integer> listImg;

    ViewPager vpOnePageMoreView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_page_more_view_view_pager);

        initData();

        initView();
    }

    private void initData() {
        listImg = new ArrayList();
        listImg.add(R.drawable.aixi);
        listImg.add(R.drawable.longgui);
        listImg.add(R.drawable.wenyi);
        listImg.add(R.drawable.timo);
        listImg.add(R.drawable.fengnv);
        listImg.add(R.drawable.huangzi);
        listImg.add(R.drawable.jiqiren);
        listImg.add(R.drawable.wuqi);
        listImg.add(R.drawable.xiaopao);
        listImg.add(R.drawable.zhumei);


        listImg.add(R.drawable.timo);
        listImg.add(R.drawable.fengnv);
        listImg.add(R.drawable.huangzi);
        listImg.add(R.drawable.jiqiren);
        listImg.add(R.drawable.wuqi);
        listImg.add(R.drawable.xiaopao);
        listImg.add(R.drawable.zhumei);
        listImg.add(R.drawable.timo);
        listImg.add(R.drawable.fengnv);
        listImg.add(R.drawable.huangzi);
        listImg.add(R.drawable.jiqiren);
        listImg.add(R.drawable.wuqi);
        listImg.add(R.drawable.xiaopao);
        listImg.add(R.drawable.zhumei);
    }

    private void initView() {
        vpOnePageMoreView = findViewById(R.id.vp_onepage_moreview);
        vpOnePageMoreView.setLayoutParams(viewPagerLayoutParams());
        vpOnePageMoreView.setPageMargin(10);
        vpOnePageMoreView.setAdapter(new OnePageMoreViewViewPagerAdapterImpl(this, listImg));
        vpOnePageMoreView.setPageTransformer(true, new ViewPager.PageTransformer() {
            @Override
            public void transformPage(View page, float position) {
                /**
                 * 实现效果，一个页面显示三个view，中间的 view 为4/3，两边的 view 为2/3
                 */
                float centerPosition = 1.0f / 3;
//                if(position < -centerPosition){
//                    page.setScaleX(2*centerPosition);
//                    page.setScaleY(2*centerPosition);
//                }else if(position <= 0){
//                    //【-1/3，0】
//                    //向左滑动，【-1/3，0），正在显示的第一个 view 逐渐消失的过程，保持 view 不变
//                    //向右滑动，（-1/3，0】，左侧没有显示的 view 之间显示的过程，保持 view 不变
//                    page.setScaleX(2.0f/3);
//                    page.setScaleY(2.0f/3);
//                }else if(position <= centerPosition){
//                    //（0，1/3】
//                    //向左滑动，【0，1/3），正在显示的第二个 view 变成第一个 view 的过程，view 从 4/3 变成 2/3，代码 2*centerPosition+2*position
//                    //向右滑动，（0，1/3】，正在显示的第一个 view 变成第二个 view 的过程，view 从 2/3 变成 4/3，代码 2*centerPosition+2*position
//                    page.setScaleX(2*centerPosition+2*position);
//                    page.setScaleY(2*centerPosition+2*position);
//                }else if(position <= centerPosition*2){
//                    //（1/3，2/3】
//                    //向左滑动，【1/3，2/3），正在显示的第三个 view 变成第二个 view 的过程，view 从 2/3 变成 4/3，代码 2*centerPosition+position
//                    //向右滑动，（1/3，2/3】，正在显示的第二个 view 变成第三个 view 的过程，view 从 4/3 变成 2/3，代码 4*centerPosition-position
//                    page.setScaleX((1-position)*2);
//                    page.setScaleY((1-position)*2);
//                }else if(position <= 1){
//                    //（2/3，1】
//                    //向左滑动，【2/3，1），右侧缓存的 view 变成正在显示的第三个 view 的过程，view 保持不变
//                    //向右滑动，（2/3，1】，正在显示的第三个 view 变成右侧缓存的 view 的过程，view 保持不变
//                    page.setScaleX(2.0f/3);
//                    page.setScaleY(2.0f/3);
//                }else {
//
//                }
                Log.e(TAG, "transformPage: "+page+position );
                Log.e(TAG, "transformPage: "+1.0f/3+":"+2*centerPosition );
//                0.3472222
//                0.6944444

//                if(position == 0){
//                    page.setScaleX(centerPosition);
//                    page.setScaleY(centerPosition);
//                }else if(position == 1){
//                    page.setScaleX(centerPosition);
//                    page.setScaleY(centerPosition);
//                }else if(position == -1){
//                    page.setScaleX(centerPosition);
//                    page.setScaleY(centerPosition);
//                }

//                if (position <= 0) {
//                    page.setScaleX(1);
//                    page.setScaleY(1);
//                } else if (position <= centerPosition) {
//                    page.setScaleX(1 + (2 - 1) * position / centerPosition);
//                    page.setScaleY(1 + (2 - 1) * position / centerPosition);
//                } else if (position <= centerPosition * 2) {
//                    page.setScaleX(1 + (2 - 1) * (2 * centerPosition - position) / centerPosition);
//                    page.setScaleY(1 + (2 - 1) * (2 * centerPosition - position) / centerPosition);
//                } else {
//                    page.setScaleX(1);
//                    page.setScaleY(1);
//                }
            }
        });
        vpOnePageMoreView.setCurrentItem(5);
    }

    public void next(View view) {
        vpOnePageMoreView.setCurrentItem(10);
    }
}
