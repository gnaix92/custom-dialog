package com.example.gnaix.dialog_lib.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gnaix.dialog_lib.R;
import com.example.gnaix.dialog_lib.model.MenuItem;

import java.util.List;

/**
 * 名称: ListDialogAdapter
 * 描述:
 *
 * @author xiangqing.xue
 * @date 15/11/30
 */
public class ListDialogAdapter extends SimpleBaseAdapter<MenuItem>{

    public ListDialogAdapter(Context context, List<MenuItem> data) {
        super(context, data);
    }

    @Override
    public int getItemResource() {
        return R.layout.menu_item;
    }

    @Override
    public View getItemView(int position, View convertView, ViewHolder viewHolder) {
        ImageView ivItem = viewHolder.getView(R.id.iv_image);
        TextView tvItem = viewHolder.getView(R.id.tv_item);
        MenuItem menuItem = (MenuItem) getItem(position);
        ivItem.setImageResource(menuItem.getResId());
        tvItem.setText(menuItem.getOperName());
        return convertView;
    }
}
