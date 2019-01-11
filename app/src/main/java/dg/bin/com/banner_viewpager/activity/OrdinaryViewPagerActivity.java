package dg.bin.com.banner_viewpager.activity;

import android.support.v4.view.ViewPager;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import dg.bin.com.banner_viewpager.R;
import dg.bin.com.banner_viewpager.adapter.OrdinaryViewPagerAdapterImpl;
import dg.bin.com.banner_viewpager.settings.pagetransformer.PageTransformerAnalysis;

public class OrdinaryViewPagerActivity extends ViewPagerActivity {

    private List<Integer> listImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordinary_view_pager);

        initData();

        initView();
    }

    private void initData() {
        listImg = new ArrayList<>();
        listImg.add(R.mipmap.aixi);
        listImg.add(R.mipmap.longgui);
        listImg.add(R.mipmap.wenyi);
        listImg.add(R.mipmap.timo);
    }

    private void initView() {
        ViewPager vpOrdinary = findViewById(R.id.vp_ordinary);
        vpOrdinary.setLayoutParams(viewPagerLayoutParams());
        vpOrdinary.setAdapter(new OrdinaryViewPagerAdapterImpl(this, listImg));
        vpOrdinary.setPageTransformer(true, new PageTransformerAnalysis());
    }
}
