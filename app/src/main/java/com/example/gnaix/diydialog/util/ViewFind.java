package com.example.gnaix.diydialog.util;

import android.view.View;

/**
 * 名称: ViewFind
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/24
 */
public class ViewFind {



    /**
     * 简化findViewById
     * @param view
     * @param id
     * @param <T>
     * @return
     */
    public static <T extends View> T find(View view, int id){
        return (T) view.findViewById(id);
    }
}
