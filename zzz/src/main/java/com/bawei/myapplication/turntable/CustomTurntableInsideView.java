package com.bawei.myapplication.turntable;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.bawei.myapplication.R;

/**
 * 转盘中间开始按钮和指针
 * @author hasee
 */
public class CustomTurntableInsideView extends View {
    /**
     * 画笔
     */
    Paint mPaint;
    RectF mRectF;
    String mStr;

    public CustomTurntableInsideView(Context context) {
        super(context);
        init();
    }

    public CustomTurntableInsideView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

        //自定义属性，如何添加自定义属性如下（考点）
        //第一步：在values文件夹下创建attrs.xml
        //第二步：详见attrs.xml文件内部
        //第三步：在所在的布局文件的根layout中添加xmlns:app="http://schemas.android.com/apk/res-auto"
        //第四步：在布局文件的控件中添加app:"你在attrs中设置的attr name"="你的值"
        //第五步：调用下面这句话，最后的为R.styleable.你在attrs中设置的declare-styleable name
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomTurntableView);
        //第六步：调用下面这句话，根据你在attrs中设置的format，选择getXXX方法，
        //入参为 R.styleable. 加上 你在attrs中设置的declare-styleable name 加上 _ 加上 你在attrs中设置的attr name
        mStr = typedArray.getString(R.styleable.CustomTurntableView_text);
        init();
    }

    private void init() {
        //以下注释请看CustomBingView里面
        mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(10);
        mPaint.setTextSize(60);
        mPaint.setStyle(Paint.Style.FILL);

        mRectF = new RectF();
        mRectF.top = 100;
        mRectF.bottom = 400;
        mRectF.right = 550;
        mRectF.left = 350;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//        setMeasuredDimension(300, 300);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //设置画笔颜色为黑色，
        mPaint.setColor(Color.BLACK);
        //画出指针，用一个扇形，然后盖住后面补分来简单表示
        canvas.drawArc(mRectF, 60, 60, true, mPaint);

        mPaint.setColor(Color.RED);
        //画一个红色的圆形，就是中间的大按钮
        canvas.drawCircle(450, 450, 150, mPaint);

        mPaint.setColor(Color.BLACK);
        //添加按钮上的文字
        canvas.drawText(mStr, 400, 450, mPaint);

        //画三角，第一步，创建路径
//        Path path = new Path();
        //第二步，moveTo第一个顶点
//        path.moveTo(300, 300);
        //后续相继lineTo其他顶点
//        path.lineTo(300, 400);
//        path.lineTo(400, 400);
        //闭合
//        path.close();
//      画
//        canvas.drawPath(path, mPaint);
    }
}
