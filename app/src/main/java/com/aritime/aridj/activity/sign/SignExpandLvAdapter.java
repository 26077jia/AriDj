package com.aritime.aridj.activity.sign;

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
import com.aritime.aridj.bean.SignBean;

import java.util.List;

/**
 * 外层ExpandListView 适配器的实现
 * Created by MH on 2016/6/16.
 */
public class SignExpandLvAdapter extends BaseExpandableListAdapter {

    // 标牌的集合
    private List<SignBean> mSignBeen;
    private Context context;

    private GroupViewHolder mGroupViewHolder;
    private ChildrenViewHolder mChildrenViewHolder;


    public SignExpandLvAdapter(List<SignBean> signBeen, Context context) {
        this.mSignBeen = signBeen;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return mSignBeen.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        //必须返回 1
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return mSignBeen.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mSignBeen.get(groupPosition).mMachineBeanList.get(childPosition);
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
        return false;//数据改变，原数据id不变
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        // 返回子ExpandableListView 的对象 此时传入是该父条目
        if (convertView == null) {
            mGroupViewHolder = new GroupViewHolder();
            convertView = LayoutInflater.from(context).inflate(
                    R.layout.lv_sign_item, null);
            mGroupViewHolder.gtv = (TextView) convertView.findViewById(R.id.tv_sign_name);
//            mGroupViewHolder.img_up = (ImageView) convertView.findViewById(R.id.img_sign_icon_up);
            convertView.setTag(mGroupViewHolder);
        } else {
            mGroupViewHolder = (GroupViewHolder) convertView.getTag();
        }

        // 绑定数据
        SignBean msign = mSignBeen.get(groupPosition);
        mGroupViewHolder.gtv.setText(msign.name);

        //判断isExpanded就可以控制是按下还是关闭，同时更换图片
//        if(isExpanded){
//            mGroupViewHolder.img_up.setBackgroundResource(R.mipmap.ic_down);
//        }else{
//            mGroupViewHolder.img_up.setBackgroundResource(R.mipmap.ic_up); }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        return getGenericExpandableListView(mSignBeen.get(groupPosition));
    }

    public static class ChildrenViewHolder {
        public TextView ctv;
    }

    public static class GroupViewHolder {
        public TextView gtv;
//    public ImageView img_up;
    }

    /**
     * 返回子ExpandableListView 的对象  此时传入的是该标牌下的所有设备的集合。
     *
     * @param signs
     * @return
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    public ExpandableListView getGenericExpandableListView(SignBean signs) {
        AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        CustomExpandLv view = new CustomExpandLv(context);

        // 加载设备的适配器
        MachineExpandLvAdapter adapter = new MachineExpandLvAdapter(signs.mMachineBeanList, context);
        view.setAdapter(adapter);
        view.setDivider(null);
        view.setGroupIndicator(null);
        view.setPadding(50, 8, 8, 0);
        int groupCount = view.getCount();
        //默认展开所有项
        for (int i = 0; i < groupCount; i++) {
            view.expandGroup(i);
        }
        return view;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }


}
