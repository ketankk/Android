package kk.play.fragments;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class SectionsPagerAdapter extends FragmentPagerAdapter {
	private final static int noTabs = 5;

	public SectionsPagerAdapter(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		switch (position) {
		case 1:
			return Fragment3.newInstance(position );
		case 2:
			return Fragment2.newInstance(position );
		case 3:
			return Fragment1.newInstance(position );
		default:

			return Fragment4.newInstance(position );

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
