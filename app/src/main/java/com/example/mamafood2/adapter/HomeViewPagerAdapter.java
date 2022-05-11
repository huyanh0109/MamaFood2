package com.example.mamafood2.adapter;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mamafood2.HomeTab.Dessert;
import com.example.mamafood2.HomeTab.Drink;
import com.example.mamafood2.HomeTab.Food;

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {
    public HomeViewPagerAdapter(FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Food();
            case 1:
                return new Drink();
            case 2:
                return new Dessert();
            default:
                return new Food();
        }
    }
    @Override
    public CharSequence getPageTitle(int position) {
        switch (position){
            case 0:
                return "ĐỒ ăn";
            case 1:
                return "Đồ uống";
            case 2:
                return "Hoa quả";
            default:
                return "Đồ ăn";
        }
    }
}
