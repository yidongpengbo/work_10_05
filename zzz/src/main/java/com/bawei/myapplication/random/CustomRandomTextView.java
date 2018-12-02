package com.bawei.myapplication.random;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * @author hasee
 */
@SuppressLint("AppCompatCustomView")
public class CustomRandomTextView extends TextView {
    public CustomRandomTextView(Context context) {
        super(context);
        init();
    }

    public CustomRandomTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        changeText();
        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                changeText();
            }
        });
    }

    int i = 0;

    private void changeText(){
        setText(String.valueOf(getRandom()));
        if(i % 2 == 0){
            setBackgroundColor(Color.BLACK);
        }else{
            setBackgroundColor(Color.RED);
        }

        i++;
    }

    private int getRandom(){
        //获取随机数Math.random()，取值范围[0, 1);
        //所有*9000后取值范围 [0, 9000)
        //最后加上1000，范围[1000, 10000)
       return (int)(Math.random() * 9000 + 1000);
    }
}
