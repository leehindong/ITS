package info.androidhive.navigationdrawer.Utils;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

import info.androidhive.navigationdrawer.common.MyConfig;

/**
 * Created by apple on 16/10/8.
 */

public class MySharedPreferences {
    public static void setSaveItem(Context context, String id, String value, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("item" + id, value);
        editor.commit();
    }

    public static String getSaveItem(Context context, String id, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        if (sp != null) {
            return sp.getString("item" + id, "");
        } else {
            return "";
        }
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        return getBoolean(context, key, defValue, MyConfig.PREFERENCE_NAME);
    }

    public static boolean getBoolean(Context context, String key, boolean defValue, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getBoolean(key, defValue);
    }

    public static void setBoolean(Context context, String key, boolean value) {
        setBoolean(context, key, value, MyConfig.PREFERENCE_NAME);
    }

    public static void setBoolean(Context context, String key, boolean value, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static int getInt(Context context, String key, int defValue) {
        return getInt(context, key, defValue, MyConfig.PREFERENCE_NAME);
    }

    public static int getInt(Context context, String key, int defValue, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getInt(key, defValue);
    }

    public static void setInt(Context context, String key, int value) {
        setInt(context, key, value, MyConfig.PREFERENCE_NAME);
    }

    public static void setInt(Context context, String key, int value, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static String getString(Context context, String key, String defValue) {
        if (context == null) {
            return "";
        }
        return getString(context, key, defValue, MyConfig.PREFERENCE_NAME);
    }

    public static String getString(Context context, String key, String defValue, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getString(key, defValue);
    }

    public static void setString(Context context, String key, String value) {
        setString(context, key, value, MyConfig.PREFERENCE_NAME);
    }

    public static void setString(Context context, String key, String value, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static void clearAll(Context context) {
        clearAll(context, MyConfig.PREFERENCE_NAME);
    }

    public static void clearAll(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.clear();
        editor.commit();
    }

    public static void remove(Context context, String key, int i, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove(key);
        editor.commit();
    }

    public static long getLong(Context context, String key, long defValue) {
        return getLong(context, key, defValue, MyConfig.PREFERENCE_NAME);
    }

    public static long getLong(Context context, String key, long defValue, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return sp.getLong(key, defValue);
    }

    public static void setLong(Context context, String key, long value) {
        setLong(context, key, value, MyConfig.PREFERENCE_NAME);
    }

    public static void setLong(Context context, String key, long value, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static Map<String, String> getAll(Context context, String name) {
        SharedPreferences sp = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        return (Map<String, String>) sp.getAll();
    }

}
