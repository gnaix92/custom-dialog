package com.example.gnaix.dialog_lib.widget;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;

import com.example.gnaix.dialog_lib.R;
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
    private int deviderColor = getResColor(R.color.normal_divider);

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
    }
}
