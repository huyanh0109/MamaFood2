package com.example.mamafood2.Menu;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mamafood2.adapter.HomeViewPagerAdapter;
import com.example.mamafood2.R;
import com.google.android.material.tabs.TabLayout;

public class HomeFrag extends Fragment {
    public HomeFrag(){
    }
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private View fview;
    @Override
    public View onCreateView( LayoutInflater inflater, ViewGroup container,  Bundle savedInstanceState) {
        fview = inflater.inflate(R.layout.activity_home_frag,container,false);

        tabLayout = fview.findViewById(R.id.tab_layout);
        viewPager = fview.findViewById(R.id.home_viewpager);

        HomeViewPagerAdapter adapter  = new HomeViewPagerAdapter(getChildFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        return fview;
    }
}