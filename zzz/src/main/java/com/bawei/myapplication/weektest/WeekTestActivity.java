package com.bawei.myapplication.weektest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.bawei.myapplication.R;

import java.util.UUID;

public class WeekTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_week_test);

        init();
    }

    private void init(){
        final WeekFlowLayout fl_search = findViewById(R.id.fl_search);
        WeekFlowLayout fl_hot = findViewById(R.id.fl_hot);

        TitleBarView title = findViewById(R.id.title);
        title.setButtonClickListener(new TitleBarView.OnBuutonClickListener() {
            @Override
            public void onButtonClick(final String str) {
                // 随机字符串，当作唯一标示
                UUID uuid = UUID.randomUUID();
                Log.i("dj", "创建时的UUID：" + uuid + " ,字符串是：" + str);
                TextView tv = new TextView(WeekTestActivity.this);
                tv.setTag(uuid);
                tv.setTextColor(Color.RED);
                tv.setText(str);
                tv.setBackgroundResource(R.drawable.edit_bg);
                fl_search.addView(tv);

                tv.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String uuid = String.valueOf(v.getTag());
                        Log.i("dj", "点击时的UUID：" + uuid + " ,字符串是：" + str);
                    }
                });
            }
        });

        for(int i = 0; i < 30; i++){
            TextView tv = new TextView(WeekTestActivity.this);
            tv.setText("数据 " + i);
            tv.setTextColor(Color.RED);
            tv.setBackgroundResource(R.drawable.edit_bg);
            fl_hot.addView(tv);
        }
    }
}
