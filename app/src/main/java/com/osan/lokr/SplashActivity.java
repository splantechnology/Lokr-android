package com.osan.lokr;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.osan.lokr.utils.SessionManager;

public class SplashActivity extends AppCompatActivity
{
    SessionManager sessionManager;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        sessionManager = new SessionManager(SplashActivity.this);
        /*int version = 0;
        try
        {
            version = getPackageManager().getPackageInfo(getPackageName(), 0).versionCode;
            SharedPreferences sharedPreferences = this.getSharedPreferences("version", MODE_PRIVATE);
            int myVersion = sharedPreferences.getInt("versioncode", 0);
            if(version != myVersion)
            {
                sessionManager.clearSession();
                SharedPreferences.Editor editor = getSharedPreferences("version", MODE_PRIVATE).edit();
                editor.putInt("versioncode", version);
                editor.commit();
            }
        }
        catch (PackageManager.NameNotFoundException e)
        {
            e.printStackTrace();
        }*/

        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                if(sessionManager.isLoggedIn())
                {
                    intent = new Intent(SplashActivity.this, MainActivity.class);
                }
                else
                {
                    intent = new Intent(SplashActivity.this, LoginActivity.class);
                }
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}
