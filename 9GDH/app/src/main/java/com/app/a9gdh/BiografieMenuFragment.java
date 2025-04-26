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
 * Use the {@link BiografieMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BiografieMenuFragment extends Fragment {

    private AnimationManager animationManager;
    private TextView title_TextView_MainActivity;

    public BiografieMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment BiografieMenuFragment.
     */
    public static BiografieMenuFragment newInstance() {
        return new BiografieMenuFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biografie_menu, container, false);


        // Set variables for objects in this fragment
        FragmentManager fragmentManager = getParentFragmentManager();
        ImageButton baden_ImageButton = view.findViewById(R.id.baden_ImageButton_BiografieMenuFragment);
        ImageButton malkowski_ImageButton = view.findViewById(R.id.malkowski_ImageButton_BiografieMenuFragment);
        ImageButton olga_ImageButton = view.findViewById(R.id.olga_ImageButton_BiografieMenuFragment);
        ImageButton pilecki_ImageButton = view.findViewById(R.id.pilecki_ImageButton_BiografieMenuFragment);
        ImageButton lutoslawski_ImageButton = view.findViewById(R.id.lutoslawski_ImageButton_BiografieMenuFragment);
        ImageButton frelichowski_ImageButton = view.findViewById(R.id.frelichowski_ImageButton_BiografieMenuFragment);
        ImageButton strzembosz_ImageButton = view.findViewById(R.id.strzembosz_ImageButton_BiografieMenuFragment);

        title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);
        animationManager = new AnimationManager(getContext());


        // Handle on clicks
        baden_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "1");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Robert Baden-Powell");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        malkowski_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "2");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Andrzej Małkowski");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        olga_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "3");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Olga Drahonowska-Małkowska");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        pilecki_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "4");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Witold Pilecki");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        lutoslawski_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "5");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Kazimierz Lutosławski");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        frelichowski_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "6");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Stefan Wincenty Frelichowski");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });

        strzembosz_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "7");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Tomasz Strzembosz");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografiaFragment.class, args, "tag").commit();
            }
        });


        // Handle call back
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
}