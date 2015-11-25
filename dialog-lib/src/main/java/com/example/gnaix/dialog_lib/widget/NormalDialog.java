package com.example.gnaix.dialog_lib.widget;

import android.content.Context;
import android.view.View;

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
    private View vLineTile, vLineVertical1, vLineVertical2, vLineHorizontal;
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
        return null;
    }
}
