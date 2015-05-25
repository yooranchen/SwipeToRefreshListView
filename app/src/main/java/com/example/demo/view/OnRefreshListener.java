package com.example.demo.view;

/**
 * 上啦和下啦刷新
 * Created by ${yooranchen} on 2015/1/6.
 */
public interface OnRefreshListener {

    /**
     * 下啦
     */
    void onRefresh();

    /**
     * 上拉加载更多数据
     */
    void onLoadMoreData();
}
