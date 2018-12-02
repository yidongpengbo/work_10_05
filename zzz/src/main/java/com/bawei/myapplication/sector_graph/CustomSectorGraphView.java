package com.bawei.myapplication.sector_graph;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.myapplication.R;

/**
 * 画饼图的view
 * @author hasee
 */
public class CustomSectorGraphView extends View{
    /**
     * 记录传入的角度
     */
    float[] mAngles;
    /**
     * 位置控制
     */
    RectF mRectF;

    /**
     * 画笔
     */
    Paint mPaint;

    /**
     * 起始角度
     */
    float mStartAngle = 0;

    Context mContext;

    int mWidth, mHeight;

    public CustomSectorGraphView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomSectorGraphView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(mWidth, mHeight);
    }

    /**
     * 设置每个扇形角度
     * @param angles 角度数组
     */
    public void setData(float[] angles){
        mAngles = angles;
    }

    /**
     * 初始化
     */
    private void init() {
        //初始化画笔
        mPaint = new Paint();
        //设置画笔颜色为蓝色
        mPaint.setColor(Color.BLUE);
        //设置宽度
        mPaint.setStrokeWidth(10);
        //设置填充模式
        mPaint.setStyle(Paint.Style.FILL);


        mWidth = mContext.getResources().getDimensionPixelOffset(R.dimen.circle_width);
        mHeight = mContext.getResources().getDimensionPixelOffset(R.dimen.circle_height);

        //设置上下左右位置
        mRectF = new RectF();
        mRectF.top = 0;
        mRectF.bottom = mRectF.top + mHeight;
        mRectF.right = mRectF.left + mWidth;
        mRectF.left = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i  <  mAngles.length; i++){
            if(i % 2 == 0 ){
                //角标为双数时，设置画笔颜色为蓝色
                mPaint.setColor(Color.BLUE);
            }else{
                //角标为单数时，设置画笔颜色为绿色
                mPaint.setColor(Color.GREEN);
            }

            //画扇形
            //第一个参数，位置信息
            //第二个参数，起始角度
            //第三个参数，从起始角度开始，顺时针旋转角度
            //第四个参数，是否延申到圆心
            //第五个参数，画笔
            canvas.drawArc(mRectF, mStartAngle, mAngles[i], true, mPaint);

            //下一个扇形的起始角度 = 本次扇形起始角度 + 本次扇形旋转角度
            mStartAngle += mAngles[i];
        }
    }
}
