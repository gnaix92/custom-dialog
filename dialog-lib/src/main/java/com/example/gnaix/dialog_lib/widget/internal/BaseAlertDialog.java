package com.example.gnaix.dialog_lib.widget.internal;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gnaix.dialog_lib.R;
import com.example.gnaix.dialog_lib.listener.OnBtnClickL;
import com.example.gnaix.dialog_lib.widget.base.BaseDialog;

/**
 * 名称: BaseAlertDialog
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/25
 */
public abstract class BaseAlertDialog<T extends BaseAlertDialog<T>> extends BaseDialog {

    // container
    protected LinearLayout llContainer;
    /** title */
    //title
    protected TextView tvTitle;
    //title text
    protected String titleText;
    //title text color
    protected int titleTextColor;
    //title text size (sp)
    protected float titleTextSize;
    // enable title show
    protected boolean isTitleShow = true;

    /** content */
    //content
    protected TextView tvContent;
    //content text
    protected String contentText;
    //content text color
    protected int contentTextColor;
    //context text size(sp)
    protected float contentTextSize;
    //context gravity
    protected int contentGravity = Gravity.CENTER_VERTICAL;

    /** button */
    //num of btn [1,3]
    protected int btnNum = 2;
    //btns container
    protected LinearLayout llBtns;
    //btns
    protected TextView tvBtnLeft, tvBtnRight, tvBtnMiddle;
    //btns text
    protected String btnLeftText = "取消";
    protected String btnRightText = "确定";
    protected String btnMiddleText = "继续";
    //btns text color
    protected int btnLeftTextColor, btnRightTextColor, btnMiddleTextColor;
    //btns text size
    protected float btnLeftTextSize = 15f;
    protected float btnRightTextSize = 15f;
    protected float btnMiddleTextSize = 15f;
    // btn press color
    protected int btnPressColor = getResColor(R.color.normal_button_pressed);// #85D3EF,#ffcccccc,#E3E3E3
    // btn click listener
    protected OnBtnClickL onBtnLeftClickL;
    protected OnBtnClickL onBtnRightClickL;
    protected OnBtnClickL onBtnMiddleClickL;

    // corner radius,dp(圆角程度,单位dp)
    protected float cornerRadius = 3;
    // background color(背景颜色)
    protected int bgColor = getResColor(R.color.normal_bg);

    /**
     * method execute order:
     * show:constrouctor---show---oncreate---onStart---onAttachToWindow
     * cancel:cancel---onDetachedFromWindow---onStop
     *
     * @param context
     */
    public BaseAlertDialog(Context context) {
        super(context);
        setWidthScale(0.88f);
        llContainer = new LinearLayout(context);
        llContainer.setOrientation(LinearLayout.VERTICAL);

        tvTitle = new TextView(context);
        tvContent = new TextView(context);

        llBtns = new LinearLayout(context);
        llBtns.setOrientation(LinearLayout.HORIZONTAL);
        tvBtnLeft = new TextView(context);
        tvBtnRight = new TextView(context);
        tvBtnMiddle = new TextView(context);
        tvBtnLeft.setGravity(Gravity.CENTER);
        tvBtnRight.setGravity(Gravity.CENTER);
        tvBtnMiddle.setGravity(Gravity.CENTER);
    }


