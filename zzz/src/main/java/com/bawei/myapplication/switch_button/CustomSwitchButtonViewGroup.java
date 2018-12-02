package com.bawei.myapplication.switch_button;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.bawei.myapplication.R;

/**
 * @author hasee
 */
public class CustomSwitchButtonViewGroup extends RelativeLayout{
    Context mContext;
    boolean isChecked = false;

    public CustomSwitchButtonViewGroup(Context context) {
        super(context);
        mContext = context;
        init();
    }

    public CustomSwitchButtonViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        init();
    }

    private void init() {
        final ImageView imageView = new ImageView(mContext);
        imageView.setBackgroundResource(R.drawable.off);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isChecked){
                    imageView.setBackgroundResource(R.drawable.off);
                }else{
                    imageView.setBackgroundResource(R.drawable.on);
                }
                isChecked = !isChecked;
            }
        });

        addView(imageView);
    }
}
