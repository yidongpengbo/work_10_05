package com.example.weekboss;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;

/**
 * @author lenovo
 *      根据文本宽高确定流式布局
 */
public class WeekFlowLayout extends LinearLayout {
    public WeekFlowLayout(Context context) {
        super(context);
    }

    public WeekFlowLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }
    /**
     * 定义文本的宽和所有文本中最大的高
     * 定义文本左右间隔、上下间隔
     * 屏幕初始位置
     */
    int mWidthText, mMaxHeight;
    int mHSpace=20,mVSpace=20;
    int left=0,top=0;

    /**
     * 第一步：计算出文本最大高
     */
    public void FindMaxHeight(){
        //1.得到所有的文本
        int childCount = getChildCount();
        //2.定义初始的文本高为0
        mMaxHeight=0;
        for (int i = 0; i <childCount; i++) {
                //3.得到选中的当前文本的视图
            View view = getChildAt(i);
            if (view.getMeasuredHeight()>mMaxHeight){
               mMaxHeight=view.getMeasuredHeight();
            }
        }
    }

    /**
     * 第二步：得到屏幕允许的最大宽高、
     *        得到子布局（每行）允许的最大宽高：确保每个子布局只会有一行字
     *        得到换行的情况
     *        确定屏幕实际宽高
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //得到屏幕允许最大宽高
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        //得到子布局（每行）的允许宽高
        measureChildren(widthMeasureSpec,heightMeasureSpec);

        //1.得到文本的宽高
        FindMaxHeight();
        int left=0,top=0;
        //2.得到所有的文本
        int childCount = getChildCount();
        for (int i = 0; i <childCount ; i++) {
            //3.得到文本视图
            View view = getChildAt(i);
            if (left!=0){
                if ((left+view.getMeasuredWidth())>widthSize){
                    top+=mMaxHeight+mVSpace;
                    left=0;
                }
            }
            left+=view.getMeasuredWidth()+mHSpace;
        }
    setMeasuredDimension(widthSize,(top+mMaxHeight)>heightSize?heightSize:(top+mMaxHeight));

    }

    /**
     *  文本布局
     * @param changed
     * @param l
     * @param t
     * @param r
     * @param b
     */

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        //1.指定屏幕起始位置
        int left=0,top=0;
        //2.得到文本的高
        FindMaxHeight();
        //3.得到所有文本
        int childCount = getChildCount();
        for (int i = 0; i <childCount ; i++) {
         //4.得到指定的当前文本视图
            View view = getChildAt(i);
            if (left!=0){
                if ((left+view.getMeasuredWidth())>getWidth()){
                    top+=mMaxHeight+mVSpace;
                    left=0;
                }
            }
            //定义当前文本的位置
            view.layout(left,top,left+view.getMeasuredWidth(),top+mMaxHeight);
            left+=view.getMeasuredWidth()+mHSpace;
        }



    }
}
