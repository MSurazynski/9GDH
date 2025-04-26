package com.app.a9gdh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StopnieMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StopnieMenuFragment extends Fragment {

    private FragmentManager fragmentManager;

    private ImageButton mlodzik_ImageButton;
    private ImageButton wywiadowca_ImageButton;
    private ImageButton cwik_ImageButton;
    private ImageButton ho_ImageButton;
    private ImageButton hm_ImageButton;
    private ImageButton hr_ImageButton;
    private ImageButton pwd_ImageButton;
    private ImageButton phm_ImageButton;

    TextView title_TextView_MainActivity;

    public StopnieMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment StopnieMenuFragment.
     */
    public static StopnieMenuFragment newInstance(String param1, String param2) {
        StopnieMenuFragment fragment = new StopnieMenuFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stopnie_menu, container, false);


        // Set variables for objects in this fragment
        fragmentManager = getParentFragmentManager();

        mlodzik_ImageButton = view.findViewById(R.id.mlodzik_ImageButton_StopnieMenuFragment);
        wywiadowca_ImageButton = view.findViewById(R.id.wywiadowca_ImageButton_StopnieMenuFragment);
        cwik_ImageButton = view.findViewById(R.id.cwik_ImageButton_StopnieMenuFragment);
        ho_ImageButton = view.findViewById(R.id.ho_ImageButton_StopnieMenuFragment);
        hr_ImageButton = view.findViewById(R.id.hr_ImageButton_StopnieMenuFragment);
        pwd_ImageButton = view.findViewById(R.id.pwd_ImageButton_StopnieMenuFragment);
        phm_ImageButton = view.findViewById(R.id.phm_ImageButton_StopnieMenuFragment);
        hm_ImageButton = view.findViewById(R.id.hm_ImageButton_StopnieMenuFragment);

        title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);


        // Handle on clicks
        handleOnClicks();


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


    private void handleOnClicks() {

        mlodzik_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "1");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Młodzik");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        wywiadowca_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "2");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Wywiadowca");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        cwik_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "3");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Ćwik");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        ho_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "4");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Harcerz Orli");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        hr_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "5");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Harcerz Rzeczpospolitej");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        pwd_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "6");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Przewodnik");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        phm_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "7");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Podharmistrz");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });

        hm_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "8");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Harcmistrz");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopienFragment.class, args, "tag").commit();
            }
        });
    }
}