package com.example.gnaix.dialog_lib.util;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;

/**
 * 名称: CornerUtil
 * 描述: 构造图层
 *
 * @author xiangqing.xue
 * @date 15/11/26
 */
public class CornerUtil {

    /**
     * 构建圆角矩形图层
     *
     * @param bgColor
     * @param cornerRadius
     * @return
     */
    public static Drawable cornerDrawable(final int bgColor, float cornerRadius) {
        final GradientDrawable bg = new GradientDrawable();
        bg.setColor(bgColor);
        bg.setCornerRadius(cornerRadius);
        return bg;
    }

    /**
     * 构建圆角矩形图层
     *
     * @param bgColor
     * @param cornerRadius
     * @return
     */
    public static Drawable cornerDrawable(final int bgColor, float[] cornerRadius) {
        final GradientDrawable bg = new GradientDrawable();
        bg.setColor(bgColor);
        bg.setCornerRadii(cornerRadius);
        return bg;
    }

    /**
     * 按钮点击图层
     *
     * @param radius
     * @param normalColor
     * @param pressColor
     * @param postion
     * @return
     */
    public static StateListDrawable btnSelector(float radius, int normalColor, int pressColor, int postion) {
        StateListDrawable bg = new StateListDrawable();
        Drawable normal = null;
        Drawable pressed = null;

        switch (postion) {
            case 0:
                //left button
                normal = cornerDrawable(normalColor, new float[]{0, 0, 0, 0, 0, 0, radius, radius});
                pressed = cornerDrawable(pressColor, new float[]{0, 0, 0, 0, 0, 0, radius, radius});
                break;
            case 1:
                //right button
                normal = cornerDrawable(normalColor, new float[]{0, 0, 0, 0, radius, radius, 0, 0});
                pressed = cornerDrawable(pressColor, new float[]{0, 0, 0, 0, radius, radius, 0, 0});
                break;
            case -1:
                //middle
                normal = cornerDrawable(normalColor, new float[]{0, 0, 0, 0, radius, radius, radius, radius});
                pressed = cornerDrawable(pressColor, new float[]{0, 0, 0, 0, radius, radius, radius, radius});
                break;
            case -2:
                //material dialog
                normal = cornerDrawable(normalColor, radius);
                pressed = cornerDrawable(pressColor, radius);
        }

        bg.addState(new int[]{android.R.attr.state_pressed}, pressed);
        bg.addState(new int[]{-android.R.attr.state_pressed}, normal);
        return bg;
    }
}
