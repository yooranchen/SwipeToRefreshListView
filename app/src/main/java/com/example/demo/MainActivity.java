package com.example.demo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.view.LoadingListView;
import com.example.demo.view.OnRefreshListener;
import com.example.demo.view.SwipeToRefreshListView;

public class MainActivity extends Activity implements OnRefreshListener {

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            count += 20;
            array = new int[count];
            mAdapter.notifyDataSetChanged();
            Log.e("", "array>>" + array.length);
            mSwipeToRefreshListView.onLoadingCompleted();
        }
    };
    private SwipeToRefreshListView mSwipeToRefreshListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mSwipeToRefreshListView = (SwipeToRefreshListView) findViewById(R.id.swipeListView);
        mSwipeToRefreshListView.setOnRefreshListener(this);
        mAdapter = new MyAdapter();
        mSwipeToRefreshListView.setAdapter(mAdapter);
    }

    int count = 20;
    private int array[] = new int[count];
    private MyAdapter mAdapter;

    @Override
    public void onRefresh() {
        Toast.makeText(this, "下拉", Toast.LENGTH_SHORT).show();
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    @Override
    public void onLastItemVisible() {
        Toast.makeText(this, "上啦", Toast.LENGTH_SHORT).show();
        handler.sendEmptyMessageDelayed(1, 2000);
    }

    class MyAdapter extends BaseAdapter {
        public int getCount() {
            return array.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = getLayoutInflater().inflate(
                        android.R.layout.simple_list_item_1, parent, false);
                holder.text = (TextView) convertView.findViewById(android.R.id.text1);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.text.setText(position + 1 + "行");
            return convertView;
        }

        class ViewHolder {
            TextView text;
        }
    }
}
