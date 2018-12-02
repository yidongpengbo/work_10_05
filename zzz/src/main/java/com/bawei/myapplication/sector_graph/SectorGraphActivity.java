package com.bawei.myapplication.sector_graph;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bawei.myapplication.R;

public class SectorGraphActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector_graph);

        initView();
    }

    private void initView() {
        //饼图的角度数组
        //这里只是模拟数据，通常情况下，我们需要计算出每一个模块的百分比，然后计算出在整圆（360度）中所占的角度
        float[] angles = new float[]{100, 60, 100, 50, 20, 30};
        CustomSectorGraphView customSectorGraphView = findViewById(R.id.bing);
        customSectorGraphView.setData(angles);
        customSectorGraphView.invalidate();

        customSectorGraphView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(SectorGraphActivity.this, "click", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
