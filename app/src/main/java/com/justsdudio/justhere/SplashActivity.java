package com.justsdudio.justhere;

import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;


public class SplashActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //货物图片资源
        ApplicationInfo appInfo = getApplicationInfo();
        int resID = getResources().getIdentifier("splash", "drawable", appInfo.packageName);
        Bitmap logo=BitmapFactory.decodeResource(getResources(), resID);
        System.out.println(""+logo.getWidth());
        //进行闪屏切换
        System.out.println("闪屏即将开始1");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        System.out.println("闪屏即将开始2");
        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                Intent intent = new Intent(SplashActivity.this,LoginActivity.class);
                startActivity(intent);
                SplashActivity.this.finish();
                System.out.println("闪屏已结束1");
            }
        },2500);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
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

        return super.onOptionsItemSelected(item);
    }
}
