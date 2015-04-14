package com.justsdudio.justhere.chooseLocation;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.TypefaceSpan;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.justsdudio.justhere.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ChooseLocationActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
/*
        SpannableString s = new SpannableString("请选择地点（测试字体）");
        s.setSpan(new RelativeSizeSpan(1.0f),0, s.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);

        // Update the action bar title with the TypefaceSpan instance
        toolbar.setTitle(s);*/
        MenuItem menu2=(MenuItem)findViewById(R.id.action_settings);
        if(menu2==null){
            System.out.println("menuitem对象在创建Activity时是空的");
        }
        this.setSupportActionBar(toolbar);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_choose_location, menu);
        //获取menuItem对象进行修改，不过貌似无法调整ActionBar上展示出来的Item字体的大小，因此注释掉了
/*        MenuItem menu2=(MenuItem)findViewById(R.id.action_settings);
        if(menu==null){
            System.out.println("menu对象是空的");
        }
        if(menu.findItem(R.id.action_settings)==null){
            System.out.println("menu对象包含menuitem");
        }
        SpannableString s = new SpannableString("跳过2");
        s.setSpan(new AbsoluteSizeSpan(50),0, s.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        menu.findItem(R.id.skip).setTitle(s);*/




        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == R.id.skip) {
            System.out.println("你点击了跳过按钮");
            /**
             * 这里填写点击跳过按钮后的事件，应该是跳转到一个默认地点的主页
             */
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {

            // Create some dummy data for the ListView.  Here's a sample weekly forecast
            String[] data = {
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学",
                    "南京大学"
            };
            List<String> weekForecast = new ArrayList<String>(Arrays.asList(data));


            // Now that we have some dummy forecast data, create an ArrayAdapter.
            // The ArrayAdapter will take data from a source (like our dummy forecast) and
            // use it to populate the ListView it's attached to.
            mForecastAdapter =
                    new ArrayAdapter<String>(
                            getActivity(), // The current context (this activity)
                            R.layout.list_item_forecast, // The name of the layout ID.
                            R.id.list_item_forecast_textview, // The ID of the textview to populate.
                            weekForecast);

            View rootView = inflater.inflate(R.layout.fragment_choose_location, container, false);

            // Get a reference to the ListView, and attach this adapter to it.
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }
}
