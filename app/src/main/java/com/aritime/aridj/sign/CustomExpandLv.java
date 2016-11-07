package com.aritime.aridj.sign;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ExpandableListView;

/**
 *
 * 自定义ExpandableListView 解决嵌套之下显示不全的问题
 * Created by MH on 2016/6/16.
 */
public class CustomExpandLv extends ExpandableListView {


    public CustomExpandLv(Context context) {
        super(context);
    }

    public CustomExpandLv(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public CustomExpandLv(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        // 解决显示不全的问题
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2
                , MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}