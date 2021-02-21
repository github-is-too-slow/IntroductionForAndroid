package com.billion.helloworld.listview;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.billion.helloworld.R;

/**
 * Created by 13360 on 2021/2/15.
 */

public class ListViewActivity extends Activity {
    private ListView mLV1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        mLV1 = (ListView) findViewById(R.id.lv1);
        //为每个列表项关联内容
        mLV1.setAdapter(new MyListAdapter(ListViewActivity.this));
        //设置单击响应事件
        mLV1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "点击Positon:" + position, Toast.LENGTH_SHORT).show();
            }
        });
        //设置长按响应事件
        mLV1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "长按Position：" + position, Toast.LENGTH_SHORT).show();
                //只响应长按事件
                return true;
            }
        });
    }
}
