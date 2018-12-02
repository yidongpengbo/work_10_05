package com.bawei.myapplication.weektest;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.bawei.myapplication.R;

public class TitleBarView extends LinearLayout {
    Context mContext;

    public TitleBarView(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        //添加布局
        View view = View.inflate(mContext, R.layout.title, null);
        final EditText editText = view.findViewById(R.id.edit_title);
        view.findViewById(R.id.search_title).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //第六步：在将要回调的地方，首先判断非空
                if(mOnButtonClickListener != null){
                    //第七步：执行回调方法，传参
                    mOnButtonClickListener.onButtonClick(editText.getText().toString());
                }
            }
        });
        addView(view);
    }

    //第三步：设置成员变量
    OnBuutonClickListener mOnButtonClickListener;

    //第四步：传入，并且给成员变量赋值
    //第五步：在想要接受回调的地方，调用set方法，设置监听，详见WeekTestActivty #Line31
    public void  setButtonClickListener(OnBuutonClickListener onBuutonClickListener){
        mOnButtonClickListener = onBuutonClickListener;
    }

    //第一步：定义一个接口
    public interface OnBuutonClickListener{
        //第二步：写好方法和回传参数
        void onButtonClick(String str);
    }
}
