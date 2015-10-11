package kk.play.stockmanagement.adapters;

import kk.play.stockmanagement.fragmentscycles.Gents;
import kk.play.stockmanagement.fragmentscycles.Kids;
import kk.play.stockmanagement.fragmentscycles.Ladies;
import kk.play.stockmanagement.fragmentscycles.Others;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

public class CyclesController extends FragmentPagerAdapter {
	private final static int noTabs = 4;

	public CyclesController(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {

		switch (position) {
		case 1:
			return Gents.newInstance(position );
		case 2:
			return Ladies.newInstance(position );
		case 3:
			return Kids.newInstance(position );
		
			default:
				return Others.newInstance(position );

		}
	}

	@Override
	public int getCount() {
		return noTabs;
	}

	@Override
	public CharSequence getPageTitle(int position) {
		switch (position) {
		case 0:
			return "Gents";
		case 1:
			return "Ladies";
		case 2:
			return "Kids";
		default:
			return "Others";
		}

	}
}
