package com.example.demo.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

/**
 * 下拉刷新内部ListView
 * Created by ${yooranchen} on 2015/1/6.
 */
public class LoadingListView extends ListView implements OnScrollListener {

    private SwipeToRefreshListView mParent;
    //上下拉刷新加载监听
    private OnRefreshListener listener;

    /**
     * 是否还有更多数据
     */
    private boolean hasMoreData = true;
    /**
     * 底部自动加载布局
     */
    private LoadingFootView mFootView;

    public LoadingListView(Context context) {
        this(context, null);
    }

    public LoadingListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        /* 添加滑动监听 */
        this.setOnScrollListener(this);
        mFootView = new LoadingFootView(context);
        addFooterView(mFootView);
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
    }

    /**
     * 最后一行是否可见
     */
    private boolean mLastItemVisible;

    /**
     * 自动加载更多
     */
    private void loadMoreData() {
        if (listener != null) {
            listener.onLoadMoreData();
        }
        isRefresh = true;//设置在刷新
        mLastItemVisible = true;
        isLoadingComplete = false;
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int state) {
        if (!isRefresh && state == OnScrollListener.SCROLL_STATE_IDLE
                && null != listener && mLastItemVisible) {
            if (isLoadingComplete && hasMoreData) {
                isLoadingComplete = false;
                loadMoreData();
            }
        }
    }

    @Override
    public void onScroll(AbsListView view, int firstVisibleItem,
                         int visibleItemCount, int totalItemCount) {
        if (!isRefresh && null != listener && hasMoreData) {
            mLastItemVisible = (totalItemCount > 0)
                    && (firstVisibleItem + visibleItemCount >= totalItemCount - 1);
        }
    }

    public void onRefresh() {
        isRefresh = true;
        listener.onRefresh();
    }

    public void setParentView(SwipeToRefreshListView swipeToRefreshListView) {
        this.mParent = swipeToRefreshListView;
    }

    public void setRefreshListener(OnRefreshListener listener) {
        this.listener = listener;
    }

    /**
     * 设置是否是最后一行
     *
     * @param hasMoreData
     */
    public void setHasMoreData(boolean hasMoreData) {
        this.hasMoreData = hasMoreData;
        mFootView.setHasMoreData(hasMoreData);
    }
}
