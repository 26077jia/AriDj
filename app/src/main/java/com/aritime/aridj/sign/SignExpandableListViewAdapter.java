package com.aritime.aridj.sign;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.aritime.aridj.R;

import java.util.List;

/**
 * 外层ExpandListView 适配器的实现
 * Created by MH on 2016/6/16.
 */
public class SignExpandableListViewAdapter extends BaseExpandableListAdapter {


    // 标牌的集合
    private List<Sign> signs;
    private Context context;

    private GroupViewHolder mGroupViewHolder;

    private ChilderViewHolder mChilderViewHolder;


    public SignExpandableListViewAdapter(List<Sign> colleges, Context context) {
        this.signs = colleges;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return signs.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        // 很关键，，一定要返回 1
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return signs.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return signs.get(groupPosition).machineList.get(childPosition);
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
        // 返回子ExpandableListView 的对象 此时传入是该父条目，即大学的对象（有歧义。。）
        if (convertView == null) {
            mGroupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_sign_item, null);
            mGroupViewHolder.gtextView = (TextView) convertView.findViewById(R.id.tv_sign_name);
//            mGroupViewHolder.img_up = (ImageView) convertView.findViewById(R.id.img_sign_icon_up);
            convertView.setTag(mGroupViewHolder);
        } else {
            mGroupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        // 绑定数据
        Sign msign = signs.get(groupPosition);
        mGroupViewHolder.gtextView.setText(msign.name);
        //判断isExpanded就可以控制是按下还是关闭，同时更换图片
//        if(isExpanded){
//            mGroupViewHolder.img_up.setBackgroundResource(R.mipmap.icon_down);
//        }else{
//            mGroupViewHolder.img_up.setBackgroundResource(R.mipmap.icon_up); }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return getGenericExpandableListView(signs.get(groupPosition));
    }
public static class ChilderViewHolder {
    public TextView ctextView;
}
public static class GroupViewHolder {
    public TextView gtextView;
//    public ImageView img_up;
}

    /**
     *  返回子ExpandableListView 的对象  此时传入的是该大学下所有班级的集合。
     * @param signs
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ExpandableListView getGenericExpandableListView(Sign signs){
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        CustomExpandableListView view = new CustomExpandableListView(context);

        // 加载班级的适配器
        MachineExpandableListViewAdapter adapter = new MachineExpandableListViewAdapter(signs.machineList,context);

        view.setAdapter(adapter);
        view.setDivider(null);
        view.setGroupIndicator(null);
        view.setPadding(50,8,8,0);
        int groupCount = view.getCount();
        for (int i=0; i<groupCount; i++)
        {
            view.expandGroup(i);
        }
        return view;
    }
    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
