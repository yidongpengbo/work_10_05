package com.bawei.myapplication.gesture;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 这里是手势拖动
 * @author hasee
 */
public class CustomGestureView extends View{
    Paint mPaint;
    float mTouchX = 300, mTouchY = 300, mCircleRadius = 50;

    public CustomGestureView(Context context) {
        super(context);
        init();
    }

    public CustomGestureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setStyle(Paint.Style.FILL);

        //监听touch事件
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //获取点击位置
                mTouchX = event.getX();
                mTouchY = event.getY();

                //刷新view
                invalidate();

                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画圆
        //第一个参数，圆心x轴位置
        //第二个参数，圆心y轴位置
        //第三个参数，圆形半径
        //第四个参数，画笔
        canvas.drawCircle(mTouchX, mTouchY, mCircleRadius, mPaint);
    }
}
