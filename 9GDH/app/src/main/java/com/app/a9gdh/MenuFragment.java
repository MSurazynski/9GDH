package com.app.a9gdh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuFragment extends Fragment {

    private AnimationManager animationManager;
    private TextView title_TextView_MainActivity;

    Button szyfry_Button;
    Button prawo_Button;
    Button biografie_Button;
    Button stopnie_Button;
    Button struktura_Button;
    Button statut_Button;
    Button musztra_Button;
    Button sprawnosci_Button;
    Button mundur_Button;
    Button symbolika_Button;
    Button zbroja_Button;

    public MenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment MenuFragment.
     */
    public static MenuFragment newInstance() {
        return new MenuFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_menu, container, false);

        // Set variables for objects in this fragment
        szyfry_Button = (Button) view.findViewById(R.id.szyfry_Button_MenuFragment);
        prawo_Button = view.findViewById(R.id.prawo_Button_MenuFragment);
        biografie_Button = view.findViewById(R.id.biografie_Button_MenuFragment);
        stopnie_Button = view.findViewById(R.id.stopnie_Button_MenuFragment);
        struktura_Button = view.findViewById(R.id.struktura_Button_MenuFragment);
        statut_Button = view.findViewById(R.id.statut_Button_MenuFragment);
        musztra_Button = view.findViewById(R.id.musztra_Button_MenuFragment);
        sprawnosci_Button = view.findViewById(R.id.sprawnosci_Button_MenuFragment);
        mundur_Button = view.findViewById(R.id.mundur_Button_MenuFragment);
        symbolika_Button = view.findViewById(R.id.symbolika_Button_MenuFragment);
        zbroja_Button = view.findViewById(R.id.zbroja_Button_MenuFragment);


        FragmentManager fragmentManager = getParentFragmentManager();

        title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);
        animationManager = new AnimationManager(getContext());


        // Handle listeners
        handleListeners(view, fragmentManager);


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

                    getActivity().finish();
                    System.exit(0);
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);



        // Inflate the layout for this fragment
        return view;
    }


    public void changePageTitle(String txt) {
        title_TextView_MainActivity.setText(txt);
    }


    // Handle on Clicks
    private void handleListeners(View view, FragmentManager fragmentManager) {
        szyfry_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Szyfry");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, SzyfryFragment.class, null, "tag").commit();
            }
        });

        prawo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Prawo Harcerskie");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, PrawoFragment.class, null, "tag").commit();
            }
        });

        biografie_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Biografie");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, BiografieMenuFragment.class, null, "tag").commit();
            }
        });

        stopnie_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Stopnie");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopnieMenuFragment.class, null, "tag").commit();
            }
        });

        struktura_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Struktura i Funkcje");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StrukturaFragment.class, null, "tag").commit();
            }
        });

        statut_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Statut ZHR");

                Bundle args = new Bundle();
                args.putString("index", "statut");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, PDFViewerFragment.class, args, "tag").commit();
            }
        });

        musztra_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Musztra");

                Bundle args = new Bundle();
                args.putString("index", "musztra");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, PDFViewerFragment.class, args, "tag").commit();
            }
        });

        sprawnosci_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Sprawności");

                Bundle args = new Bundle();
                args.putString("index", "sprawnosci");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, PDFViewerFragment.class, args, "tag").commit();
            }
        });

        mundur_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Umundurowanie");

                Bundle args = new Bundle();
                args.putString("index", "mundur");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, PDFViewerFragment.class, args, "tag").commit();
            }
        });

        symbolika_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle("Symbolika");


                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, ViewPagerHolderFragment.class, null, "tag").commit();
            }
        });

        zbroja_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                changePageTitle(getString(R.string.zbroja));


                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, ZbrojaFragment.class, null, "tag").commit();
            }
        });
    }
}