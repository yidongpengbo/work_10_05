package com.bawei.myapplication.waterfall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.bawei.myapplication.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 瀑布流
 * @author hasee
 */
public class WaterFallActivity extends AppCompatActivity {
    List<String> strList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water_fall);
        initView();
    }

    private void initView() {
        final EditText editText = findViewById(R.id.edit);
        final CustomWaterFallViewGroup customWaterFallViewGroup = findViewById(R.id.water_fall);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 获取输入框文字
                String str = editText.getText().toString();
                // 将文字放入列表
                strList.add(str);
                // 设置数据
                customWaterFallViewGroup.setData(strList);
            }
        });
    }
}
