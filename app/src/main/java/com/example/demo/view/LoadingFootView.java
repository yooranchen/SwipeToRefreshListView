package com.example.demo.view;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.demo.R;

/**
 * FootView
 * Created by yooranchen on 15/5/25.
 */
public class LoadingFootView extends LinearLayout {

    //加载中
    private TextView mLoadingTextView;
    //进度条圆圈
    private ProgressBar mProgressBar;
    private String mLoading, mLoadToEnd;

    public LoadingFootView(Context context) {
        super(context);
        mLoading = getResources().getString(R.string.loading);
        mLoadToEnd = getResources().getString(R.string.load_to_end);
        mLoadingTextView = new TextView(context);
        mLoadingTextView.setText("\t\t" + mLoading);
        mProgressBar = new ProgressBar(context);
        //内边距
        //横向
        setOrientation(HORIZONTAL);
        //居中
        setGravity(Gravity.CENTER);
        addView(mProgressBar);
        addView(mLoadingTextView);
        int padding = dip2px(context, 8);
        setPadding(padding, padding, padding, padding);
    }


    public ProgressBar getProgressBar() {
        return mProgressBar;
    }

    public TextView getLoadingTextView() {
        return mLoadingTextView;
    }

    public void setHasMoreData(boolean hasMoreData) {
        if (hasMoreData) {
            mProgressBar.setVisibility(View.VISIBLE);
            mLoadingTextView.setText(mLoading);
        } else {
            mProgressBar.setVisibility(View.GONE);
            mLoadingTextView.setText("\t\t" + mLoadToEnd);
        }
    }

    /**
     * 将dip或dp值转换为px值，保证尺寸大小不变
     *
     * @return
     */
    public static int dip2px(Context context, float dpValue) {
        try {
            final float scale = context.getResources().getDisplayMetrics().density;
            return (int) (dpValue * scale + 0.5f);
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param spValue
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }
}
