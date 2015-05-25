##	通过使用SwipeRefreshLayout实现简单的下拉刷新
控件实现下拉刷新(onRefresh回调),最后一行可见时自动加载更多(onLoadMoreData回调)
***
*	使用>>布局文件中使用
````
	<com.example.demo.SwipeToRefreshListView
        	android:id="@+id/swipeListView"
        	android:layout_width="match_parent"
        	android:layout_height="match_parent" />
````        
*	为ListView设置适配器,通过SwipeToRefreshListView获取内部的ListView对象
````
	SwipeToRefreshListView sl = (SwipeToRefreshListView) findViewById(R.id.swipeListView);
	sl.setOnRefreshListener(this);
	//ListView适配器,用法同一般的ListView
	MyAdapter mAdapter = new MyAdapter();
	sl.setAdapter(mAdapter);

````
###	源码分析
####	A.构造方法

````
	public SwipeToRefreshListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        //初始化内部的上拉加载工多ListView
        mInnerListView = new LoadingListView(getContext());
        mInnerListView.setParentView(this);
        //添加控件
        addView(mInnerListView);
        //设置上下拉监听
        setOnRefreshListener(this);
    }
````

####	B.核心功能
````
	//通知已完成加载
	public void onLoadingCompleted() {
        setRefreshing(false);
        mInnerListView.onLoadingCompleted();
    }
    //设置已加载完全部数据
    public void setHasMoreData(boolean hasMoreData) {
        mInnerListView.setHasMoreData(hasMoreData);
    }
````

###	2015.05.15完善
*	废弃getRefrshbleView();方法,
*	直接通过SwipeToRefreshListView设置adapter();
*	添加setEmptyView()方法;
*	添加HeaderView,FootView方法
###	2015.05.25
*	修改上拉加载更多实现形式
