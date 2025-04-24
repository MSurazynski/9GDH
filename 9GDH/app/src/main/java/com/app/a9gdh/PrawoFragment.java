package com.app.a9gdh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PrawoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PrawoFragment extends Fragment {

    private boolean descShown = false;
    private TextView desc_textView;
    private LinearLayout desc_linearLayout;
    private Button bgDesc_btn;
    private AnimationManager animationManager;

    private Button przyzeczenie_btn;
    private Button one_btn;
    private Button two_btn;
    private Button three_btn;
    private Button four_btn;
    private Button five_btn;
    private Button six_btn;
    private Button seven_btn;
    private Button eight_btn;
    private Button nine_btn;
    private Button ten_btn;

    public PrawoFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment PrawoFragment.
     */
    public static PrawoFragment newInstance(String param1, String param2) {
        return new PrawoFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_prawo, container, false);

        // Set variables for objects in this fragment
        FragmentManager fragmentManager = getParentFragmentManager();
        przyzeczenie_btn = view.findViewById(R.id.przyzeczenie_Button_PrawoFragment);
        one_btn = view.findViewById(R.id.one_Button_PrawoFragment);
        two_btn = view.findViewById(R.id.two_Button_PrawoFragment);
        three_btn = view.findViewById(R.id.three_Button_PrawoFragment);
        four_btn = view.findViewById(R.id.four_Button_PrawoFragment);
        five_btn = view.findViewById(R.id.five_Button_PrawoFragment);
        six_btn = view.findViewById(R.id.six_Button_PrawoFragment);
        seven_btn = view.findViewById(R.id.seven_Button_PrawoFragment);
        eight_btn = view.findViewById(R.id.eight_Button_PrawoFragment);
        nine_btn = view.findViewById(R.id.nine_Button_PrawoFragment);
        ten_btn = view.findViewById(R.id.ten_Button_PrawoFragment);
        desc_linearLayout = view.findViewById(R.id.desc_LinearLayout_PrawoFragment);
        bgDesc_btn = view.findViewById(R.id.bgDesc_Button_PrawoFragment);
        desc_textView = view.findViewById(R.id.desc_TextView_PrawoFragment);

        animationManager = new AnimationManager(getContext());

        TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);


        // Handle on clicks
        handleOnClicks();


        // Handle call back
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if(descShown) {
                    handleClosingDesc();
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
        bgDesc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClosingDesc();
            }
        });

        przyzeczenie_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.przyrzeczenieKomentarz);
            }
        });

        one_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo1Komentarz);
            }
        });

        two_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo2Komentarz);
            }
        });

        three_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo3Komentarz);
            }
        });

        four_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo4Komentarz);
            }
        });

        five_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo5Komenatrz);
            }
        });

        six_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo6Komentarz);
            }
        });

        seven_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo7Komentarz);
            }
        });

        eight_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo8Komentarz);
            }
        });

        nine_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo9Komentarz);
            }
        });

        ten_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleShowingDesc(R.string.prawo10Komentarz);
            }
        });
    }


    private void handleClosingDesc() {
        if (descShown) {
            descShown = false;
            desc_linearLayout.startAnimation(animationManager.getSlideUpToDown());
            desc_linearLayout.setVisibility(View.GONE);
            bgDesc_btn.startAnimation(animationManager.getFadeOut());
            bgDesc_btn.setVisibility(View.GONE);
        }
    }


    private void handleShowingDesc(int txt) {
        if (!descShown) {
            descShown = true;
            desc_textView.setText(txt);
            desc_linearLayout.startAnimation(animationManager.getSlideDownToUp());
            desc_linearLayout.setVisibility(View.VISIBLE);
            bgDesc_btn.startAnimation(animationManager.getFadeIn());
            bgDesc_btn.setVisibility(View.VISIBLE);
        }
    }
}