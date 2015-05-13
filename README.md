#SwipeToRefreshListView
***
##	通过使用SwipeRefreshLayout实现简单的下拉刷新

1.	使用>>布局文件中使用
````
	<com.example.demo.SwipeToRefreshListView
        	android:id="@+id/swipeListView"
        	android:layout_width="match_parent"
        	android:layout_height="match_parent" />
````        
2.	为ListView设置适配器,通过SwipeToRefreshListView获取内部的ListView对象
````
	SwipeToRefreshListView sl = (SwipeToRefreshListView) findViewById(R.id.swipeListView);
        sl.setOnRefreshListener(this);
        LoadingListView refresibleView = sl.getRefrshbleView();
        //ListView适配器,用法同一般的ListView
	MyAdapter mAdapter = new MyAdapter();
        refresibleView.setAdapter(mAdapter);
````    
