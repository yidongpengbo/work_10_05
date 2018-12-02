package com.bawei.myapplication.scrollandlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.bawei.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class ScrollAndListActivity extends AppCompatActivity {

    CustomListViewInScrollView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_and_list);
        init();
        showData();
    }

    private void init() {
        mListView = findViewById(R.id.list);
    }

    private void showData(){
        List<String> stringList = new ArrayList<>();
        for(int i = 0; i < 100; i++){
            stringList.add("string " + i);
        }

        ScrollAndListAdapter scrollAndListAdapter = new ScrollAndListAdapter(this, stringList);
        mListView.setAdapter(scrollAndListAdapter);
    }
}
