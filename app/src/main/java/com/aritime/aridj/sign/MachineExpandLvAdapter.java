package com.aritime.aridj.sign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.aritime.aridj.R;
import com.aritime.aridj.bean.Machine;

import java.util.List;

/**
 *
 * 设备的适配器
 * Created by MH on 2016/6/16.
 */
public class MachineExpandLvAdapter extends BaseExpandableListAdapter {


    // 设备的集合
    private List<Machine> mMachines;

    // 创建布局使用
    private Context context;
    private ParentViewHolder mParentViewHolder;
    private ItemViewHolder mItemViewHolder;

    public MachineExpandLvAdapter(List<Machine> mMachines, Context context) {
        this.mMachines = mMachines;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return mMachines.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 获取对应一级条目下二级条目的数量
        return mMachines.get(groupPosition).checkItems.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // 获取一级条目的对应数据
        return mMachines.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // 获取对应一级条目下二级条目的对应数据 感觉没什么用
        return mMachines.get(groupPosition).checkItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        if (convertView == null) {
            mParentViewHolder = new MachineExpandLvAdapter.ParentViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_machine_item, null);
            mParentViewHolder.ptv = (TextView) convertView.findViewById(R.id.tv_machine_name);

            convertView.setTag(mParentViewHolder);
        } else {
            mParentViewHolder = (MachineExpandLvAdapter.ParentViewHolder) convertView.getTag();
        }
        // 绑定数据
        mParentViewHolder.ptv.setText(mMachines.get(groupPosition).name);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        if (convertView == null) {
            mItemViewHolder = new MachineExpandLvAdapter.ItemViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_check_item, null);
            mItemViewHolder.itv = (TextView) convertView.findViewById(R.id.tv_sign_check_item);
            convertView.setTag(mItemViewHolder);

        } else {
            mItemViewHolder = (MachineExpandLvAdapter.ItemViewHolder) convertView.getTag();
        }
        // 绑定数据
        mItemViewHolder .itv.setText("");
        Machine machine = mMachines.get(groupPosition);
        mItemViewHolder.itv.setText(machine.checkItems.get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 二级条目是否可点击
        return true;
    }

    public static class ParentViewHolder {
        public TextView ptv;
    }
    public static class ItemViewHolder {
        public TextView itv;
    }

}