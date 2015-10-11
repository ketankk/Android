package kk.play.stockmanagement.fragmentscycles;

import java.util.List;

import kk.play.stockmanagement.R;
import kk.play.stockmanagement.database.CyclesDBHandler;
import kk.play.stockmanagement.entity.Cycles;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class ViewController {
	LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
			LayoutParams.MATCH_PARENT, 0, .2f);

	public View createView(List<Cycles> cycles, View rootView, Activity activity) {

		String url = "https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";
		url = "http://dummyimage.com/300";

		Log.d("view controoller", "calling adp");
		CycleListAdapter adp = new CycleListAdapter(activity, cycles);

		ListView lview = (ListView) rootView.findViewById(R.id.list);
		//TextView lview = (TextView) rootView.findViewById(R.id.list1);

		lview.setAdapter(adp);
		
		return rootView;
	}

	private void decreClick(int id, Context context) {
		CyclesDBHandler handler = new CyclesDBHandler(context);

		handler.updateQuantity(id, false);

	}

	private void increClick(int id, Context context) {
		CyclesDBHandler handler = new CyclesDBHandler(context);

		handler.updateQuantity(id, true);

	}

	
}
