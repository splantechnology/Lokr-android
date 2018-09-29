package com.osan.lokr;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.osan.lokr.fragments.HelpContactFragment;
import com.osan.lokr.fragments.HomeFragment;
import com.osan.lokr.fragments.ListingFragment;
import com.osan.lokr.fragments.MessageFragment;
import com.osan.lokr.fragments.NavigationFragment;
import com.osan.lokr.fragments.NotificationFragment;
import com.osan.lokr.fragments.ProfileFragment;
import com.osan.lokr.fragments.RequestFragment;
import com.osan.lokr.fragments.SavedFragment;
import com.osan.lokr.fragments.SettingFragment;
import com.osan.lokr.fragments.WatchFragment;

public class MainActivity extends AppCompatActivity
{
    DrawerLayout drawerLayout;
    NavigationFragment navigationFragment;
    ImageView imgMenu;
    TextView tvHeading;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationFragment = (NavigationFragment) getSupportFragmentManager().findFragmentById(R.id.navFragment);
        imgMenu = (ImageView) findViewById(R.id.imgMenu);
        tvHeading = (TextView) findViewById(R.id.tvHeading);

        listener();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutFContainer, new HomeFragment());
        ft.commit();
        tvHeading.setText("Home");
    }

    private void listener()
    {
        imgMenu.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                openCloseDrawer();
            }
        });

        drawerLayout.addDrawerListener(new ActionBarDrawerToggle(MainActivity.this, drawerLayout, 0, 0)
        {
            @Override
            public void onDrawerClosed(View drawerView)
            {
                super.onDrawerClosed(drawerView);
            }
            @Override
            public void onDrawerOpened(View drawerView)
            {
                super.onDrawerOpened(drawerView);
            }
        });
    }

    public void openCloseDrawer()
    {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(Gravity.START);
        }
        else
        {
            drawerLayout.openDrawer(Gravity.START);
        }
    }

    @Override
    public void onBackPressed()
    {
        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    public void displaySelectedScreen(int selected, String heading)
    {
        Fragment fragment = null;
        switch (selected)
        {
            case 1:
                fragment = new HomeFragment();
                break;
            case 2:
                fragment = new MessageFragment();
                break;
            case 3:
                fragment = new NotificationFragment();
                break;
            case 4:
                fragment = new WatchFragment();
                break;
            case 5:
                fragment = new SavedFragment();
                break;
            case 6:
                fragment = new RequestFragment();
                break;
            case 7:
                fragment = new ListingFragment();
                break;
            case 8:
                fragment = new HelpContactFragment();
                break;
            case 9:
                fragment = new SettingFragment();
                break;
            case 10:
                fragment = new ProfileFragment();
                break;
        }
        if (fragment != null)
        {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frameLayoutFContainer, fragment);
            ft.commit();
        }
        tvHeading.setText(heading);
        openCloseDrawer();
    }
}
