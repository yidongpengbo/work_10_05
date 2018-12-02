package com.bawei.myapplication.waterfall;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bawei.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * @author hasee
 */
public final class CustomWaterFallViewGroup extends LinearLayout{
    /**
     *   每行最大允许字符串商都
     */

    final int mMaxSize = 22;
    /**
     *     传入的字符串数组
      */
    List<String> stringList = new ArrayList<>();
    Context mContext;

    public CustomWaterFallViewGroup(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomWaterFallViewGroup(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        // 设置最外层的LinearLayout为垂直布局
        setOrientation(VERTICAL);
    }


    public void setData(List<String> stringList){
        // 直接用新的列表，重新绘制
        this.stringList = stringList;
        showData();
    }

    public void showData(){
        //因为每一次都要新画，所以移除以前所有的布局
        removeAllViews();
        // 优先向根布局添加一条横向布局
        LinearLayout linearLayout_h = (LinearLayout) View.inflate(mContext, R.layout.item_water_fall_h, null);
        addView(linearLayout_h);

        // 定义临时变量，用来计算最后一行已有的字符串长度
        int len = 0;

        //遍历
        for(String str: stringList){
            // 将此字符串长度与记录的已有字符串长度相加
            len += str.length();
            // 如果长度大于规定最大长度，说明这一行放不下了，需要换行
            if(len > mMaxSize){
                // 向根布局添加一条横向布局
                linearLayout_h = (LinearLayout) View.inflate(mContext, R.layout.item_water_fall_h, null);
                addView(linearLayout_h);
                // 因为换行，所以这一个字符串长度就是最后一行长度
                len = str.length();
            }

            // 添加TextView,并赋值
            View view = View.inflate(mContext, R.layout.item_water_fall, null);
            TextView textView = view.findViewById(R.id.tv_item_water_fall);
            textView.setText(str);
            linearLayout_h.addView(view);

            // 设置权重，让每一行内所有控件相加充满整行，并合理分配
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams)view.getLayoutParams();
            layoutParams.weight = 1;
            view.setLayoutParams(layoutParams);
        }
    }
}
