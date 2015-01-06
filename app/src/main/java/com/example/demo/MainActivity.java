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

public class MainActivity extends Activity implements OnRefreshListener {

    private Handler handler = new Handler() {
        public void handleMessage(android.os.Message msg) {
            count += 20;
            array = new int[count];
            mAdapter.notifyDataSetChanged();
            Log.e("", "array>>" + array.length);
            mRefreshbleView.onLoadingCompleted();
        }
    };
    private LoadingListView mRefreshbleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SwipeToRefreshListView sl = (SwipeToRefreshListView) findViewById(R.id.swipeListView);
        sl.setOnRefreshListener(this);
        mRefreshbleView = sl.getRefrshbleView();
        mAdapter = new MyAdapter();
        mRefreshbleView.setAdapter(mAdapter);
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
            View layout = getLayoutInflater().inflate(
                    android.R.layout.simple_list_item_1, parent, false);
            TextView text = (TextView) layout.findViewById(android.R.id.text1);
            text.setText(position + 1 + "行");
            return layout;
        }
    }
}
