package com.example.demo;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.BaseAdapter;

/**
 * Created by ${CaiShi} on 2015/1/6.
 */
public class SwipeToRefreshListView extends SwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {

    private com.example.demo.OnRefreshListener listener;

    public void setOnRefreshListener(com.example.demo.OnRefreshListener listener) {
        this.listener = listener;
        listView.setRefreshListener(listener);
    }

    private LoadingListView listView = new LoadingListView(getContext());

    public SwipeToRefreshListView(Context context) {
        this(context, null);
    }

    public SwipeToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        listView.setParentView(this);
        addView(listView);
        setOnRefreshListener(this);
    }

    @Override
    public void onRefresh() {
        listView.onSwipeToRefresh();
    }

    /**
     * 获取listview
     */
    public LoadingListView getRefrshbleView() {
        return listView;
    }

    /**
     * 设置适配器
     */
    public void setAdapert(BaseAdapter adapert) {
        listView.setAdapter(adapert);
    }
}
