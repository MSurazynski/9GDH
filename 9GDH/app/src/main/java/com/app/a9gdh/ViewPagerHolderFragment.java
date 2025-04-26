package com.app.a9gdh;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;

import org.jetbrains.annotations.NotNull;

public class ViewPagerHolderFragment extends Fragment {


    @Nullable
        @Override
        public View onCreateView(@NonNull @NotNull LayoutInflater inflater,
                @Nullable @org.jetbrains.annotations.Nullable ViewGroup container,
                @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.fragment_view_pager_holder, container, false);
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            CreateViewPager(view);

            TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);
            FragmentManager fragmentManager = getParentFragmentManager();

            OnBackPressedCallback callback = new OnBackPressedCallback(true) {
                @Override
                public void handleOnBackPressed() {

                    // Check if info from activity is open
                    MainActivity activity = (MainActivity) getActivity();
                    assert activity != null;
                    if (activity.is_info_open) {
                        activity.closeInfo();
                    } else {

                        title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                        title_TextView_MainActivity.setText("9 GDH");

                        fragmentManager.beginTransaction()
                                .setCustomAnimations(
                                        R.anim.fade_in,
                                        R.anim.fade_out,
                                        R.anim.fade_in,
                                        R.anim.fade_out
                                )
                                .replace(R.id.frame_FragmentContainerView_MainActivity, MenuFragment.class, null, "tag").commit();
                    }
                }
            };
            requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);
    }



    public void CreateViewPager(View view){
        TabLayout tabLayout = view.findViewById(R.id.pagerViewHolder_TabLayout_Layout);
        ViewPager2 viewPager2 = view.findViewById(R.id.pagerViewHolder_ViewPager_Layout);

        FragmentAdapter adapter;
        FragmentManager fm = getParentFragmentManager();
        adapter = new FragmentAdapter(fm, getLifecycle());
        viewPager2.setAdapter(adapter);


        tabLayout.addTab(tabLayout.newTab().setText("Krzyż Harcerski"));
        tabLayout.addTab(tabLayout.newTab().setText("Lilijka"));
        tabLayout.addTab(tabLayout.newTab().setText("Mundur Harcerski"));
        tabLayout.addTab(tabLayout.newTab().setText("Pagon Wędrowniczy"));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                tabLayout.selectTab(tabLayout.getTabAt(position));
            }
        });
    }
}