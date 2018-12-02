package com.bawei.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.bawei.myapplication.random.RandomActivity;
import com.bawei.myapplication.scrollandlist.ScrollAndListActivity;
import com.bawei.myapplication.sector_graph.SectorGraphActivity;
import com.bawei.myapplication.switch_button.SwitchButtonActivity;
import com.bawei.myapplication.turntable.CustomTurntableView;
import com.bawei.myapplication.turntable.TurntableActivity;
import com.bawei.myapplication.flow.FlowActivity;
import com.bawei.myapplication.weektest.WeekTestActivity;

/**
 * @author hasee
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CustomTurntableView customTurntableView;
    boolean isTouchInSide = false;
    float mDownX, mDownY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        findViewById(R.id.week).setOnClickListener(this);
        findViewById(R.id.button_turntable).setOnClickListener(this);
        findViewById(R.id.button_sector_graph).setOnClickListener(this);
        findViewById(R.id.button_switch_button).setOnClickListener(this);
        findViewById(R.id.button_random).setOnClickListener(this);
        findViewById(R.id.button_water_fall).setOnClickListener(this);
        findViewById(R.id.scroll_and_list).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        Intent intent = new Intent();
        switch (id) {
            case R.id.week:
                intent.setClass(MainActivity.this, WeekTestActivity.class);
                break;
            case R.id.button_turntable:
                intent.setClass(MainActivity.this, TurntableActivity.class);
                break;
            case R.id.button_sector_graph:
                intent.setClass(MainActivity.this, SectorGraphActivity.class);
                break;
            case R.id.button_switch_button:
                intent.setClass(MainActivity.this, SwitchButtonActivity.class);
                break;
            case R.id.button_random:
                intent.setClass(MainActivity.this, RandomActivity.class);
                break;
            case R.id.button_water_fall:
                intent.setClass(MainActivity.this, FlowActivity.class);
                break;
            case R.id.scroll_and_list:
                intent.setClass(MainActivity.this, ScrollAndListActivity.class);
                break;
            default:
        }
        startActivity(intent);
    }
}
