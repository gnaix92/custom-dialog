package com.example.gnaix.diydialog.activity;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.gnaix.animation_lib.BaseAnimatorSet;
import com.example.gnaix.animation_lib.bounceEnter.BounceTopEnter;
import com.example.gnaix.animation_lib.slideExit.SlideBottomExit;
import com.example.gnaix.dialog_lib.listener.OnBtnClickL;
import com.example.gnaix.dialog_lib.widget.NormalDialog;
import com.example.gnaix.diydialog.R;
import com.example.gnaix.diydialog.adapter.MenuAdapter;
import com.example.gnaix.diydialog.util.T;
import com.example.gnaix.diydialog.util.ViewFind;

public class MainActivity extends AppCompatActivity implements ExpandableListView.OnChildClickListener {
    private final String TAG = this.getClass().getSimpleName();
    private Context context = this;
    private ExpandableListView lvExpandable;

    private static String[] groups = {
            "Default Inner Dialog",
            "Custom Dialog",
            "Default Inner Anim",
            "Custom Anim"
    };

    private static String[][] childs = {
            //"Default Inner Dialog"
            {
                    "NormalDialog StyleOne",
                    "NormalDialog StyleTwo",
                    "NormalDialog Custom Attr",
                    "NormalDialog oneBtn",
                    "NormalDialog threeBtn"
            },
            //Custom Dialog
            {
                    "Custom Dialog extends BaseDialog"
            },
            //Default Inner Anim
            {
                    "Show Anim"
            },
            //Custom Anim
            {
                    "Custom Anim like taobao"
            }
    };
    private BaseAnimatorSet bas_in;
    private BaseAnimatorSet bas_out;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                normalDialogStyleOne();
            }
        });

        initIntances();

    }

    private void initIntances() {
        bas_in = new BounceTopEnter();
        bas_out = new SlideBottomExit();

        //获取顶层View
        View decorView = getWindow().getDecorView();
        lvExpandable = ViewFind.find(decorView, R.id.elv_menu);

        MenuAdapter menuAdapter = new MenuAdapter(this, groups, childs);
        lvExpandable.setAdapter(menuAdapter);

        for (int i = 0; i < groups.length; i++) {
            lvExpandable.expandGroup(i);
        }
        lvExpandable.setOnChildClickListener(this);
        lvExpandable.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
            @Override
            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
                return false;
            }
        });

    }

    @Override
    public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
        switch (groupPosition) {
            //Default Inner Dialog
            case 0:
                switch (childPosition) {
                    case 0:
                        normalDialogStyleOne();
                        break;
                    case 1:
                        normalDialogStyleTwo();
                        break;
                    case 2:
                        normalDialogCustomAttr();
                        break;
                    case 3:
                        normalDialogOneBtn();
                        break;
                    case 4:
                        normalDialogThreeBtn();
                        break;
                }
                break;
        }
        return true;
    }

    private void normalDialogStyleOne() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.setContentText("确定退出程序?")
                .setShowAnim(bas_in)
                .setDismissAnim(bas_out)
                .setCanceledOutside(true) //can canceledOutside
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "left");
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "right");
                        dialog.dismiss();
                    }
                });
    }

    private void normalDialogStyleTwo() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.setContentText(R.string.normal_dialog_two_content)
                .setStyle(NormalDialog.STYLE_TWO)
                .setTitleTextSize(23)
                .setShowAnim(bas_in)
                .setDismissAnim(bas_out)
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "left");
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "right");
                        dialog.dismiss();
                    }
                });
    }

    private void normalDialogCustomAttr() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.isTitleShow(false)
                .setBgColor(getResColor(R.color.normal_dialog_bg))
                .setCornerRadius(5)
                .setContentText(R.string.normal_dialog_custome_attr)
                .setContentGravity(Gravity.CENTER)
                .setContentTextColor(getResColor(R.color.normal_dialog_text))
                .setDividerColor(getResColor(R.color.normal_dialog_divider))
                .setBtnTextSize(15.f, 15.f)
                .setBtnTextColor(getResColor(R.color.normal_dialog_text), getResColor(R.color.normal_dialog_text))
                .setBtnPressColor(getResColor(R.color.normal_dialog_btn_pressed))
                .setWidthScale(0.85f)
                .setShowAnim(bas_in)
                .setDismissAnim(bas_out)
                .show();

        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "left");
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "right");
                        dialog.dismiss();
                    }
                });

    }

    private void normalDialogOneBtn() {
        final NormalDialog dialog = new NormalDialog(context);
        dialog.setContentText(R.string.normal_dialog_btn_content)
                .setBtnNum(1)
                .setBtnText(R.string.normal_dialog_btn_3)
                .setShowAnim(bas_in)
                .setDismissAnim(bas_out)
                .show();

        dialog.setOnBtnClickL(new OnBtnClickL() {
            @Override
            public void onBtnClik() {
                T.showLong(context, "middle");
                dialog.dismiss();
            }
        });
    }

    private void normalDialogThreeBtn(){
        final NormalDialog dialog = new NormalDialog(context);
        dialog.setContentText(R.string.normal_dialog_btn_content)
                .setBtnNum(3)
                .setBtnText(R.string.normal_dialog_btn_1, R.string.normal_dialog_btn_2, R.string.normal_dialog_btn_3)
                .setShowAnim(bas_in)
                .setDismissAnim(bas_out)
                .show();
        dialog.setOnBtnClickL(
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "left");
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "right");
                        dialog.dismiss();
                    }
                },
                new OnBtnClickL() {
                    @Override
                    public void onBtnClik() {
                        T.showLong(context, "middle");
                        dialog.dismiss();
                    }
                });
    }


    /**
     * get resource color
     *
     * @param resId
     * @return
     */
    protected int getResColor(int resId) {
        return context.getResources().getColor(resId);
        //return Resources.getSystem().getColor(resId);
    }
}
