package dg.bin.com.banner_viewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import dg.bin.com.banner_viewpager.R;

public class CirculationViewPagerAdapterImpl extends AbsViewPagerAdapter {

    public static final int ALL = 2;
    public static final int LEFT = 1;
    public static final int RIGHT = 0;

    public final int mCirculationDirection;// 0 向右滑动循环 1 向左滑动循环

    public CirculationViewPagerAdapterImpl(Context mContext, List<Integer> mList, int mCirculationDirection){
        this.mContext = mContext;
        this.mCirculationDirection = mCirculationDirection;
        switch (mCirculationDirection){
            case RIGHT:
                mList.add(mList.get(0));
                break;
            case LEFT:
                mList.add(0, mList.get(mList.size()-1));
                break;
            case ALL:
                mList.add(0, mList.get(mList.size()-1));
                mList.add(mList.get(1));
                break;
        }
        this.mList = mList;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // 获得相应位置上的view； container view的容器，其实就是viewpager自身,
        // position: viewpager上的位置
        // 给container添加内容
        ImageView img = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.vp_img, container, false);
        img.setImageDrawable(mContext.getResources().getDrawable((Integer) mList.get(position)));

        container.addView(img);

        return img;
    }

}
