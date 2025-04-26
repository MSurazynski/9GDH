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
 * Use the {@link BiografiaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BiografiaFragment extends Fragment {

    // the fragment initialization parameters
    private static final String ARG_PARAM1 = "index";
    private String title;

    public BiografiaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment BiografiaFragment.
     */
    public static BiografiaFragment newInstance(String param1) {
        BiografiaFragment fragment = new BiografiaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            title = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_biografia, container, false);


        // Set variables for objects in this fragment
        FragmentManager fragmentManager = getParentFragmentManager();
        TextView title_textView = view.findViewById(R.id.title_TextView_BiografieFragment);
        ImageView image_imageView = view.findViewById(R.id.image_ImageView_BiografieFragment);
        TextView desc_textView = view.findViewById(R.id.desc_TextView_BiografieFragment);

        TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);


        // Configure the fragment
        if (title.equals("1")) {
            title_textView.setText("Robert Baden-Powell");
            image_imageView.setBackgroundResource(R.drawable.baden_powell_biografie);
            desc_textView.setText(R.string.badenPowell);
        } else if (title.equals("2")) {
            title_textView.setText("Andrzej Małkowski");
            image_imageView.setBackgroundResource(R.drawable.biografie_malkowski);
            desc_textView.setText(R.string.malkowski);
        }  else if (title.equals("3")) {
            title_textView.setText("Olga Małkowska");
            image_imageView.setBackgroundResource(R.drawable.biografie_olga);
            desc_textView.setText(R.string.olga);
        }  else if (title.equals("4")) {
            title_textView.setText("Rotmistrz Witold Pilecki");
            image_imageView.setBackgroundResource(R.drawable.biografie_pilecki);
            desc_textView.setText(R.string.pilecki);
        }  else if (title.equals("5")) {
            title_textView.setText("Kazimierz Lutosławski");
            image_imageView.setBackgroundResource(R.drawable.biografie_lutoswlawski);
            desc_textView.setText(R.string.lutoslawski);
        }  else if (title.equals("6")) {
            title_textView.setText("Stefan Wincenty Frelichowski\n");
            image_imageView.setBackgroundResource(R.drawable.biografie_frelichowski);
            desc_textView.setText(R.string.frelichowski);
        }  else if (title.equals("7")) {
            title_textView.setText("Tomasz Strzembosz");
            image_imageView.setBackgroundResource(R.drawable.biografie_strzembosz);
            desc_textView.setText(R.string.strzembosz);
        }


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
                    title_TextView_MainActivity.setText("Biografie");

                    fragmentManager.beginTransaction()
                            .setCustomAnimations(
                                    R.anim.fade_in,
                                    R.anim.fade_out,
                                    R.anim.fade_in,
                                    R.anim.fade_out
                            )
                            .replace(R.id.frame_FragmentContainerView_MainActivity, BiografieMenuFragment.class, null, "tag").commit();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);


        // Inflate the layout for this fragment
        return view;
    }
}