package com.example.gnaix.animation_lib;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.animation.Interpolator;

import com.nineoldandroids.view.ViewHelper;

/**
 * 名称: BaseAnimatorSet
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/25
 */
public abstract class BaseAnimatorSet {
    //动画时间
    protected long duration = 500;
    //动画集合
    protected AnimatorSet animatorSet = new AnimatorSet();
    //动画效果
    private Interpolator interpolator;
    //延迟
    private long delay;
    //监听
    private AnimatorListener listener;

    /**
     * 需要子类继承
     *
     * @param view
     */
    public abstract void setAnimation(View view);

    /**
     * 执行动画
     *
     * @param view
     */
    protected void start(final View view) {
        reset(view);
        setAnimation(view);
        animatorSet.setDuration(duration);
        if (interpolator != null) {
            animatorSet.setInterpolator(interpolator);
        }
        if (delay > 0) {
            animatorSet.setStartDelay(delay);
        }

        if (listener != null) {
            animatorSet.addListener(new Animator.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animation) {
                    listener.onAnimationStart(animation);
                }

                @Override
                public void onAnimationEnd(Animator animation) {
                    listener.onAnimationEnd(animation);
                }

                @Override
                public void onAnimationCancel(Animator animation) {
                    listener.onAnimationCancel(animation);
                }

                @Override
                public void onAnimationRepeat(Animator animation) {
                    listener.onAnimationRepeat(animation);
                }
            });
        }
        animatorSet.start();
    }

    /**
     * 重置效果
     *
     * @param view
     */
    public static void reset(View view) {
        //透明度
        ViewHelper.setAlpha(view, 1);
        //缩放
        ViewHelper.setScaleX(view, 1);
        ViewHelper.setScaleY(view, 1);
        //位移
        ViewHelper.setTranslationX(view, 0);
        ViewHelper.setTranslationX(view, 0);
        //旋转
        ViewHelper.setRotation(view, 0);
        ViewHelper.setRotationX(view, 0);
        ViewHelper.setRotationY(view, 0);
    }

    /**
     * 设置动画时长
     *
     * @param duration
     * @return
     */
    public BaseAnimatorSet setDuration(long duration) {
        this.duration = duration;
        return this;
    }

    /**
     * 设置动画延时时长
     *
     * @param delay
     * @return
     */
    public BaseAnimatorSet setDelay(long delay) {
        this.delay = delay;
        return this;
    }

    /**
     * 设置动画加速
     *
     * @param interpolator
     * @return
     */
    public BaseAnimatorSet setInterpolator(Interpolator interpolator) {
        this.interpolator = interpolator;
        return this;
    }

    /**
     * 动画监听
     *
     * @param listener
     * @return
     */
    public BaseAnimatorSet setListener(AnimatorListener listener) {
        this.listener = listener;
        return this;
    }

    /**
     * 在View上执行动画
     *
     * @param view
     */
    public void playOn(View view) {
        start(view);
    }

    public interface AnimatorListener {
        void onAnimationStart(Animator animator);

        void onAnimationEnd(Animator animator);

        void onAnimationRepeat(Animator animator);

        void onAnimationCancel(Animator animator);
    }

    /**
     * 获取密度
     *
     * @param view
     * @return
     */
    public float getDensity(View view) {
        DisplayMetrics dm = view.getContext().getResources().getDisplayMetrics();
        return dm.density;
    }
}

