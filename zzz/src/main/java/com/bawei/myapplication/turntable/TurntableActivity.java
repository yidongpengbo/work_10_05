package com.bawei.myapplication.turntable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.RotateAnimation;

import com.bawei.myapplication.R;
import com.bawei.myapplication.turntable.CustomTurntableView;

/**
 * 转盘
 * @author hasee
 */
public class TurntableActivity extends AppCompatActivity {

    CustomTurntableView customTurntableView;
    boolean isTouchInSide = false;
    float mDownX, mDownY;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_turntable);

        initView();
    }

    private void initView() {
        customTurntableView = findViewById(R.id.custom);
//        findViewById(R.id.custom_inside).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                float degrees =  (float)(720 + Math.random() * 1000);
//                RotateAnimation rotateAnimation = new RotateAnimation(0, -degrees, 450, 450);
//                rotateAnimation.setDuration(5000);
//                rotateAnimation.setFillAfter(true);
//                customCircleView.startAnimation(rotateAnimation);
//            }
//        });

        findViewById(R.id.custom_inside).setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN &&
                        event.getX() > 300 &&
                        event.getX() < 600 &&
                        event.getY() > 300 &&
                        event.getY() < 600) {
                    isTouchInSide = true;
                    mDownX = event.getX();
                    mDownY = event.getY();
                    return true;
                }else if(event.getAction() == MotionEvent.ACTION_MOVE && (
                        event.getX() < mDownX -10 ||
                        event.getX() > mDownX + 10 ||
                        event.getY() < mDownY -10 ||
                        event.getY() > mDownY + 10) ){
                    isTouchInSide = false;
                } else if (event.getAction() == MotionEvent.ACTION_UP &&
                        event.getX() > mDownX -10 &&
                        event.getX() < mDownX + 10 &&
                        event.getY() > mDownY -10 &&
                        event.getY() < mDownY + 10 &&
                        isTouchInSide) {
                    float degrees = (float) (720 + Math.random() * 1000);
                    RotateAnimation rotateAnimation = new RotateAnimation(0, -degrees, 450, 450);
                    rotateAnimation.setDuration(5000);
                    rotateAnimation.setFillAfter(true);
                    customTurntableView.startAnimation(rotateAnimation);
                }
                isTouchInSide = false;
                return false;
            }
        });
    }
}
