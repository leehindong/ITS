package info.androidhive.navigationdrawer.common;

import android.app.Application;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import info.androidhive.navigationdrawer.Utils.CrashHandler;
import info.androidhive.navigationdrawer.Utils.LruBitmapCache;
import info.androidhive.navigationdrawer.Utils.MySharedPreferences;
import info.androidhive.navigationdrawer.Utils.RequestTask;
import info.androidhive.navigationdrawer.activity.MainActivity;

/**
 * Created by apple on 16/10/8.
 */

public class MyApplication extends Application {

    public static final String TAG = MyApplication.class.getSimpleName();
    private static MyApplication mInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;
    private MainActivity mMain;
    private List<AppCompatActivity> activitys = new ArrayList<AppCompatActivity>();

    private MainActivity getmMain() {

        return mMain;
    }

    public void setmMain(MainActivity mMain) {
        this.mMain = mMain;
    }

    public synchronized static MyApplication getInstance() {
        return mInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        CrashHandler crashHandler = CrashHandler.getInstance();
        crashHandler.init(this);

        mRequestQueue = Volley.newRequestQueue(this);

        mInstance = this;
        mInstance.auto_login("lixintong@cetc-ss.com", "1");
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }
        return mRequestQueue;
    }

    private ImageLoader getImageLoader() {
        if (mRequestQueue == null) {
            mRequestQueue = Volley.newRequestQueue(this);
        }
        if (mImageLoader == null) {
            mImageLoader = new ImageLoader(this.mRequestQueue,
                    new LruBitmapCache());
        }
        return this.mImageLoader;
    }

    private void cancelAllRequests(Object tag) {
        if (mRequestQueue != null) {
            mRequestQueue.cancelAll(tag);
        }
    }

    private void exitApp() {
        finishAllActivity();
        // android.os.Process.killProcess(android.os.Process.myPid());
        System.exit(0);
    }

    private void finishAllActivity() {
        try {
            for (int i = 0; i < activitys.size(); i++) {
                try {
                    AppCompatActivity activity = activitys.get(i);
                    activity.finish();
                } catch (Exception e) {
                }
            }
            mMain.finish();
        } catch (Exception e) {
        }
    }

    public void auto_login(String userId, String password) {
//        final ProgressDialog mDialog = new ProgressDialog(this);
//        mDialog.setMessage("正在登录...");
//        mDialog.setCancelable(false);
//        mDialog.show();

        Map<String, String> params = new HashMap<String, String>();
        params.put("USER_ID", userId);
        params.put("PASSWORD", password);
        MySharedPreferences.setString(getApplicationContext(), "USER_ID", userId);
        MySharedPreferences.setString(getApplicationContext(), "PASSWORD", password);
        RequestTask jsonObjReq = new RequestTask(
                MyConfig.URLS.loginUrl, params,
                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        String EMP_NAME = response.optString("EMP_NAME");
                        String EMP_ID = response.optString("EMP_ID");
                        Boolean result = response.optBoolean("SUCCESS");

                        if (result) {
                            MySharedPreferences.setString(getApplicationContext(), "EMP_ID", response.optString("EMP_ID"));
                            MySharedPreferences.setString(getApplicationContext(), "EMP_NAME", response.optString("EMP_NAME"));

                            String toastContent = "欢迎您," + MySharedPreferences.getString(getApplicationContext(),"EMP_NAME", "错误姓名");
                            Toast.makeText(getApplicationContext(), toastContent, Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_LONG).show();
                        }
//                        mDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                mDialog.hide();
            }
        });

        // Adding request to request queue
        MyApplication.getInstance().getRequestQueue().add(jsonObjReq);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll();
    }
}
