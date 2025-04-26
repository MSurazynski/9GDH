package com.app.a9gdh;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;
import com.github.barteksc.pdfviewer.scroll.DefaultScrollHandle;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link PDFViewerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class PDFViewerFragment extends Fragment {

    private static final String ARG_PARAM1 = "index";

    private String index;

    public PDFViewerFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment StrukturaPelnaFragment.
     */
    public static PDFViewerFragment newInstance(String param1, String param2) {
        PDFViewerFragment fragment = new PDFViewerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Set local variables
        View view = inflater.inflate(R.layout.fragment_pdf_viewer, container, false);
        FragmentManager fragmentManager = getParentFragmentManager();


        // Load pdf
        loadPDF(view);


        // Manage back button
        handleButton(view, fragmentManager);


        // Manage back gesture
        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                manageReturn(fragmentManager);
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);


        // Inflate the layout for this fragment
        return view;
    }



    private void handleButton(View view, FragmentManager fragmentManager) {
        ImageButton back_ImageButton = view.findViewById(R.id.back_ImageButton_PDFViewer);

        // Set correct color
        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                back_ImageButton.setImageResource(R.drawable.ic_arrow_back_dark);
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                back_ImageButton.setImageResource(R.drawable.ic_arrow_back_light);
                break;
        }

        back_ImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                manageReturn(fragmentManager);
            }
        });
    }


    /**
     * Load correct pdf.
     *
     * @param view view
     */
    private void loadPDF(View view) {
        PDFView sprawnosci_pdfView_pdfView= view.findViewById(R.id.frame_PDFViewer_StrukturaPelna);

        // Load PDF
        if (index.equals("pelna_struktura")) {

            sprawnosci_pdfView_pdfView.fromAsset("struktura.pdf")
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(new DefaultScrollHandle(getContext()))
                    .load();
        } else if (index.equals("statut")) {

            sprawnosci_pdfView_pdfView.fromAsset("statut.pdf")
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(new DefaultScrollHandle(getContext()))
                    .load();
        } else if (index.equals("musztra")) {

            sprawnosci_pdfView_pdfView.fromAsset("musztra_regulamin.pdf")
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(new DefaultScrollHandle(getContext()))
                    .load();
        } else if (index.equals("sprawnosci")) {

            sprawnosci_pdfView_pdfView.fromAsset("sprawnosci.pdf")
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(new DefaultScrollHandle(getContext()))
                    .load();
        } else if (index.equals("mundur")) {

            sprawnosci_pdfView_pdfView.fromAsset("mundur_regulamin.pdf")
                    .enableSwipe(true)
                    .swipeHorizontal(false)
                    .enableAnnotationRendering(true)
                    .scrollHandle(new DefaultScrollHandle(getContext()))
                    .load();
        }
    }

    /**
     * When quiting this fragment change title and enter correct fragment.
     *
     * @param fragmentManager fragmentManager
     */
    private void manageReturn(FragmentManager fragmentManager) {
        // Check if info from activity is open
        MainActivity activity = (MainActivity) getActivity();
        assert activity != null;
        if (activity.is_info_open) {
            activity.closeInfo();
        } else {

            if (index.equals("pelna_struktura")) {

                TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);
                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Struktura i Funkcje");

                fragmentManager.beginTransaction()
                        .setCustomAnimations(
                                R.anim.fade_in,
                                R.anim.fade_out,
                                R.anim.fade_in,
                                R.anim.fade_out
                        )
                        .replace(R.id.frame_FragmentContainerView_MainActivity, StrukturaFragment.class, null, "tag").commit();

            } else {

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
    }
}