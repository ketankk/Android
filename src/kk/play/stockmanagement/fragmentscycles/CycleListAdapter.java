package kk.play.stockmanagement.fragmentscycles;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import kk.play.stockmanagement.ImageDownload;
import kk.play.stockmanagement.R;
import kk.play.stockmanagement.entity.Cycles;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CycleListAdapter extends BaseAdapter {

	private Activity activity;
	private List<Cycles> cycles;
	//public ImageLoader imageloader;
	private String serverUrl="";
	private static LayoutInflater inflater=null;
	
	
	
	public CycleListAdapter(Activity activity,List<Cycles> cycles) {
		this.activity=activity;
		this.cycles=cycles;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		//imageloader =new ImageLoader(activity.getApplicationContext());
	}




	@Override
    public View getView(int position, View convertView, ViewGroup parent) {
		
		View vi=convertView;
		
		if(vi==null){
			vi=inflater.inflate(R.layout.list_row, null);
		}
		TextView lastUpdatedOn = (TextView)vi.findViewById(R.id.lastupdated); // last updated on
        TextView name = (TextView)vi.findViewById(R.id.name); // cycle name
        TextView quantity = (TextView)vi.findViewById(R.id.quantity); // quantity
        ImageView cycleImage=(ImageView)vi.findViewById(R.id.cycle_image); // thumb image
 Log.d("possss", position+"");
       Cycles cycle=cycles.get(position);//Get cycle from list of cycles using index
       
       name.setText(cycle.getNAME());
       lastUpdatedOn.setText(cycle.getId()+"");
       quantity.setText(cycle.getQUANTITY()+"");
       serverUrl+=cycle.getIMAGE();
	new  ImageDownload(cycleImage).execute(serverUrl);//Load image Asynchronously
		return vi;
	}
	



@Override
public int getCount() {
	return cycles.size();
}


@Override
public Object getItem(int position) {
	return position;
}


@Override
public long getItemId(int position) {
	return position;
}


//Custom class for each row view;

public static class ViewHolder{
	
}

}

       