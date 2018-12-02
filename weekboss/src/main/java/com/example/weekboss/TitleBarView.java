package com.example.weekboss;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class TitleBarView extends LinearLayout{
    Context mCon;
    public TitleBarView(Context context) {
        super(context);
        mCon=context;
        init();
    }

    public TitleBarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mCon=context;
        init();
    }

    private void init() {
        // 添加布局
        View view = View.inflate(mCon, R.layout.title, null);
        //获取资源ID
        ImageView search = view.findViewById(R.id.search);
        final EditText edit = view.findViewById(R.id.edit);
        //搜索的按钮
        search.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                //将输入框的值放入到接口方法中
                String string = edit.getText().toString();
                if (ButtonClickListener!=null){
                    //
                    ButtonClickListener.onButtonClick(string);
                }
            }
        });
            addView(view);
    }

    /**
     * 1.定义接口
     */
    public interface OnButtonClickListener{
       /**
       定义方法和参数
        @param editText
        */
        void onButtonClick(String editText);

    }

    /**
     * 3.设置成员变量
     */
    OnButtonClickListener ButtonClickListener;

    /**
     * 4.调用接口
     */
    public void setOnButtonClickListener(OnButtonClickListener onButtonClickListener) {
        this.ButtonClickListener = onButtonClickListener;
    }



}
