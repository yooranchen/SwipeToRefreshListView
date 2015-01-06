package com.example.demo;

/**
 * 上啦和下啦刷新
 * Created by ${CaiShi} on 2015/1/6.
 */
public interface OnRefreshListener {

    /**
     * 下啦
     */
    void onRefresh();

    /**
     * 上啦加载更多
     */
    void onLastItemVisible();
}
