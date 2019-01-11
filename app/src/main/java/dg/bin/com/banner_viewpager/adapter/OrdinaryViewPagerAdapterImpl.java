package dg.bin.com.banner_viewpager.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

import dg.bin.com.banner_viewpager.R;

public class OrdinaryViewPagerAdapterImpl extends AbsViewPagerAdapter {

    public OrdinaryViewPagerAdapterImpl(Context mContext, List<Integer> mList){
        this.mContext = mContext;
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
