package com.example.gnaix.dialog_lib.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

import com.example.gnaix.dialog_lib.R;
import com.example.gnaix.dialog_lib.util.CornerUtil;
import com.example.gnaix.dialog_lib.widget.internal.BaseAlertDialog;

/**
 * 名称: NormalDialog
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/25
 */
public class NormalDialog extends BaseAlertDialog<NormalDialog> {

    //分割线
    private View vLineTitle, vLineVertical1, vLineVertical2, vLineHorizontal;
    //title underline color
    private int titleLineColor = getResColor(R.color.normal_line_title);
    //title underline height
    private float titleLineHeight = 1f;
    //btn divider line color
    private int dividerColor = getResColor(R.color.normal_divider);

    public static final int STYLE_ONE = 0;
    public static final int STYLE_TWO = 1;
    private int style = STYLE_ONE;


    public NormalDialog(Context context) {
        super(context);
        //default value
        titleTextColor = getResColor(R.color.normal_title);
        titleTextSize = 22f;
        contentTextColor = getResColor(R.color.normal_content);
        contentTextSize = 17f;
        btnLeftTextColor = getResColor(R.color.normal_button);
        btnRightTextColor = getResColor(R.color.normal_button);
        btnMiddleTextColor = getResColor(R.color.normal_button);
    }

    @Override
    public View onCreateView() {
        //title
        tvTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        llContainer.addView(tvTitle);

        //title underline
        vLineTitle = new View(context);
        llContainer.addView(vLineTitle);

        //content
        tvContent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                LayoutParams.WRAP_CONTENT));
        llContainer.addView(tvContent);
        vLineHorizontal = new View(context);
        vLineHorizontal.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, 1));
        llContainer.addView(vLineHorizontal);

        //button
        tvBtnLeft.setLayoutParams(new LayoutParams(0, dp2px(45), 1));
        llBtns.addView(tvBtnLeft);

        vLineVertical1 = new View(context);
        vLineVertical1.setLayoutParams(new LayoutParams(1, LayoutParams.MATCH_PARENT));
        llBtns.addView(vLineVertical1);

        tvBtnMiddle.setLayoutParams(new LayoutParams(0, dp2px(45), 1));
        llBtns.addView(tvBtnMiddle);

        vLineVertical2 = new View(context);
        vLineVertical2.setLayoutParams(new LayoutParams(1, LayoutParams.MATCH_PARENT));
        llBtns.addView(vLineVertical2);

        tvBtnRight.setLayoutParams(new LayoutParams(0, dp2px(45), 1));
        llBtns.addView(tvBtnRight);

        llContainer.addView(llBtns);
        return llContainer;
    }

    @Override
    public void setUibeforeShow() {
        super.setUibeforeShow();

        //title
        if (style == STYLE_ONE) {
            tvTitle.setMinHeight(dp2px(48));
            tvTitle.setGravity(Gravity.CENTER_VERTICAL);
            tvTitle.setPadding(dp2px(15), dp2px(5), dp2px(0), dp2px(5));
            tvTitle.setVisibility(isTitleShow ? View.VISIBLE : View.GONE);
        } else if (style == STYLE_TWO) {
            tvTitle.setGravity(Gravity.CENTER);
            tvTitle.setPadding(dp2px(0), dp2px(15), dp2px(0), dp2px(0));
        }

        //title underline
        vLineTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, dp2px(titleLineHeight)));
        vLineTitle.setBackgroundColor(titleLineColor);
        vLineTitle.setVisibility(isTitleShow && style == STYLE_ONE ? View.VISIBLE : View.GONE);

        //content
        if (style == STYLE_ONE) {
            tvContent.setPadding(dp2px(15), dp2px(10), dp2px(15), dp2px(10));
            tvContent.setMinHeight(dp2px(68));
            tvContent.setGravity(contentGravity);
        } else if (style == STYLE_TWO) {
            tvContent.setPadding(dp2px(15), dp2px(7), dp2px(15), dp2px(20));
            tvContent.setMinHeight(dp2px(56));
            tvContent.setGravity(Gravity.CENTER);
        }

        //button
        vLineHorizontal.setBackgroundColor(dividerColor);
        vLineVertical1.setBackgroundColor(dividerColor);
        vLineVertical2.setBackgroundColor(dividerColor);

        if (btnNum == 1) {
            tvBtnLeft.setVisibility(View.GONE);
            tvBtnRight.setVisibility(View.GONE);
            vLineVertical1.setVisibility(View.GONE);
            vLineVertical2.setVisibility(View.GONE);
        } else if (btnNum == 2) {
            tvBtnMiddle.setVisibility(View.GONE);
            vLineVertical1.setVisibility(View.GONE);
        }

        //set backgroud color and corner radius
        float radius = dp2px(cornerRadius);
        llContainer.setBackground(CornerUtil.cornerDrawable(bgColor, radius));
        tvBtnLeft.setBackground(CornerUtil.btnSelector(radius, bgColor, btnPressColor, 0));
        tvBtnRight.setBackground(CornerUtil.btnSelector(radius, bgColor, btnPressColor, 1));
        tvBtnMiddle.setBackground(CornerUtil.btnSelector(btnNum == 1 ? radius : 0, bgColor, btnPressColor, -1));
    }

    // ---------- attr ----------//
    /**
     * set style
     */
    public NormalDialog setStyle(int style){
        this.style = style;
        return this;
    }

    /**
     * set titleLine Color
     * @param titleLineColor
     * @return
     */
    public NormalDialog setTitleLineColor(int titleLineColor){
        this.titleLineColor = titleLineColor;
        return this;
    }

    /**
     * set title line height
     * @param titleLineHeight
     * @return
     */
    public NormalDialog setTitleLineHeight(float titleLineHeight){
        this.titleLineHeight = titleLineHeight;
        return this;
    }

    /**
     * set divider color
     * @param dividerColor
     * @return
     */
    public NormalDialog dividerColor(int dividerColor){
        this.dividerColor = dividerColor;
        return this;
    }

}
