package com.example.com.mumbai;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by mahir on 17-03-2018.
 */

public class SimpleFragmentPageAdapter extends FragmentPagerAdapter {
    private String[] tabtitle=new String[]{"Suggested places","Beaches","Historical Places","Adventures","Parks",};
    Context context;
    private int pageCount=5;
    public SimpleFragmentPageAdapter(FragmentManager fm, Context context){
        super(fm);
        this.context=context;
    }

    @Override
    public int getCount() {
        return pageCount;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                suggested_places suggested_pla=new suggested_places();
                return suggested_pla;
            case 1:
                PlacesBeaches placesBeaches=new PlacesBeaches();
                return placesBeaches;
            case 2:
                PlacesHistorical placesHistorical=new PlacesHistorical();
                return placesHistorical;
            case 3:
                PlacesAdventure placesAdventure=new PlacesAdventure();
                return placesAdventure;
            case 4:
                PlacesOther placesOther=new PlacesOther();
                return placesOther;
            default:
                return null;
        }

    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabtitle[position];
    }
}
