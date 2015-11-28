package com.example.gnaix.dialog_lib.widget;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout.LayoutParams;

import com.example.gnaix.dialog_lib.R;
import com.example.gnaix.dialog_lib.util.CornerUtil;
import com.example.gnaix.dialog_lib.widget.base.BaseNormalDialog;

/**
 * 名称: MateriaDialog
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/27
 */
public class MateriaDialog extends BaseNormalDialog<MateriaDialog> {

    public MateriaDialog(Context context) {
        super(context);

        //default value
        titleTextColor = getResColor(R.color.material_title);
        titleTextSize = 22f;
        contentTextColor = getResColor(R.color.material_content);
        contentTextSize = 16f;
        btnLeftTextColor = getResColor(R.color.material_btn_left);
        btnRightTextColor = getResColor(R.color.material_btn_right);
        btnMiddleTextColor = getResColor(R.color.material_btn_middle);
    }

    @Override
    public View onCreateView() {
        //title
        tvTitle.setGravity(Gravity.CENTER_VERTICAL);
        tvTitle.setPadding(dp2px(20), dp2px(20), dp2px(20), dp2px(0));
        tvTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        llContainer.addView(tvTitle);

        //content
        tvContent.setPadding(dp2px(20), dp2px(20), dp2px(20), dp2px(20));
        tvTitle.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        llContainer.addView(tvContent);

        //button
        llBtns.setGravity(Gravity.RIGHT);
        llBtns.addView(tvBtnLeft);
        llBtns.addView(tvBtnMiddle);
        llBtns.addView(tvBtnRight);

        tvBtnLeft.setPadding(dp2px(15), dp2px(8), dp2px(15), dp2px(8));
        tvBtnRight.setPadding(dp2px(15), dp2px(8), dp2px(15), dp2px(8));
        tvBtnMiddle.setPadding(dp2px(15), dp2px(8), dp2px(15), dp2px(8));
        llBtns.setPadding(dp2px(20), dp2px(8), dp2px(10), dp2px(10));

        llContainer.addView(llBtns);
        return llContainer;
    }

    @Override
    public void setUibeforeShow() {
        super.setUibeforeShow();

        //set backgound color and corner radius
        float radius = dp2px(cornerRadius);
        llContainer.setBackground(CornerUtil.cornerDrawable(bgColor, radius));
        tvBtnLeft.setBackground(CornerUtil.btnSelector(radius, bgColor, btnPressColor, -2));
        tvBtnRight.setBackground(CornerUtil.btnSelector(radius, bgColor, btnPressColor, -2));
        tvBtnMiddle.setBackground(CornerUtil.btnSelector(radius, bgColor, btnPressColor, -2));
    }
}
