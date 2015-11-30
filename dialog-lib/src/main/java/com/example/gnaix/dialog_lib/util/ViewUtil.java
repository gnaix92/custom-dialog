package com.example.gnaix.dialog_lib.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * 名称: ViewUtil
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/30
 */
public class ViewUtil {

    /**
     * dp to px
     *
     * @param context
     * @param dp
     * @return
     */
    public static int dp2px(Context context, float dp) {
        DisplayMetrics displayM = context.getResources().getDisplayMetrics();
        final float scale = displayM.density;
        return (int) (dp * scale + 0.5f);
    }
}
