package com.example.weekboss;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * @author ss
 *      搜索历史、热门搜索
 */
@SuppressLint("AppCompatCustomView")
public class WeekGroupNameLayout extends TextView {
    public WeekGroupNameLayout(Context context) {
        super(context);
    }

    public WeekGroupNameLayout(Context context,  @Nullable AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.WeekGroupNameLayout);
        int color = typedArray.getColor(R.styleable.WeekGroupNameLayout_textColor, Color.GRAY);
        setTextColor(color);
        //最后要回收
        typedArray.recycle();


    }
}
