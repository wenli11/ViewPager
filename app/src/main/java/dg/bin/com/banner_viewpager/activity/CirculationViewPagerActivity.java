package dg.bin.com.banner_viewpager.activity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.banner_viewpager.R;
import dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl;

import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.ALL;
import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.LEFT;
import static dg.bin.com.banner_viewpager.adapter.CirculationViewPagerAdapterImpl.RIGHT;

public class CirculationViewPagerActivity extends ViewPagerActivity {

    List<Integer> listImg;

    ViewPager vpCirculation;

    CirculationViewPagerAdapterImpl mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circulation_view_pager);

        initData();

        initView();
    }

    private void initData() {
        listImg = new ArrayList();
        listImg.add(R.drawable.aixi);
        listImg.add(R.drawable.longgui);
        listImg.add(R.drawable.wenyi);
        listImg.add(R.drawable.timo);
    }

    private void initView() {
        vpCirculation = findViewById(R.id.vp_circulation);
        vpCirculation.setLayoutParams(viewPagerLayoutParams());
        //向左可以无限循环
//        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, LEFT);
        //向右可以无限循环
//        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, RIGHT);
        //向左向右都可以无限循环
        mAdapter = new CirculationViewPagerAdapterImpl(this, listImg, ALL);
        vpCirculation.setAdapter(mAdapter);
        vpCirculation.setCurrentItem(1);


        vpCirculation.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                int currentItem = vpCirculation.getCurrentItem();
                if(state == 0){
                    if(currentItem == 0){
                        if(mAdapter.mCirculationDirection == LEFT){
                            vpCirculation.setCurrentItem(mAdapter.getCount() - 1, false);
                        }else if(mAdapter.mCirculationDirection == ALL){
                            vpCirculation.setCurrentItem(mAdapter.getCount() - 2, false);
                        }
                    }else if(currentItem == mAdapter.getCount() - 1){
                        if(mAdapter.mCirculationDirection == RIGHT){
                            vpCirculation.setCurrentItem(0, false);
                        }else if(mAdapter.mCirculationDirection == ALL){
                            vpCirculation.setCurrentItem(1, false);
                        }
                    }
                }
            }
        });
    }
}
