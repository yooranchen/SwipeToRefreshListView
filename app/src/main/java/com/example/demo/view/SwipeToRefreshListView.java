package com.example.demo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;

/**
 * 嵌套在SwipeRefreshLayout里面的listView,实现上啦和下拉刷新
 * Created by ${yooranchen} on 2015/1/6.
 */
public class SwipeToRefreshListView extends SwipeRefreshLayout
        implements SwipeRefreshLayout.OnRefreshListener {

    public void setOnRefreshListener(com.example.demo.view.OnRefreshListener listener) {
        mListView.setRefreshListener(listener);
    }

    private LoadingListView mListView = new LoadingListView(getContext());

    public SwipeToRefreshListView(Context context) {
        this(context, null);
    }

    public SwipeToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mListView.setParentView(this);
        addView(mListView);
        setOnRefreshListener(this);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mListView.onSwipeToRefresh();
    }

    /**
     * 设置适配器
     */
    public void setAdapter(BaseAdapter adapter) {
        mListView.setAdapter(adapter);
    }

    /**
     * 加载完成
     */
    public void onLoadingCompleted() {
        mListView.onLoadingCompleted();
    }

    /**
     * 设置内容为空时的布局
     *
     * @param emptyView
     */
    public void setEmptyView(View emptyView) {
        mListView.setEmptyView(emptyView);
    }
}
