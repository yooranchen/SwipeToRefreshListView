package com.example.demo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.widget.BaseAdapter;

/**
 * 嵌套在SwipeRefreshLayout里面的listView,实现上啦和下拉刷新
 * Created by ${yooranchen} on 2015/1/6.
 */
public class SwipeToRefreshListView extends SwipeRefreshLayout implements SwipeRefreshLayout.OnRefreshListener {

    private com.example.demo.view.OnRefreshListener listener;

    public void setOnRefreshListener(com.example.demo.view.OnRefreshListener listener) {
        this.listener = listener;
        listView.setRefreshListener((com.example.demo.view.OnRefreshListener) listener);
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

    /*®
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
