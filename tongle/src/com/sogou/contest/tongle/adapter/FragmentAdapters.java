package com.sogou.contest.tongle.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.sogou.contest.tongle.fragment.FoodPagerF;
import com.sogou.contest.tongle.fragment.HomePagerF;
import com.sogou.contest.tongle.fragment.LifePagerF;


public class FragmentAdapters extends FragmentPagerAdapter {

	public FragmentAdapters(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		Fragment f = null;
		switch (position) {
		case 0:
			f = new HomePagerF();
			break;
		case 1:
			f = new FoodPagerF();
			break;
		case 2:
			f = new LifePagerF();
			break;

		default:
			break;
		}
		return f;
	}

	@Override
	public int getCount() {
		return 3;
	}

}
