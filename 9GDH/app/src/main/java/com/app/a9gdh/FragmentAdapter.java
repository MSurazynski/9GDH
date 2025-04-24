package com.app.a9gdh;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Lifecycle;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class FragmentAdapter extends FragmentStateAdapter {
    public FragmentAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        super(fragmentManager, lifecycle);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {

        switch (position){
            case 1:
                return new Symbolika_LilijkaFragment();
            case 2:
                return new Symbolika_MundurFragment();
            case 3:
                return new Symbolika_PagonWedrowniczyFragment();
        }

        return new Symbolika_KrzyzFragment();
    }

    @Override
    public int getItemCount() {
        return 4;
    }
}
