package com.bawei.myapplication.turntable;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * 这里是画转盘的
 *  @author hasee
 */
public class CustomTurntableView extends View{
    Paint mPaint;
    int mCircleCount = 6;
    float mStartAngle = 0;

    RectF rectF;

    public CustomTurntableView(Context context) {
        super(context);
        init();
    }

    public CustomTurntableView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        mPaint = new Paint();
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        rectF = new RectF();
        rectF.top = 100;
        rectF.left = 100;
        rectF.right = 800;
        rectF.bottom = 800;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(int i = 0; i  <  mCircleCount; i++){
            //按角标单双号设置扇形颜色，
            if(i % 2 == 0 ){
                mPaint.setColor(Color.BLUE);
            }else{
                mPaint.setColor(Color.GREEN);
            }
            canvas.drawArc(rectF, mStartAngle, 60, true, mPaint);

            mStartAngle += 60;
        }
    }
}
