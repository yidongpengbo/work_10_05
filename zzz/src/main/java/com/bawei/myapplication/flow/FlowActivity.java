package com.bawei.myapplication.flow;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.bawei.myapplication.R;
import com.bawei.myapplication.weektest.WeekFlowLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布流
 *
 * @author hasee
 */
public class FlowActivity extends AppCompatActivity {
    List<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);
        initView();
    }

    private void initView() {
        final EditText editText = findViewById(R.id.edit);
        final FlowLayout flowLayout = findViewById(R.id.water_fall);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框文字
                String str = editText.getText().toString();
                // 将文字放入列表
                strList.add(str);
                // 设置数据
                flowLayout.setData(strList);
            }
        });
    }
}
