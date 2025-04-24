package com.app.a9gdh;

import static androidx.core.content.ContextCompat.getSystemService;

import android.app.UiModeManager;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SzyfryFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SzyfryFragment extends Fragment {

    private Button lastSelected = null;

    FragmentManager fragmentManager;
    View container_FragmentContainerView;
    Button gadery_btn;
    Button polityka_btn;
    Button malinowe_btn;
    Button cezar_btn;
    Button mors_btn;

    public SzyfryFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment SzyfryFragment.
     */
    public static SzyfryFragment newInstance(String param1, String param2) {
        return new SzyfryFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_szyfry, container, false);

        // Set variables for objects in this fragment
        fragmentManager = getParentFragmentManager();
        container_FragmentContainerView = view.findViewById(R.id.container_FragmentContainerView_SzyfryFragment);
        gadery_btn = view.findViewById(R.id.gadery_Button_SzyfyrFragment);
        polityka_btn = view.findViewById(R.id.polityka_Button_SzyfyrFragment);
        malinowe_btn = view.findViewById(R.id.malinowe_Button_SzyfyrFragment);
        cezar_btn = view.findViewById(R.id.cezar_Button_SzyfyrFragment);
        mors_btn = view.findViewById(R.id.mors_Button_SzyfyrFragment);

        lastSelected = gadery_btn;

        TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);


        // Handle on clicks
        handleOnClicks();


        // Handle call back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
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
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);


        // Inflate the layout for this fragment
        return view;
    }

    private void replaceFragment(Class<? extends Fragment> fragmentClass, Bundle args, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        Fragment oldFragment = fragmentManager.findFragmentById(R.id.container_FragmentContainerView_SzyfryFragment);
        if (oldFragment != null) {
            transaction.remove(oldFragment);
        }

        Fragment newFragment = fragmentManager.getFragmentFactory().instantiate(getClass().getClassLoader(), fragmentClass.getName());
        if (args != null) {
            newFragment.setArguments(args);
        }
        transaction.replace(R.id.container_FragmentContainerView_SzyfryFragment, newFragment, tag);
        transaction.commit();
    }


    private void handleOnClicks() {

        gadery_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageHighlighting(gadery_btn, getContext());

                Bundle args = new Bundle();
                args.putString("szyfr", "gadery");
                replaceFragment(GaderyFragment.class, args, "GaderyFragment");
            }
        });

        polityka_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageHighlighting(polityka_btn, getContext());

                Bundle args = new Bundle();
                args.putString("szyfr", "polityka");
                replaceFragment(GaderyFragment.class, args, "PolitykaFragment");
            }
        });

        malinowe_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageHighlighting(malinowe_btn, getContext());
                Bundle args = new Bundle();
                args.putString("szyfr", "malinowe");
                replaceFragment(GaderyFragment.class, args, "MalinoweFragment");
            }
        });

        cezar_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageHighlighting(cezar_btn, getContext());
                replaceFragment(CezarFragment.class, null, "CezarFragment");
            }
        });

        mors_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageHighlighting(mors_btn, getContext());
                replaceFragment(MorsFragment.class, null, "MorsFragment");
            }
        });
    }


    // Highlights newly selected button, and removes highlighting of the old one
    private void manageHighlighting(Button currBtn, Context context) {
        if (lastSelected.getId() != currBtn.getId()) {

            int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
            switch (nightModeFlags) {
                case Configuration.UI_MODE_NIGHT_YES:
                    lastSelected.setBackgroundTintList(context.getResources().getColorStateList(R.color.bottom_layer_dark, null));
                    lastSelected.setTextColor(context.getColor(R.color.text_dark));
                    currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.accent_dark, null));
                    currBtn.setTextColor(context.getColor(R.color.text_dark));
                    break;
                case Configuration.UI_MODE_NIGHT_NO:
                    lastSelected.setBackgroundTintList(context.getResources().getColorStateList(R.color.bottom_layer_light, null));
                    lastSelected.setTextColor(context.getColor(R.color.text_light));
                    currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.accent_light, null));
                    currBtn.setTextColor(context.getColor(R.color.text_dark));
                    break;
            }
            lastSelected = currBtn;
        }
    }
}