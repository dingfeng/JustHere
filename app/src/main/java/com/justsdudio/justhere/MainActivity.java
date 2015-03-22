package com.justsdudio.justhere;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Window;


public class MainActivity extends Activity {
    public static  DrawerLayout  drawer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.drawer_layout);
        drawer = (DrawerLayout)this.findViewById(R.id.drawer_layout);
        FragmentManager fragmentManager = this.getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment centerFragment = new CenterFragment();
        fragmentTransaction.replace(R.id.fragment_layout,centerFragment);
        fragmentTransaction.commit();

    }


}
