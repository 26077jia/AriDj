package com.aritime.aridj.sign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.aritime.aridj.R;

import java.util.List;

/**
 *
 * 设备的适配器
 * Created by MH on 2016/6/16.
 */
public class MachineExpandableListViewAdapter extends BaseExpandableListAdapter {


    // 设备的集合
    private List<Machine> mMachines;

    // 创建布局使用
    private Context context;
    private ParentViewHolder mParentViewHolder;
    private ItemViewHolder mItemViewHolder;


    public MachineExpandableListViewAdapter(List<Machine> mMachines, Context context) {
        this.mMachines = mMachines;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        // 获取一级条目的数量 就是班级的大小
        return mMachines.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 获取对应一级条目下二级条目的数量，就是各个班学生的数量
        return mMachines.get(groupPosition).checkItems.size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        // 获取一级条目的对应数据 ，感觉没什么用
        return mMachines.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        // 获取对应一级条目下二级条目的对应数据 感觉没什么用
        return mMachines.get(groupPosition).checkItems.get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        // 直接返回，没什么用
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        // 直接返回，没什么用
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        // 谁知道这个是干什么。。。。
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

        // 获取对应一级条目的View 和ListView 的getView相似

        if (convertView == null) {
            mParentViewHolder = new MachineExpandableListViewAdapter.ParentViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_machine_item, null);
            mParentViewHolder.ptextView = (TextView) convertView.findViewById(R.id.tv_machine_name);

            convertView.setTag(mParentViewHolder);
        } else {
            mParentViewHolder = (MachineExpandableListViewAdapter.ParentViewHolder) convertView.getTag();
        }
        // 绑定数据
        mParentViewHolder.ptextView.setText(mMachines.get(groupPosition).name);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {


        if (convertView == null) {
            mItemViewHolder = new MachineExpandableListViewAdapter.ItemViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_check_item, null);
            mItemViewHolder.itextView = (TextView) convertView.findViewById(R.id.tv_sign_check_item);

            convertView.setTag(mItemViewHolder);
        } else {
            mItemViewHolder = (MachineExpandableListViewAdapter.ItemViewHolder) convertView.getTag();
        }
        // 绑定数据
        Machine machine = mMachines.get(groupPosition);
        mItemViewHolder.itextView.setText(machine.checkItems.get(childPosition));
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        // 根据方法名，此处应该表示二级条目是否可以被点击 先返回true 再讲
        return true;
    }



    public static class ParentViewHolder {
        public TextView ptextView;
    }
    public static class ItemViewHolder {
        public TextView itextView;
    }




//    @Override
//    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
//
//        // 获取对应一级条目的View  和ListView 的getView相似
//
//        return getGenericView(mMachines.get(groupPosition).name);
//    }
//
//    @Override
//    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
//
//        // 获取对应二级条目的View  和ListView 的getView相似
//        return getGenericView(mMachines.get(groupPosition).checkItems.get(childPosition));
//    }


//    /**
//     * 根据字符串生成布局，，因为我没有写layout.xml 所以用java 代码生成
//     *
//     *      实际中可以通过Inflate加载自己的自定义布局文件，设置数据之后并返回
//     * @param string
//     * @return
//     */
//    private TextView getGenericView(String string) {
//
//        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
//                ViewGroup.LayoutParams.MATCH_PARENT,
//                ViewGroup.LayoutParams.WRAP_CONTENT);
//
//        TextView textView = new TextView(context);
//        textView.setLayoutParams(layoutParams);
//
//        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.LEFT);
//
//        textView.setPadding(40, 20, 0, 20);
//        textView.setText(string);
//        textView.setTextColor(Color.RED);
//        return textView;
//    }

}