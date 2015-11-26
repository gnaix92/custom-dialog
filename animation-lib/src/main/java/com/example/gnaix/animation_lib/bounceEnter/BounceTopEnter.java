package com.example.gnaix.animation_lib.bounceEnter;

import android.animation.ObjectAnimator;
import android.view.View;

import com.example.gnaix.animation_lib.BaseAnimatorSet;

/**
 * 名称: BounceTopEnter
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/26
 */
public class BounceTopEnter extends BaseAnimatorSet {

    public BounceTopEnter() {
        duration = 1000;
    }


    @Override
    public void setAnimation(View view) {
        float density = getDensity(view);
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "alpha", 0, 1, 1, 1),
                ObjectAnimator.ofFloat(view, "translationY", -250 * density, 30, -10, 0));
    }
}
