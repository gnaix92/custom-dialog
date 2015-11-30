package com.example.gnaix.dialog_lib.widget;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LayoutAnimationController;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.gnaix.dialog_lib.R;
import com.example.gnaix.dialog_lib.adapter.SimpleBaseAdapter;
import com.example.gnaix.dialog_lib.listener.OnOperItemClickL;
import com.example.gnaix.dialog_lib.model.MenuItem;
import com.example.gnaix.dialog_lib.widget.base.BaseDialog;

import java.util.ArrayList;
import java.util.List;

/**
 * 名称: NormalListDialog
 * 描述: 列表类型Dialog
 *
 * @author xiangqing.xue
 * @date 15/11/28
 */
public class NormalListDialog extends BaseDialog {

    /** title */
    //title
    private TextView tvTitle;
    //title text
    private String titleText = "提示";
    //title text color
    private int titleTextColor = getResColor(R.color.list_title);
    //title text size
    private float titleTextSize = 16.5f;
    //title bg color
    private int titleBgColor = getResColor(R.color.list_bg);
    //enable title show
    private boolean isTitleShow = true;

    /** content ListView */
    //container
    private LinearLayout llContainer;
    //ListView
    private ListView lvContent;
    //Adapter
    private SimpleBaseAdapter<MenuItem> adapter;
    // listview bg color
    private int lvContentBgColor = getResColor(R.color.list_bg);
    //listview item
    private int itemTextColor = getResColor(R.color.list_title);
    private int itemPressColor = getResColor(R.color.list_bg);
    private float itemTextSize = 15f;

    //operation item
    private List<MenuItem> contents = new ArrayList();
    private OnOperItemClickL onOperItemClickL;
    private LayoutAnimationController lac;

    //corner radius
    private float cornerRadius = 5;
    // divider
    private int dividerColor = Color.LTGRAY;
    private float dividerHeight = 0.8f;

    public NormalListDialog(Context context, ArrayList<MenuItem> baseItems){
        super(context);
        this.contents.addAll(baseItems);
    }

    public NormalListDialog(Context context, String[] items){
        super(context);
        this.contents = new ArrayList<>();
        for(String item:items){
            MenuItem menuItem = new MenuItem(item, 0);
            contents.add(menuItem);
        }

    }


    private void init() {
        setWidthScale(0.8f);
        TranslateAnimation animation = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, 2f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f,
                Animation.RELATIVE_TO_SELF, 0f);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.setDuration(550);

        lac = new LayoutAnimationController(animation, 0.12f);
        lac.setInterpolator(new DecelerateInterpolator());
    }

    @Override
    public View onCreateView() {
        return null;
    }

    @Override
    public void setUibeforeShow() {

    }
}
