package com.app.a9gdh;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ZbrojaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ZbrojaFragment extends Fragment {

    public ZbrojaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment ZbrojaFragment.
     */
    public static ZbrojaFragment newInstance() {
        return new ZbrojaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_zbroja, container, false);



        // Handle on back pressed
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                // Check if info from activity is open
                MainActivity activity = (MainActivity) getActivity();
                assert activity != null;
                if (activity.is_info_open) {
                    activity.closeInfo();

                } else {

                    FragmentManager fragmentManager = getParentFragmentManager();
                    TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);

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

        // Inflate the layout for this fragment
        return view;
    }
}