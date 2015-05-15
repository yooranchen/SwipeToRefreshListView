package com.example.demo.view;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

/**
 * 嵌套在SwipeRefreshLayout里面的listView,实现上啦和下拉刷新
 * Created by ${yooranchen} on 2015/1/6.
 */
public class SwipeToRefreshListView extends SwipeRefreshLayout
        implements SwipeRefreshLayout.OnRefreshListener {

    public void setOnRefreshListener(com.example.demo.view.OnRefreshListener listener) {
        mInnerListView.setRefreshListener(listener);
    }

    private LoadingListView mInnerListView;

    public SwipeToRefreshListView(Context context) {
        this(context, null);
    }

    public SwipeToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mInnerListView = new LoadingListView(getContext());
        addView(mInnerListView);
        setOnRefreshListener(this);
    }

    /**
     * 下拉刷新
     */
    @Override
    public void onRefresh() {
        mInnerListView.onSwipeToRefresh();
    }

    /**
     * 设置适配器
     */
    public void setAdapter(BaseAdapter adapter) {
        mInnerListView.setAdapter(adapter);
    }

    /**
     * 加载完成
     */
    public void onLoadingCompleted() {
        mInnerListView.onLoadingCompleted();
    }

    /**
     * 设置内容为空时的布局
     *
     * @param emptyView
     */
    public void setEmptyView(View emptyView) {
        mInnerListView.setEmptyView(emptyView);
    }

    /**
     * 添加HeadView
     *
     * @param headView
     */
    public void addHeaderView(View headView) {
        mInnerListView.addHeaderView(headView);
    }

    /**
     * 添加FootView
     *
     * @param footView
     */
    public void addFootView(View footView) {
        mInnerListView.addFooterView(footView);
    }

    /**
     * 行布局点击监听
     *
     * @param onItemCLickListener
     */
    public void setOnItemCLickListener(
            AdapterView.OnItemClickListener onItemCLickListener) {
        mInnerListView.setOnItemClickListener(onItemCLickListener);
    }

    /**
     * 长按点击
     *
     * @param onItemLongClickListener
     */
    public void setOnItemLongClickListener(
            AdapterView.OnItemLongClickListener onItemLongClickListener) {
        mInnerListView.setOnItemLongClickListener(onItemLongClickListener);
    }
}
