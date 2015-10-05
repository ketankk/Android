package kk.play.fragments.cycles;

import java.util.List;

import kk.play.database.CyclesDBHandler;
import kk.play.database.MySQLiteHelper;
import kk.play.entity.Cycles;
import kk.play.stockmanagement.ImageDownload;
import kk.play.stockmanagement.R;
import android.app.ActionBar.LayoutParams;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class Gents extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";

	private static final String fragment_tag = "gents";
	private static final String type = "Gents";

	public static Gents newInstance(int sectionNumber) {
		Gents fragment = new Gents();

		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public Gents() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.cycles, container, false);

		String url = "https://www.google.co.in/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png";

		// Populate View
		TableLayout layout = (TableLayout) rootView.findViewById(R.id.table);

		// Get list of all cycles of type=Gents;
		CyclesDBHandler gentsHandler = new CyclesDBHandler(getActivity());
		List<Cycles> cycleList = gentsHandler.getCyclesByType(type);

		for (Cycles cycle : cycleList) {
			// row for each cycle
			TableRow row = new TableRow(getActivity());

			row.bringToFront();
			row.setClickable(true);
			row.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT));
			// Image of cycle
			ImageView cycleImage = new ImageView(getActivity());
			// Cycle name
			TextView cycleName = new TextView(getActivity());
			cycleName.setTextColor(R.id.color);
			cycleName.setTypeface(null, Typeface.BOLD);
			cycleName.setTextSize(30);

			// Detail of cycle
			TextView cycleDetail = new TextView(getActivity());
			// Quantity of cycle
			TextView cycleQuant = new TextView(getActivity());

			cycleQuant.setTextColor(R.id.color);
			cycleQuant.setTypeface(null, Typeface.BOLD);
			cycleQuant.setTextSize(20);
			// Cycle Size
			TextView cycleSize = new TextView(getActivity());

			ImageView decre = new ImageView(getActivity());
			decre.setImageResource(R.drawable.minus);
			decre.setMaxHeight(15);
			decre.setClickable(true);
			

			ImageView incre = new ImageView(getActivity());
			incre.setBackgroundResource(R.drawable.plus);
			incre.setMaxHeight(15);
			//Load Cycle image using AsyncTask
			new ImageDownload(cycleImage).execute(url);
			cycleImage.setMaxHeight(20);
			cycleImage.setMaxWidth(10);
			
			cycleName.setText(cycle.getNAME());
			cycleDetail.setText(cycle.getDESCRIPTION());
			cycleQuant.setText("" + cycle.getQUANTITY());
			cycleSize.setText("" + cycle.getSIZE());

			row.addView(cycleImage);
			row.addView(cycleName);
			row.addView(cycleSize);
			row.addView(cycleDetail);
			row.addView(incre);
			row.addView(cycleQuant);
			row.addView(decre);
			layout.addView(row);
		}
		return rootView;
	}

}
