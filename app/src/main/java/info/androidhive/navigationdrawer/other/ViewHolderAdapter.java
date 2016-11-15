package info.androidhive.navigationdrawer.other;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import info.androidhive.navigationdrawer.R;
import info.androidhive.navigationdrawer.other.bean.BusinessTripBean;

/**
 * Created by apple on 16/10/19.
 */

public class ViewHolderAdapter extends BaseAdapter {
    public static final String TAG = "ViewHolderAdapter";

    private List<BusinessTripBean> mData;
    private LayoutInflater mInflater;

    public ViewHolderAdapter(Context context, List<BusinessTripBean> data) {
//        Log.d(TAG, "初始化调用" + data.toString());
        this.mData = data;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        ViewHolder holder = null;

        if (view == null) {
            holder = new ViewHolder();
            view = mInflater.inflate(R.layout.viewholder_businesstrip, null);
            holder.startingDate = (TextView) view.findViewById(R.id.tv_starting_date);
            holder.startingTime = (TextView) view.findViewById(R.id.tv_starting_time);
            holder.startingPoint = (TextView) view.findViewById(R.id.tv_starting_spot);
            holder.endingDate = (TextView) view.findViewById(R.id.tv_ending_date);
            holder.endingTime = (TextView) view.findViewById(R.id.tv_ending_time);
            holder.destination = (TextView) view.findViewById(R.id.tv_destination);
            holder.trafficMethod = (ImageView) view.findViewById(R.id.iv_traffic_tool);
            holder.approveResult = (ImageView) view.findViewById(R.id.iv_approve_result);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }

        holder.trafficMethod.setImageResource(R.drawable.bus);
        holder.approveResult.setImageResource(R.drawable.cruise);

        holder.startingDate.setText("2016-11-22");
        holder.startingPoint.setText("shanghai");
        holder.startingTime.setText(mData.toString());

        holder.endingDate.setText("2016-11-22");
        holder.destination.setText("shanghai");
        holder.endingTime.setText("afternoon");

        holder.approveResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        return view;
    }

    public final class ViewHolder {
        public TextView startingPoint, startingDate, startingTime, destination, endingDate, endingTime;
        public ImageView trafficMethod, approveResult;
    }
}
