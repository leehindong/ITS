package info.androidhive.navigationdrawer.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.other.LoadingProgressDialog;
import info.androidhive.navigationdrawer.other.bean.LoginBean;

public class AboutUsActivity extends AppCompatActivity {

    public static final String TAG = AboutUsActivity.class.getSimpleName();
    private TextView msgResponse;
    private LoadingProgressDialog mLoading;
    private ProgressDialog mDialog;
    private String paramString;
    private String testUrl = "http://api.androidhive.info/images/nav-menu-header-bg.jpg";

    private Map<String, String> params = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        msgResponse = (TextView) findViewById(R.id.mytxt);
//        mLoading = new LoadingProgressDialog(this, "正在加载中", R.drawable.loading_progress);

        Gson gson = new Gson();
        LoginBean user = new LoginBean("lixintong@cetc-ss.com", "1");
        paramString = gson.toJson(user);

//        makeJsonObjReq();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            // finish the activity
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



//    private void makeJsonObjReq() {
//        showProgressDialog();
//        params.put("USER_ID", "wangkai@cetc-ss.com");
//        params.put("PASSWORD", "1");
//        RequestTask jsonObjReq = new RequestTask(
//                MyConfig.URLS.loginUrl, params,
//                new Response.Listener<JSONObject>() {
//
//                    @Override
//                    public void onResponse(JSONObject response) {
//                        Log.d(TAG, response.toString());
//                        msgResponse.setText(response.toString());
//                        hideProgressDialog();
//                    }
//                }, new Response.ErrorListener() {
//
//            @Override
//            public void onErrorResponse(VolleyError error) {
//                VolleyLog.d(TAG, "Error: " + error.getMessage());
//                hideProgressDialog();
//            }
//        });
//
//        // Adding request to request queue
//        MyApplication.getInstance().getRequestQueue().add(jsonObjReq);
//
//        // Cancelling request
//        // ApplicationController.getInstance().getRequestQueue().cancelAll();
//    }
}
