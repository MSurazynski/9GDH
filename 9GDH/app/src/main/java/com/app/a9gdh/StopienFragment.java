package com.app.a9gdh;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StopienFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StopienFragment extends Fragment {

    // the fragment initialization parameters
    private static final String param = "index";

    private String index;

    private FragmentManager fragmentManager;

    private TextView title_TextView;
    private TextView visual_TextView;
    private ImageView image_ImageView;
    private TextView desc_TextView;


    public StopienFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment StopienFragment.
     */
    public static StopienFragment newInstance(String param1, String param2) {
        StopienFragment fragment = new StopienFragment();
        Bundle args = new Bundle();
        args.putString(param, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getString(param);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stopien, container, false);


        // Set global variables
        fragmentManager = getParentFragmentManager();
        title_TextView = view.findViewById(R.id.title_TextView_StopienFragment);
        image_ImageView = view.findViewById(R.id.image_ImageView_StopienFragment);
        desc_TextView = view.findViewById(R.id.desc_TextView_StopienFragment);
        visual_TextView = view.findViewById(R.id.visual_TextView_StopienFragment);

        TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);


        // Handle init
        handleInit();


        // Handle on back pressed
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Stopnie");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StopnieMenuFragment.class, null, "tag").commit();
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);


        // Inflate the layout for this fragment
        return view;
    }


    private void handleInit() {
        if (index.equals("1")) {

            title_TextView.setText("Młodzik");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_mlodzik_v2);
            visual_TextView.setText(R.string.stopnie_oznaczenie_mlodzik);
            desc_TextView.setText(R.string.stopnie_idea_mlodzik);
        } else if (index.equals("2")) {

            title_TextView.setText("Wywiadowca");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_wywiadowca_v2);
            visual_TextView.setText(R.string.stopnie_oznaczenie_wyw);
            desc_TextView.setText(R.string.stopnie_idea_wyw);
        } else if (index.equals("3")) {

            title_TextView.setText("Ćwik");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_cwik_v2);
            visual_TextView.setText(R.string.stopnie_oznaczenie_cw);
            desc_TextView.setText(R.string.stopnie_idea_cw);
        } else if (index.equals("4")) {

            title_TextView.setText("Harcerz Orli");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_ho_v2);
            visual_TextView.setText(R.string.stopnie_oznaczenie_ho);
            desc_TextView.setText(R.string.stopnie_idea_ho);
        } else if (index.equals("5")) {

            title_TextView.setText("Harcerz Rzeczpospolitej");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_hr_v2);
            visual_TextView.setText(R.string.stopnie_oznaczenie_hr);
            desc_TextView.setText(R.string.stopnie_idea_hr);
        } else if (index.equals("6")) {

            title_TextView.setText("Przewodnik");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_pwd);
            visual_TextView.setText(R.string.stopnie_oznaczenie_pwd);
            desc_TextView.setText(R.string.stopnie_idea_pwd);
        } else if (index.equals("7")) {

            title_TextView.setText("Podharcmistrz");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_phm);
            visual_TextView.setText(R.string.stopnie_oznaczenie_phm);
            desc_TextView.setText(R.string.stopnie_idea_phm);
        } else if (index.equals("8")) {

            title_TextView.setText("Harcmistrz");
            image_ImageView.setBackgroundResource(R.drawable.stopnie_hm);
            visual_TextView.setText(R.string.stopnie_oznaczenie_hm);
            desc_TextView.setText(R.string.stopnie_idea_hm);
        }
    }
}