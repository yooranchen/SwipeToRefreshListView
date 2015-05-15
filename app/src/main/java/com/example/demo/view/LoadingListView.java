package com.example.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.example.demo.view.SwipeToRefreshListView;

/**
 * 下拉刷新内部ListView
 * Created by ${yooranchen} on 2015/1/6.
 */
public class LoadingListView extends ListView implements OnScrollListener {

    private SwipeToRefreshListView mParent;
    //上下拉刷新加载监听
    private OnRefreshListener listener;

    public LoadingListView(Context context) {
        this(context, null);
    }

    public LoadingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /* 添加滑动监听 */
        this.setOnScrollListener(this);
    }

    /**
     * 标记是否整个在刷新数据
     */
    private boolean isRefresh;

    /**
     * 标记是否在刷新
     */
    private boolean isLoadingComplete = true;

    /**
     * 设置刷新完成
     */
    public void onLoadingCompleted() {
        mLastItemVisible = false;
        isLoadingComplete = true;
        isRefresh = false;//设置在刷新
        mParent.setRefreshing(false);
    }

    /**
     * 最后一行是否可见
     */
    private boolean mLastItemVisible;

    private void setRefreshing() {
        mParent.setRefreshing(true);
        if (listener != null) {
            listener.onLastItemVisible();
        }
        isRefresh = true;//设置在刷新
        mLastItemVisible = true;
        isLoadingComplete = false;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int state) {
        if (!isRefresh && state == OnScrollListener.SCROLL_STATE_IDLE
                && null != listener && mLastItemVisible) {
            if (isLoadingComplete) {
                isLoadingComplete = false;
                setRefreshing();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (!isRefresh && null != listener) {
            mLastItemVisible = (totalItemCount > 0)
                    && (firstVisibleItem + visibleItemCount >= totalItemCount - 1);
        }
    }

    public void onSwipeToRefresh() {
        isRefresh = true;
        listener.onRefresh();
    }

    public void setParentView(SwipeToRefreshListView swipeToRefreshListView) {
        this.mParent = swipeToRefreshListView;
    }

    public void setRefreshListener(OnRefreshListener listener) {
        this.listener = listener;
    }

}
