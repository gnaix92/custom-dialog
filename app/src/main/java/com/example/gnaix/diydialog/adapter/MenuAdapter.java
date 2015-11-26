package com.example.gnaix.diydialog.adapter;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.example.gnaix.diydialog.R;

/**
 * 名称: MenuAdapter
 * 描述: 首页主菜单
 *
 * @author xiangqing.xue
 * @date 15/11/24
 */
public class MenuAdapter extends BaseExpandableListAdapter {
    private final String TAG = this.getClass().getSimpleName();

    private Context mContext;
    private String[] mGroupData;
    private String[][] mChildData;

    public MenuAdapter(Context context, String[] groupData, String[][] childData) {
        this.mContext = context;
        this.mGroupData = groupData;
        this.mChildData = childData;
    }

    //group
    @Override
    public int getGroupCount() {
        return mGroupData.length;
    }

    @Override
    public Object getGroup(int groupPosition) {
        if (groupPosition >= mGroupData.length)
            return null;
        return mGroupData[groupPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.menu_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        TextView tvContent = viewHolder.getView(R.id.tv_content);
        tvContent.setText(mGroupData[groupPosition]);
        return convertView;
    }

    //child
    @Override
    public int getChildrenCount(int groupPosition) {
        return mChildData[groupPosition].length;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        if (groupPosition >= mGroupData.length || childPosition >= mChildData.length)
            return null;
        return mChildData[groupPosition][childPosition];
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            convertView = View.inflate(mContext, R.layout.menu_item, null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Log.d(TAG, groupPosition + ", " + childPosition);
        TextView tvContent = viewHolder.getView(R.id.tv_content);
        View vLine = viewHolder.getView(R.id.v_line);
        vLine.setVisibility(View.GONE);
        tvContent.setTextColor(mContext.getResources().getColor(R.color.menu_item_content));
        tvContent.setText(mChildData[groupPosition][childPosition]);
        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
