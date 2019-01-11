package dg.bin.com.banner_viewpager.settings.pagetransformer;

import android.support.v4.view.ViewPager;
import android.view.View;

public class PageTransformerAnalysis implements ViewPager.PageTransformer {
    @Override
    public void transformPage(View page, float position) {
        //向左滑动，【-1，0），position 从 0 到 -1，正在显示的页面，逐渐消失的过程
        //向左滑动，【-2， -1），position 从 -1 到 -2，左侧缓存的页面，继续向左滑动一个页面的过程（用户不可见，所以不需要关注）
        //向左滑动，【0，1），position 从1 到 0，右侧要显示的页面，逐渐显示的过程

        //向右滑动，（0，1】，position 从 0 到 1，正在显示的页面，逐渐消失的过程
        //向右滑动，（-1，0】，position 从 -1 到 0，左侧要显示的页面，逐渐显示的过程
        //向右滑动，（1，2】，position 从 1 到 2，右侧缓存的页面，继续向右滑动一个页面的过程（用户不可见，所以不需要关注）

        //假设实现效果
        //需要保证的时 position 等于 -1，0，1 这三个位置时的形态（例如大小）
        //==0，为正常大小
        //==-1，大小的 50%
        //==1， 大小的 50%

        if(position <= 0){
            //[-1, 0]
            //向左滑动时，执行【-1，0），view 大小从 100% 变成 50%，代码 1+0.5f*position
            //向右滑动时，执行（-1，0】，view 大小从 50% 变成 100%，代码 1+0.5f*position
            page.setScaleX(1+0.5f*position);
            page.setScaleY(1+0.5f*position);
        }else if(position <= 1){
            //(0,1]
            //向左滑动时，执行【0，1），==0 会在上面的判断中实现，对 view 没有影响，所以先不关注；代码1-0.5f*position
            //向右滑动时，执行（0，1】，view 大小从 100% 变成 50%，代码 1-0.5f*position
            page.setScaleX(1-0.5f*position);
            page.setScaleY(1-0.5f*position);
        }
    }
}
