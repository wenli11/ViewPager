package dg.bin.com.banner_viewpager.activity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.banner_viewpager.R;
import dg.bin.com.banner_viewpager.adapter.OrdinaryViewPagerAdapterImpl;

public class OrdinaryViewPagerActivity extends ViewPagerActivity {

    List<Integer> listImg;

    ViewPager vpOrdinary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary_view_pager);

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
        vpOrdinary = findViewById(R.id.vp_ordinary);
        vpOrdinary.setLayoutParams(viewPagerLayoutParams());
        vpOrdinary.setAdapter(new OrdinaryViewPagerAdapterImpl(this, listImg));
    }
}