    @Override
    public void setUibeforeShow() {
        // title
        tvTitle.setVisibility(isTitleShow ? View.VISIBLE : View.GONE);
        tvTitle.setText(TextUtils.isEmpty(titleText) ? "温馨提示" : titleText);
        tvTitle.setTextColor(titleTextColor);
        tvTitle.setTextSize(TypedValue.COMPLEX_UNIT_SP, titleTextSize);

        //content
        tvContent.setText(contentText);
        tvContent.setGravity(contentGravity);
        tvContent.setTextColor(contentTextColor);
        tvContent.setTextSize(TypedValue.COMPLEX_UNIT_SP, contentTextSize);
        tvContent.setLineSpacing(0, 1.3f);

        //button
        tvBtnLeft.setText(btnLeftText);
        tvBtnRight.setText(btnRightText);
        tvBtnMiddle.setText(btnMiddleText);

        tvBtnLeft.setTextColor(btnLeftTextColor);
        tvBtnRight.setTextColor(btnRightTextColor);
        tvBtnMiddle.setTextColor(btnMiddleTextColor);

        tvBtnLeft.setTextSize(TypedValue.COMPLEX_UNIT_SP, btnLeftTextSize);
        tvBtnRight.setTextSize(TypedValue.COMPLEX_UNIT_SP,btnRightTextSize);
        tvBtnMiddle.setTextSize(TypedValue.COMPLEX_UNIT_SP,btnMiddleTextSize);

        if(btnNum == 1){
            tvBtnLeft.setVisibility(View.GONE);
            tvBtnRight.setVisibility(View.GONE);
        }else if(btnNum == 2){
            tvBtnMiddle.setVisibility(View.GONE);
        }

        tvBtnLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBtnLeftClickL != null){
                    onBtnLeftClickL.onBtnClik();
                }else{
                    dismiss();
                }
            }
        });
        tvBtnRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBtnRightClickL != null){
                    onBtnRightClickL.onBtnClik();
                }else{
                    dismiss();
                }
            }
        });
        tvBtnMiddle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onBtnMiddleClickL != null){
                    onBtnMiddleClickL.onBtnClik();
                }else{
                    dismiss();
                }
            }
        });
    }

    //------- title ------- //
    public T setTitleText(String text){
        this.titleText = text;
        return (T) this;
    }

    public T setTitleTextColor(int titleTextColor){
        this.titleTextColor = titleTextColor;
        return (T) this;
    }

    public T setTitleTextSize(float titleTextSize){
        this.titleTextSize = titleTextSize;
        return (T) this;
    }

    public T isTitleShow(boolean isTitleShow){
        this.isTitleShow = isTitleShow;
        return (T) this;
    }

    // -------- content -------- //
    public T setContentText(String text){
        this.contentText = text;
        return (T) this;
    }

    public T setContentTextColor(int contentTextColor){
        this.contentTextColor = contentTextColor;
        return (T) this;
    }

    public T setContentTextSize(float contentTextSize){
        this.contentTextSize = contentTextSize;
        return (T) this;
    }

    public T setContentGravity(int contentGravity){
        this.contentGravity = contentGravity;
        return (T) this;
    }

    // ------- button -------- //
    public T setBtnNum(int btnNum) {
        if (btnNum < 1 || btnNum > 3) {
            throw new IllegalStateException("btnNum is [1,3]");
        }
        this.btnNum = btnNum;
        return (T) this;
    }

    public T setBtnText(String... btnTexts) {
        if (btnTexts.length < 1 || btnTexts.length > 3){
            throw new IllegalStateException("range of param btnTexts length is [1,3]");
        }
        switch (btnTexts.length){
            case 1:
                tvBtnMiddle.setText(btnTexts[0]);
                break;
            case 2:
                tvBtnLeft.setText(btnTexts[0]);
                tvBtnRight.setText(btnTexts[1]);
                break;
            case 3:
                tvBtnLeft.setText(btnTexts[0]);
                tvBtnRight.setText(btnTexts[1]);
                tvBtnMiddle.setText(btnTexts[2]);
                break;
        }
        return (T) this;
    }

    public T setBtnTextColor(int... btnTextColors) {
        if (btnTextColors.length < 1 || btnTextColors.length > 3){
            throw new IllegalStateException("range of param btnTextColors length is [1,3]");
        }
        switch (btnTextColors.length){
            case 1:
                tvBtnMiddle.setTextColor(btnTextColors[0]);
                break;
            case 2:
                tvBtnLeft.setTextColor(btnTextColors[0]);
                tvBtnRight.setTextColor(btnTextColors[1]);
                break;
            case 3:
                tvBtnLeft.setTextColor(btnTextColors[0]);
                tvBtnRight.setTextColor(btnTextColors[1]);
                tvBtnMiddle.setTextColor(btnTextColors[2]);
                break;
        }
        return (T) this;
    }

    public T setBtnTextSize(float... btnTextSizes) {
        if (btnTextSizes.length < 1 || btnTextSizes.length > 3){
            throw new IllegalStateException("range of param btnTextSizes length is [1,3]");
        }
        switch (btnTextSizes.length){
            case 1:
                tvBtnMiddle.setTextSize(btnTextSizes[0]);
                break;
            case 2:
                tvBtnLeft.setTextSize(btnTextSizes[0]);
                tvBtnRight.setTextSize(btnTextSizes[1]);
                break;
            case 3:
                tvBtnLeft.setTextSize(btnTextSizes[0]);
                tvBtnRight.setTextSize(btnTextSizes[1]);
                tvBtnMiddle.setTextSize(btnTextSizes[2]);
                break;
        }
        return (T) this;
    }

    public void setOnBtnClickL(OnBtnClickL... onBtnClickLs){
        if (onBtnClickLs.length < 1 || onBtnClickLs.length > 3){
            throw new IllegalStateException("range of param onBtnClickLs length is [1,3]");
        }
        switch (onBtnClickLs.length){
            case 1:
                onBtnMiddleClickL = onBtnClickLs[0];
                break;
            case 2:
                onBtnLeftClickL = onBtnClickLs[0];
                onBtnRightClickL = onBtnClickLs[1];
                break;
            case 3:
                onBtnLeftClickL = onBtnClickLs[0];
                onBtnRightClickL = onBtnClickLs[1];
                onBtnMiddleClickL = onBtnClickLs[2];
                break;
        }
    }

    public T setBtnPressColor(int btnPressColor){
        this.btnPressColor = btnPressColor;
        return (T) this;
    }

    public T setCornerRadius(float cornerRadius){
        this.cornerRadius = cornerRadius;
        return (T) this;
    }

    public T setBgColor(int bgColor){
        this.bgColor = bgColor;
        return (T) this;
    }
}
