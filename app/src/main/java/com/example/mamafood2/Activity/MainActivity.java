package com.example.mamafood2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.mamafood2.R;
import com.example.mamafood2.adapter.ViewPagerAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ViewPager viewPager;
    BottomNavigationView bottomNavigationView;
    public static Typeface myTypeface;
    ProgressDialog progressDialog;
    long backp;
    @Override
    public void onBackPressed() {
        if (backp +2000 > System.currentTimeMillis()){
            finishAffinity();
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(MainActivity.this,"Nhấn thêm lần nữa để thoát",Toast.LENGTH_LONG).show();
        }
        backp = System.currentTimeMillis();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progressDialog = new ProgressDialog(this);
        progressDialog.dismiss();
         myTypeface = Typeface.createFromAsset(getAssets(), "fonts/UTM Androgyne_1.ttf");




        viewPager = findViewById(R.id.vpager);
        bottomNavigationView = findViewById(R.id.btnavigation);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
            switch (position){
                case 0:
                bottomNavigationView.getMenu().findItem(R.id.nav_home).setChecked(true);
                break;
                case 1:
                    bottomNavigationView.getMenu().findItem(R.id.nav_order).setChecked(true);
                    break;
                case 2:
                    bottomNavigationView.getMenu().findItem(R.id.nav_notifi).setChecked(true);
                    break;
                case 3:
                    bottomNavigationView.getMenu().findItem(R.id.nav_account).setChecked(true);
                    break;
            }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected( MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:
                        viewPager.setCurrentItem(0);
                        break;
                    case R.id.nav_order:
                        viewPager.setCurrentItem(1);
                        break;
                    case R.id.nav_notifi:
                        viewPager.setCurrentItem(2);
                        break;
                    case R.id.nav_account:
                        viewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
}