package dg.bin.com.banner_viewpager.activity;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.banner_viewpager.R;
import dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl;
import dg.bin.com.banner_viewpager.settings.ViewPagerDuration;

import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.ALL;
import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.LEFT;
import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.RIGHT;

public class AutomaticCirculationViewPagerActivity extends ViewPagerActivity {

    List<Integer> listImg;

    ViewPager vpAutomaticCirculation;

    CirculationViewPagerAdapterImpl mAdapter;

    int mDelayTime = 1000;

    Handler mHandler = new Handler();

    Runnable mRunable = new Runnable() {
        @Override
        public void run() {
            int currentItem = vpAutomaticCirculation.getCurrentItem();
            if(mAdapter.mCirculationDirection == LEFT){
                if(currentItem < mAdapter.getCount() - 1){
                    vpAutomaticCirculation.setCurrentItem(currentItem + 1);
                    mHandler.postDelayed(mRunable, mDelayTime);
                }
            }else if(mAdapter.mCirculationDirection == RIGHT){
                if(currentItem > 0){
                    vpAutomaticCirculation.setCurrentItem(currentItem - 1);
                    mHandler.postDelayed(mRunable, mDelayTime);
                }
            }else if(mAdapter.mCirculationDirection == ALL){
                //设置向右滑动循环
//                if(currentItem > 0){
//                    vpAutomaticCirculation.setCurrentItem(currentItem - 1);
//                    mHandler.postDelayed(mRunable, mDelayTime);
//                }

                //设置向左滑动循环
                if(currentItem < mAdapter.getCount() - 1){
                    vpAutomaticCirculation.setCurrentItem(currentItem + 1);
                    mHandler.postDelayed(mRunable, mDelayTime);
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_automatic_circulation_view_pager);

        initData();

        initView();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mHandler.postDelayed(mRunable, mDelayTime);
    }

    @Override
    protected void onStop() {
        mHandler.removeCallbacks(mRunable);
        super.onStop();
    }

    private void initData() {
        listImg = new ArrayList();
        listImg.add(R.drawable.aixi);
        listImg.add(R.drawable.longgui);
        listImg.add(R.drawable.wenyi);
        listImg.add(R.drawable.timo);
    }

    private void initView() {
        vpAutomaticCirculation = findViewById(R.id.vp_automatic_circulation);
        vpAutomaticCirculation.setLayoutParams(viewPagerLayoutParams());
        //向左滑动可以无限循环
//        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, LEFT);
        //向右滑动可以无限循环
//        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, RIGHT);
        //向左向右滑动都可以无限循环
        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, ALL);
        vpAutomaticCirculation.setAdapter(mAdapter);
        vpAutomaticCirculation.setCurrentItem(1);


        vpAutomaticCirculation.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int currentItem = vpAutomaticCirculation.getCurrentItem();
                if(state == 0){
                    if(currentItem == 0){
                        if(mAdapter.mCirculationDirection == RIGHT){
                            vpAutomaticCirculation.setCurrentItem(mAdapter.getCount() - 1, false);
                        }else if(mAdapter.mCirculationDirection == ALL){
                            vpAutomaticCirculation.setCurrentItem(mAdapter.getCount() - 2, false);
                        }
                    }else if(currentItem == mAdapter.getCount() - 1){
                        if(mAdapter.mCirculationDirection == LEFT){
                            vpAutomaticCirculation.setCurrentItem(0, false);
                        }else if(mAdapter.mCirculationDirection == ALL){
                            vpAutomaticCirculation.setCurrentItem(1, false);
                        }
                    }
                }
            }
        });
    }
}
