package com.aritime.aridj.main.router.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aritime.aridj.R;
import com.aritime.aridj.main.router.bean.Routerbean;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by jiajia on 2016/10/13.
 */

public class RouterFragmentAdapter extends RecyclerView.Adapter<RouterFragmentAdapter.RouterVH> {
    private Context context;
    private List<Routerbean> routerBeanList;

    public RouterFragmentAdapter(Context context, ArrayList<Routerbean> routerBeanList) {
        this.context = context;
        this.routerBeanList = routerBeanList;
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public int getItemCount() {
        return routerBeanList.size();
    }

    @Override
    public void onBindViewHolder(RouterVH holder, int pos) {
        int routerCheckCounts = Integer.parseInt(routerBeanList.get(pos).getSignCheckCounts());
        int routerCounts = Integer.parseInt(routerBeanList.get(pos).getSignCounts());
        if (routerCheckCounts == routerCounts) {// 检测项全部完成文本颜色设置为高亮
            holder.tv_sign_check_count.setTextColor(Color.parseColor("#37cdcd"));
        } else if (routerCheckCounts > routerCounts) {
            //TODO 标牌个数出错
        }

        holder.tv_router.setText(routerBeanList.get(pos).getRouterName());//匹配路线名
        holder.tv_sign_check_count.setText(routerBeanList.get(pos).getSignCheckCounts() + "/");//已检标牌的个数
        holder.tv_sign_counts.setText(routerBeanList.get(pos).getSignCounts());

    }


    @Override
    public RouterVH onCreateViewHolder(ViewGroup parent, int viewType) {
        RouterVH holder = new RouterVH(LayoutInflater.from(context).inflate(R.layout.lv_router_item, parent, false));
        return holder;//设置列表项的样式
    }

    public static class RouterVH extends RecyclerView.ViewHolder {
        TextView tv_router;
        TextView tv_sign_check_count;
        TextView tv_sign_counts;

        public RouterVH(View itemView) {
            super(itemView);
            tv_router = (TextView) itemView.findViewById(R.id.tv_router_name);
            tv_sign_check_count = (TextView) itemView.findViewById(R.id.tv_sign_check_count);
            tv_sign_counts = (TextView) itemView.findViewById(R.id.tv_sign_counts);
        }
    }
}
