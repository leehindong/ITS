package info.androidhive.navigationdrawer.fragment;

import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.Utils.RequestTask;
import info.androidhive.navigationdrawer.common.MyApplication;
import info.androidhive.navigationdrawer.common.MyConfig;
import info.androidhive.navigationdrawer.other.ViewHolderAdapter;
import info.androidhive.navigationdrawer.other.bean.BusinessTripBean;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link BusinessTripFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link BusinessTripFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BusinessTripFragment extends Fragment {

    public static final String TAG = "BusinessTripFragment";

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public BusinessTripFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BusinessTripFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BusinessTripFragment newInstance(String param1, String param2) {
        BusinessTripFragment fragment = new BusinessTripFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        getDataListsByJSONRequest();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_businesstrip, container, false);
        final ListView listview = (ListView) view.findViewById(R.id.list_view);

        ArrayList<BusinessTripBean> list = new ArrayList<BusinessTripBean>();
        list.add(new BusinessTripBean("2016-12-21", "afternoon", "上海", "2017-01-02", "night", "北京", "bus", "approve"));
        list.add(new BusinessTripBean("2016-2-11", "morning", "深圳", "2016-07-17", "night", "西安", "train", "approve"));
        list.add(new BusinessTripBean("2015-10-21", "afternoon", "杭州", "2016-01-02", "night", "上海", "bus", "not-approve"));
        ViewHolderAdapter adapter = new ViewHolderAdapter(getActivity(), list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            }
        });

        return listview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private void getDataListsByStringRequest() {
        final ProgressDialog mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage("正在获取列表...");
        mDialog.setCancelable(false);
        mDialog.show();

//        Map<String, String> params = new HashMap<String, String>();
//        params.put("userNAme", "xxx");
        StringRequest stringRequest = new StringRequest(Request.Method.GET, MyConfig.URLS.businessTripListUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        Log.d(TAG, response);
                        mDialog.dismiss();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d(TAG, error.toString());
                mDialog.dismiss();
            }
        });

        // Adding request to request queue
        MyApplication.getInstance().getRequestQueue().add(stringRequest);

        // Cancelling request
        // ApplicationController.getInstance().getRequestQueue().cancelAll();
    }

    private void getDataListsByJSONRequest() {
        final ProgressDialog mDialog = new ProgressDialog(getActivity());
        mDialog.setMessage("正在获取列表...");
        mDialog.setCancelable(false);
        mDialog.show();

        Map<String, String> params = new HashMap<String, String>();
//        params.put("userNAme", "xxx");
        RequestTask request = new RequestTask(MyConfig.URLS.oppotunityListsUrl, params,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d(TAG, response.toString());
                        mDialog.hide();
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                VolleyLog.d(TAG, "Error: " + error.getMessage());
                mDialog.hide();
            }
        });
        MyApplication.getInstance().getRequestQueue().add(request);
    }
}
