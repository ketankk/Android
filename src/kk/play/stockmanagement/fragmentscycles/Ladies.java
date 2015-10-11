package kk.play.stockmanagement.fragmentscycles;

import java.util.List;

import kk.play.stockmanagement.ImageDownload;
import kk.play.stockmanagement.R;
import kk.play.stockmanagement.database.CyclesDBHandler;
import kk.play.stockmanagement.entity.Cycles;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class Ladies extends Fragment {

	private static final String ARG_SECTION_NUMBER = "section_number";
	private static final String type="Ladies";

	
	public static Ladies newInstance(int sectionNumber) {
		Ladies fragment = new Ladies();
		Bundle args = new Bundle();
		args.putInt(ARG_SECTION_NUMBER, sectionNumber);
		fragment.setArguments(args);
		return fragment;
	}

	public Ladies() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.cycles, container, false);
		
		
		CyclesDBHandler gentsHandler = new CyclesDBHandler(getActivity());
		List<Cycles> cycleList = gentsHandler.getCyclesByType(type);
		ViewController controller=new ViewController();

		controller.createView(cycleList, rootView,getActivity());

		
		return rootView;
	}

}