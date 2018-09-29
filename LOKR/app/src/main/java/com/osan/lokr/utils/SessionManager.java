package com.osan.lokr.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import java.util.HashMap;

public class SessionManager

{
    private static SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;
    int PRIVATE_MODE = 0;
    private static final String PREF_NAME = "userData";
    private static final String IS_LOGIN = "isLogin";

    public static final String KEY_ID = "id";
    public static final String KEY_NAME = "name";
    public static final String KEY_MOBILE = "mobile";
    public static final String KEY_EMAIL = "email";
    public static final String KEY_CREATED = "created";

    public SessionManager(Context context)
    {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(String id, String name, String mobile, String email, String created)
    {
        editor.putBoolean(IS_LOGIN, true);

        editor.putString(KEY_ID, id);
        editor.putString(KEY_NAME, name);
        editor.putString(KEY_MOBILE, mobile);
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_CREATED, created);
        editor.commit();
    }

    public void clearSession()
    {
        editor.clear();
        editor.commit();
    }

    public HashMap<String, String> getUserDetails()
    {
        HashMap<String, String> user = new HashMap<String, String>();

        user.put(KEY_ID, pref.getString(KEY_ID, null));
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));
        user.put(KEY_MOBILE, pref.getString(KEY_MOBILE, null));
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));
        user.put(KEY_CREATED, pref.getString(KEY_CREATED, null));
        return user;
    }

    public void logoutUser()
    {
        editor.clear();
        editor.commit();
       /* Intent i = new Intent(_context, RegisterActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        _context.startActivity(i);*/

    }
    public boolean isLoggedIn()
    {
        return pref.getBoolean(IS_LOGIN, false);
    }
    public  static String getId()
    {
        return pref.getString(KEY_ID, null);
    }
    public static String getName()
    {
        return pref.getString(KEY_NAME, null);
    }
    public static String getMobile()
    {
        return pref.getString(KEY_MOBILE, null);
    }
}