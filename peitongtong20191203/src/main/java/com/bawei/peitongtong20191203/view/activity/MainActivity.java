package com.bawei.peitongtong20191203.view.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.widget.RadioGroup;

import com.bawei.peitongtong20191203.R;
import com.bawei.peitongtong20191203.base.BaseActivity;
import com.bawei.peitongtong20191203.view.fragment.GouwuFragment;
import com.bawei.peitongtong20191203.view.fragment.HomeFragment;
import com.bawei.peitongtong20191203.view.fragment.OtherFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private ViewPager view_pager;
    private RadioGroup radio_group;
    private List<Fragment> list = new ArrayList<>();
    @Override
    protected void initData() {
        HomeFragment homeFragment = new HomeFragment();
        OtherFragment fenFragment = new OtherFragment();
        OtherFragment faxianFragment = new OtherFragment();
        GouwuFragment gouwuFragment = new GouwuFragment();
        OtherFragment myFragment = new OtherFragment();
        list.add(homeFragment);
        list.add(fenFragment);
        list.add(faxianFragment);
        list.add(gouwuFragment);
        list.add(myFragment);
        view_pager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });
        view_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                radio_group.check(radio_group.getChildAt(position).getId());
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        radio_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.rb1:
                        view_pager.setCurrentItem(0);
                        break;
                    case R.id.rb2:
                        view_pager.setCurrentItem(1);
                        break;
                    case R.id.rb3:
                        view_pager.setCurrentItem(2);
                        break;
                    case R.id.rb4:
                        view_pager.setCurrentItem(3);
                        break;
                    case R.id.rb5:
                        view_pager.setCurrentItem(4);
                        break;
                }
            }
        });
    }
    public void jump(){
        view_pager.setCurrentItem(0);
    }
    @Override
    protected void initView() {
        view_pager = findViewById(R.id.view_pager);
        radio_group = findViewById(R.id.radio_group);
    }

    @Override
    protected int LayoutId() {
        return R.layout.activity_main;
    }
}
