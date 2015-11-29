package com.example.gnaix.dialog_lib.widget.base;

import android.content.Context;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

/**
 * 名称: BaseListDialog
 * 描述: 列表类型Dialog
 *
 * @author xiangqing.xue
 * @date 15/11/28
 */
public class BaseListDialog extends BaseDialog{

    /** title */
    //title
    protected TextView tvTitle;
    //title text
    protected String titleText;
    //title text color
    protected int titleTextColor;
    //title text size
    protected float titleTextSize;
    //enable title show
    protected boolean isTitleShow = true;

    /** content */
    //context
    protected ListView lvContent;
    //Adapter





    public BaseListDialog(Context context){
        super(context);

    }

    @Override
    public View onCreateView() {
        return null;
    }

    @Override
    public void setUibeforeShow() {

    }
}
