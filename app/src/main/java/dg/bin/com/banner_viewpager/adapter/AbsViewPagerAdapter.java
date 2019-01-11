package dg.bin.com.banner_viewpager.adapter;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by b on 2019/1/9.
 */

public abstract class AbsViewPagerAdapter extends PagerAdapter {

    public static final String TAG = AbsViewPagerAdapter.class.getSimpleName();

    Context mContext;
    List mList;

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        // 销毁对应位置上的Object
        container.removeView((View) object);
    }

}
