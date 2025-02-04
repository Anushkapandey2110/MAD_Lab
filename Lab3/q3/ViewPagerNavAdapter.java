package com.example.lab3q3;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerNavAdapter extends FragmentPagerAdapter {

    public ViewPagerNavAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        if(position == 0) {//count = 3 so pos 0--2
            return new trending();
        }
        else if(position == 1) {
            return new sports();
        }
        else {
            return new Entertainment();
        }

    }

    @Override
    public int getCount() {
        return 3; //count is equal to the number of tabs , one fragment for each tab so 3 fragments
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        if(position == 0)
            return "Trending";
        else if(position == 1)
            return "Sports";
        else
            return "Entertainment";
    }
}
