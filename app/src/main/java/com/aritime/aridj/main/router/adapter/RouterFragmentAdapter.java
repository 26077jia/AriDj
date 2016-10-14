package com.aritime.aridj.main.router.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jiajia on 2016/10/13.
 */

public class RouterFragmentAdapter extends RecyclerView.Adapter<RouterFragmentAdapter.RouterVH>{
    private List<String> dataList;
    private Context context;

    public RouterFragmentAdapter(Context context, ArrayList<String> dataList) {
        this.context = context;
       // this.dataList = dataList;
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public int getItemCount() {
        return 0;
       // return dataList.size();
    }

    @Override
    public void onBindViewHolder(RouterVH holder, int position) {
        //holder.tv.setTexr(dataList.get(postion).getNum())
    }

    @Override
    public RouterVH onCreateViewHolder(ViewGroup parent, int viewType) {

        return  new RouterVH(View.inflate(context,android.R.layout.simple_list_item_2,null));//设置列表项的样式
    }

    public static class RouterVH extends RecyclerView.ViewHolder{
        //TextView tv ;
        public RouterVH(View itemView) {
            super(itemView);
            //tv= (TextView)itemView.findViewById()
        }
    }
}
