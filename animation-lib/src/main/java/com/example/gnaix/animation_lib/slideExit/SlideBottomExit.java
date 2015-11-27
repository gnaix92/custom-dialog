package com.example.gnaix.animation_lib.slideExit;

import android.animation.ObjectAnimator;
import android.view.View;

import com.example.gnaix.animation_lib.BaseAnimatorSet;

/**
 * 名称: SlideBottomExit
 * 描述: 下拉消失
 *
 * @author xiangqing.xue
 * @date 15/11/26
 */
public class SlideBottomExit extends BaseAnimatorSet{
    @Override
    public void setAnimation(View view) {
        float density = getDensity(view);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationY", 0, 250*density),
                ObjectAnimator.ofFloat(view, "alpha", 1, 0)
        );
    }
}
