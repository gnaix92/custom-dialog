package com.example.gnaix.dialog_lib.model;

/**
 * 名称: MenuItem
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/28
 */
public class MenuItem {
    private String operName;
    private int resId;

    public MenuItem(String operName, int resId){
        this.operName = operName;
        this.resId = resId;
    }

    public String getOperName() {
        return operName;
    }

    public void setOperName(String operName) {
        this.operName = operName;
    }

    public int getResId() {
        return resId;
    }

    public void setResId(int resId) {
        this.resId = resId;
    }
}
