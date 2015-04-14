package com.justsdudio.justhere.chooseLocation;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.support.v7.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.justsdudio.justhere.MainActivity;
import com.justsdudio.justhere.R;


public class ChooseLocationActivity extends ActionBarActivity {
    //Similarly we Create a String Resource for the name and email in the header view
    //And we also create a int resource for profile picture in the header view
    String TITLES[] = {"我的地点","设置","我的账户"};
    int ICONS[] = {R.drawable.ic_locationcollect,R.drawable.ic_setting,R.drawable.ic_user};
    String NAME = " 吴康康";
    String EMAIL = "padeoe@gmai.com";
    int PROFILE = R.drawable.personalpicture;

    private Toolbar toolbar;                              // Declaring the Toolbar Object

    RecyclerView mRecyclerView;                           // Declaring RecyclerView
    RecyclerView.Adapter mAdapter;                        // Declaring Adapter For Recycler View
    RecyclerView.LayoutManager mLayoutManager;            // Declaring Layout Manager as a linear layout manager
    DrawerLayout Drawer;                                  // Declaring DrawerLayout

    ActionBarDrawerToggle mDrawerToggle;                  // Declaring Action Bar Drawer Toggle
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_location);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
        //获取toolbar对象，设置为ActionBar
        toolbar = (Toolbar) findViewById(R.id.toolbar); // Attaching the layout to the toolbar object
        this.setSupportActionBar(toolbar);


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView); // Assigning the RecyclerView Object to the xml View
        mRecyclerView.setHasFixedSize(true);                            // Letting the system know that the list objects are of fixed size
        mAdapter = new MyAdapter(TITLES,ICONS,NAME,EMAIL,PROFILE);       // Creating the Adapter of MyAdapter class(which we are going to see in a bit)
        // And passing the titles,icons,header view name, header view email,
        // and header view profile picture

        mRecyclerView.setAdapter(mAdapter);                              // Setting the adapter to RecyclerView

        mLayoutManager = new LinearLayoutManager(this);                 // Creating a layout Manager

        mRecyclerView.setLayoutManager(mLayoutManager);                 // Setting the layout Manager


        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);        // Drawer object Assigned to the view
        mDrawerToggle = new ActionBarDrawerToggle(this,Drawer,toolbar,R.string.openDrawer,R.string.closeDrawer){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                // code here will execute once the drawer is opened( As I dont want anything happened whe drawer is
                // open I am not going to put anything here)
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                // Code here will execute once drawer is closed
            }



        }; // Drawer Toggle Object Made
        Drawer.setDrawerListener(mDrawerToggle); // Drawer Listener set to the Drawer toggle
        mDrawerToggle.syncState();               // Finally we set the drawer toggle sync State


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_choose_location, menu);
        //获取menuItem对象进行修改，不过貌似无法调整ActionBar上展示出来的Item字体的大小，因此注释掉了
        MenuItem menu2=(MenuItem)findViewById(R.id.action_settings);
/*        if(menu==null){
            System.out.println("menu对象是空的");
        }
        if(menu.findItem(R.id.action_settings)==null){
            System.out.println("menu对象不包含menuitem");
        }
       *//* SpannableString s = new SpannableString("跳过2");
        s.setSpan(new AbsoluteSizeSpan(50),0, s.length(),
                Spannable.SPAN_INCLUSIVE_INCLUSIVE);
        menu.findItem(R.id.skip).setTitle(s);*/
        MenuItem menuItem=menu.findItem(R.id.skip);
        menuItem.setOnMenuItemClickListener(new MenuItem.OnMenuItemClickListener(){

            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
              /*  Intent intent = new Intent(ChooseLocationActivity.this, MainActivity.class);
                startActivity(intent);
                ChooseLocationActivity.this.finish();*/
                return false;
            }
        });




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
            Intent intent = new Intent(ChooseLocationActivity.this, MainActivity.class);
            startActivity(intent);
            ChooseLocationActivity.this.finish();
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
