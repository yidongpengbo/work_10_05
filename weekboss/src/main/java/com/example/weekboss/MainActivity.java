package com.example.weekboss;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.weekboss.SQlite.DaoSqlite;

import java.util.UUID;

public class MainActivity extends AppCompatActivity {
    /**
     * 定义变量:
     *    TitleBarView继承linearLayout
     */
    TitleBarView titleBar;
    WeekFlowLayout flow_search,flow_hot;


    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /**
         * 获取资源ID
         */
        titleBar=findViewById(R.id.title);
        flow_search=findViewById(R.id.flow_search);
        flow_hot=findViewById(R.id.flow_hot);

        init();

    }

    private void init() {
        //搜索的接口回调
        titleBar.setOnButtonClickListener(new TitleBarView.OnButtonClickListener() {
            @Override
            public void onButtonClick(String editText) {
                //添加到数据库
                DaoSqlite.getDaoSqlite(MainActivity.this).add(editText);
                //随机字符串，当做唯一标识符
                UUID uuid = UUID.randomUUID();
                //建立文本布局
                TextView view = new TextView(MainActivity.this);
                view.setText(editText);
                view.setTag(uuid);
                flow_search.addView(view);
                //文本的点击事件
                view.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String value = String.valueOf(v.getTag());
                        Toast.makeText(MainActivity.this,value,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
        /**
         * 热门搜索
         */
    int mCount=30;
        for (int i = 0; i <mCount ; i++) {
                TextView view=new TextView(MainActivity.this);
                view.setText("数据"+i);
                flow_hot.addView(view);
        }



    }
}
