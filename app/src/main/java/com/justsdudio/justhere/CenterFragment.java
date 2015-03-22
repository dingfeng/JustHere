package com.justsdudio.justhere;

import android.animation.ObjectAnimator;
import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TabHost;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by FD on 2015/3/22.
 */
public class CenterFragment extends Fragment
{
    final  static  int LIST_CONTENT_NUM = 4;
    View rootView;
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState)
    {
        rootView = inflater.inflate(R.layout.activity_main,null);
        TabHost tabHost = (TabHost)rootView.findViewById(R.id.tabHost);
        tabHost.setup();
        TabHost.TabSpec  tab1 = tabHost.newTabSpec("tab1").setIndicator("留言").setContent(R.id.tab1);
        tabHost.addTab(tab1);
        TabHost.TabSpec tab2 = tabHost.newTabSpec("tab2").setIndicator("附近活动").setContent(R.id.tab2);
        tabHost.addTab(tab2);
        TabHost.TabSpec tab3 = tabHost.newTabSpec("tab3").setIndicator("信息分享").setContent(R.id.tab3);
        tabHost.addTab(tab3);
        return rootView;
    }

    public void onActivityCreated(Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        ListView list = (ListView)rootView.findViewById(R.id.list);
        String [] contentStr = new String[]
                {
                        "head_image","name","content","time","praiseCount"
                };
        Map<String, Object> item1 = new HashMap<String,Object>();
        item1.put(contentStr[0],R.drawable.head);
        item1.put(contentStr[1],"一路平安");
        item1.put(contentStr[2],"欢迎光临");
        item1.put(contentStr[3],"昨天");
        item1.put(contentStr[4],"1");
        List<Map<String,Object>> data =
                new ArrayList<Map<String,Object>>();
        data.add(item1);
       int[] to = new int[]
                {
                        R.id.head,R.id.user_name,R.id.user_content,
                        R.id.praise_num
                };
       SimpleAdapter adapter = new SimpleAdapter(getActivity(),
               data,R.layout.list_item,contentStr,to);
        list.setAdapter(adapter);
    }
}
