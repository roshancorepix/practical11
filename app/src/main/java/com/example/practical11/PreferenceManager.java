package com.example.practical11;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.UserHandle;

public class PreferenceManager {

    private static SharedPreferences preferences;
    private static final String PREF_NAME = "pref";
    private static final String USER_NAME = "Username";
    private static final String PASSWORD = "Password";
    private static final String EMAIL = "Email";

    public PreferenceManager() {
    }

    public static void init(Context context){
        if (preferences == null){
            preferences = context.getSharedPreferences(PREF_NAME, Activity.MODE_PRIVATE);
        }
    }

    public static void setUsername(String username){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(USER_NAME, username);
        editor.commit();
    }

    public static String getUserName(){
        return preferences.getString(USER_NAME, "");
    }

    public static void setPassword(String password){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(PASSWORD, password);
        editor.commit();
    }

    public static String getPasswordP(){
        return preferences.getString(PASSWORD, "");
    }

    public static void setEmail(String email){
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(EMAIL, email);
        editor.commit();
    }

    public static String getEmail(){
        return preferences.getString(EMAIL, "");
    }

    public static void clearSharedPreference(){
        SharedPreferences.Editor editor = preferences.edit();
        editor.clear();
        editor.apply();
    }
}
