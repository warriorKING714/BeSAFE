package com.example.rushilkhattar.navdr;

/**
 * Created by rushilkhattar on 11/11/17.
 */

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Uddish Verma on 11/06/2017.
 */
public class Preferences {
    public static void setPrefs(String key, String value, Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MaitPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public static String getPrefs(String key, Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MaitPrefs", Context.MODE_PRIVATE);
        return sharedpreferences.getString(key, "notfound");
    }

    public static void deletePrefs(Context context){
        SharedPreferences sharedpreferences = context.getSharedPreferences("MaitPrefs", Context.MODE_PRIVATE);
        sharedpreferences.edit().clear().apply();
//        SharedPreferences.Editor editor = sharedpreferences.edit();
//        editor.clear();
//        editor.apply();
    }
}
