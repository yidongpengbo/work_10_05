package com.bawei.myapplication.scrollandlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.myapplication.R;

import java.util.List;

public class ScrollAndListAdapter extends BaseAdapter {

    private List<String> mList;
    private Context mContext;

    public ScrollAndListAdapter(Context context, List<String> list) {
        this.mContext = context;
        mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_scroll_and_list, null);

            viewHolder.tv = convertView.findViewById(R.id.tv_item_scroll_and_list);

            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.tv.setText(mList.get(position));

        return convertView;
    }

    private class ViewHolder{
        TextView tv;
    }
}
