##	通过使用SwipeRefreshLayout实现简单的下拉刷新
控件实现下拉刷新(onRefresh回调),最后一行可见时自动加载更多(OnLastItemVisable回调)
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
###	2015.05.15完善
*	废弃getRefrshbleView();方法,
*	直接通过SwipeToRefreshListView设置adapter();
*	添加setEmptyView()方法;    

###	TODO
*	添加HeaderView,FootView方法
