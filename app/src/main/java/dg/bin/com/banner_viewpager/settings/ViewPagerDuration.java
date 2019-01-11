package dg.bin.com.banner_viewpager.settings;

import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Scroller;

import java.lang.reflect.Field;

/**
 * Created by b on 2019/1/10.
 */

public class ViewPagerDuration {

    private static final String TAG = ViewPagerDuration.class.getSimpleName();

    /**
     * 设置 viewpager 执行动画的时间,默认250
     * @param vp
     * @param newDuration 以毫秒为单位
     */
    public static void setViewPagerDuration(ViewPager vp, final int newDuration){
        try {
            Field mField = ViewPager.class.getDeclaredField("mScroller");
            mField.setAccessible(true);
            Scroller mScroller = new Scroller(vp.getContext()){
                @Override
                public void startScroll(int startX, int startY, int dx, int dy, int duration) {
                    super.startScroll(startX, startY, dx, dy, newDuration);
                }
            };
            mField.set(vp, mScroller);
        } catch (Exception e) {
            Log.e(TAG, e.getMessage());
        }
    }

}
