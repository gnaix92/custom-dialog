package com.example.gnaix.dialog_lib.widget.base;

import android.animation.Animator;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;

import com.example.gnaix.animation_lib.BaseAnimatorSet;

/**
 * 名称: BaseDialog
 * 描述: 弹窗基类
 *
 * @author xiangqing.xue
 * @date 15/11/25
 */
public abstract class BaseDialog<T extends BaseDialog<T>> extends Dialog{

    //TAG
    protected String TAG;
    //context
    protected Context context;
    //设备屏幕密度
    protected DisplayMetrics displayM;
    //enable cancel outside dialog (设置Dialog外区域是否为dismiss)
    protected boolean cancel;

    //showAnim
    private BaseAnimatorSet showAnim;
    //dismissAnim
    private BaseAnimatorSet dismissAnim;
    //is showAnim running
    private boolean isShowAnim;
    //is dissAnim running
    private boolean isDismissAnim;

    //top container
    protected LinearLayout llTop;
    //container to control dialog height(用于控制dialog高度)
    protected LinearLayout llControlHeight;
    //dialog width scale 比例
    protected float widthScale = 1;
    //dialog height scale 比例
    protected float heightScale;
    //max height
    protected float maxHeight;

    /**
     * method execute order:
     * show:constrouctor---show---oncreate---onStart---onAttachToWindow
     * cancel:cancel---onDetachedFromWindow---onStop
     */
    public BaseDialog(Context context) {
        super(context);
        setDiaLogTheme();
        this.context = context;
        this.TAG = this.getClass().getSimpleName();
        Log.d(TAG, "constrouctor");
    }

    /**
     * 设置DiaLog主题
     */
    private void setDiaLogTheme(){
        //android:windowNoTitle
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //android:background
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        //设置背景模糊
        getWindow().addFlags(LayoutParams.FLAG_DIM_BEHIND);
    }

    /**
     * inflate layout for dialog ui and return (填充对话框所需要的布局并返回)
     * @return
     */
    public abstract View onCreateView();

    /**
     * set Ui data or logic opreation before attatched window(在对话框显示之前,设置界面数据或者逻辑)
     */
    public abstract void setUibeforeShow();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        displayM = context.getResources().getDisplayMetrics();
        llTop = new LinearLayout(context);
        llTop.setGravity(Gravity.CENTER);

        llControlHeight = new LinearLayout(context);
        llControlHeight.setOrientation(LinearLayout.VERTICAL);
        llControlHeight.addView(onCreateView());

        llTop.addView(llControlHeight);

        maxHeight = displayM.heightPixels;

        setContentView(llTop, new ViewGroup.LayoutParams(displayM.widthPixels, (int) maxHeight));
        //点击dialog区域外消失
        setCanceledOnTouchOutside(true);

        llTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cancel){
                    dismiss();
                }
            }
        });
    }

    /**
     * when dailog attached to window,set dialog width and height and show anim
     * (当dailog依附在window上,设置对话框宽高以及显示动画)
     */
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "onAttachedToWindow");

        setUibeforeShow();

        //设置大小
        int width;
        if(widthScale == 0){
            width = ViewGroup.LayoutParams.WRAP_CONTENT;
        }else{
            width = (int) (displayM.widthPixels * widthScale);
        }

        int height;
        if(heightScale == 0){
            height = ViewGroup.LayoutParams.WRAP_CONTENT;
        }else if(heightScale==1){
            height = ViewGroup.LayoutParams.MATCH_PARENT;
        }else{
            height = (int) (maxHeight*heightScale);
        }
        llControlHeight.setLayoutParams(new LinearLayout.LayoutParams(width, height));

        //设置动画
        if(showAnim != null){
            showAnim.setListener(new BaseAnimatorSet.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    isShowAnim = true;
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    isShowAnim = false;
                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    isShowAnim = false;
                }
            }).playOn(llControlHeight);
        }else{
            BaseAnimatorSet.reset(llControlHeight);
        }
    }

    @Override
    public void setCanceledOnTouchOutside(boolean cancel) {
        this.cancel = cancel;
        super.setCanceledOnTouchOutside(cancel);
    }

    @Override
    public void show() {
        super.show();
        Log.d(TAG, "show");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop");
    }

    @Override
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Log.d(TAG, "onDetachedFromWindow");
    }

    @Override
    public void dismiss() {
        Log.d(TAG, "dissmiss");
        if(dismissAnim != null){
            dismissAnim.setListener(new BaseAnimatorSet.AnimatorListener() {
                @Override
                public void onAnimationStart(Animator animator) {
                    isDismissAnim = true;
                }

                @Override
                public void onAnimationEnd(Animator animator) {
                    isDismissAnim = false;
                    superDismiss();
                }

                @Override
                public void onAnimationRepeat(Animator animator) {

                }

                @Override
                public void onAnimationCancel(Animator animator) {
                    isDismissAnim = false;
                    superDismiss();
                }
            }).playOn(llControlHeight);
        }else{
            superDismiss();
        }
    }

    /**
     * dismiss
     */
    public void superDismiss(){
        super.dismiss();
    }

    /**
     * dialog anim by styles
     * @param animSytle
     */
    public void show(int animSytle){
        Window window = getWindow();
        window.setWindowAnimations(animSytle);
        show();
    }

    /**
     * set window dism or not (设置背景是否昏暗)
     * @param isDimEabled
     * @return
     */
    public T dimEnabled(boolean isDimEabled){
        if(isDimEabled){
            getWindow().addFlags(LayoutParams.FLAG_DIM_BEHIND);
        }else{
            getWindow().clearFlags(LayoutParams.FLAG_DIM_BEHIND);
        }
        return (T) this;
    }

    /**
     *  set dialog width scale:0-1
     * @param widthScale
     * @return
     */
    public T setWidthScale(float widthScale){
        this.widthScale = widthScale;
        return (T) this;
    }

    /**
     * set dialog height scale:0-1
     * @param heightScale
     * @return
     */
    public T setHeightScale(float heightScale){
        this.heightScale = heightScale;
        return (T) this;
    }

    public T setShowAnim(BaseAnimatorSet showAnim){
        this.showAnim = showAnim;
        return (T) this;
    }

    public T setDismissAnim(BaseAnimatorSet dismissAnim){
        this.dismissAnim = dismissAnim;
        return (T) this;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if(isDismissAnim || isShowAnim) return true;
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public void onBackPressed() {
        if(isDismissAnim || isShowAnim) return ;
        super.onBackPressed();
    }

    /**
     * dp to px
     * @param dp
     * @return
     */
    protected int dp2px(float dp){
        final float scale = displayM.density;
        return (int) (dp * scale + 0.5f);
    }

    /**
     * get resource color
     * @param resId
     * @return
     */
    protected int getResColor(int resId){
        return Resources.getSystem().getColor(resId);
    }
}
