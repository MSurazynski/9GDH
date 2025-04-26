package com.app.a9gdh;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.activity.OnBackPressedCallback;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StrukturaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class StrukturaFragment extends Fragment {

    private boolean OrganizacjaShown = false;
    private boolean OrganyShown = false;
    private boolean PopUpOpen = false;
    View view;
    LinearLayout lastOpen = null;

    public StrukturaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment StrukturaFragment.
     */
    public static StrukturaFragment newInstance() {
        return new StrukturaFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_struktura, container, false);

        HandleButtonsMenu();
        HandleOnClickListeners();
        HandleBackgroundButton();


        FragmentManager fragmentManager = getParentFragmentManager();

        TextView title_TextView_MainActivity = getActivity().findViewById(R.id.title_TextView_MainActivity);

        Button pelnaStruktura_Button = view.findViewById(R.id.pelnaStruktura_Button_StrukturaFragment);
        pelnaStruktura_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle args = new Bundle();
                args.putString("index", "pelna_struktura");

                title_TextView_MainActivity.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.enter_from_right));
                title_TextView_MainActivity.setText("Pełna Struktura");

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


        OnBackPressedCallback callback = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {

                // Check if info from activity is open
                MainActivity activity = (MainActivity) getActivity();
                assert activity != null;
                if (activity.is_info_open) {
                    activity.closeInfo();
                } else {

                    if(!PopUpOpen){

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
                    else{
                        Button struktura_background_button = view.findViewById(R.id.strukturaBg_Button_StrukturaFragment);
                        ConstraintLayout Struktura_PopUp_Layout = view.findViewById(R.id.popUp_ConstraintLayout_StrukturaFragment);

                        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_to_down);
                        Struktura_PopUp_Layout.startAnimation(animation);

                        struktura_background_button.setVisibility(View.GONE);
                        Struktura_PopUp_Layout.setVisibility(View.GONE);
                        close_all_customPopUp_elements();
                        PopUpOpen = false;
                    }
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(getActivity(), callback);

        // Inflate the layout for this fragment
        return view;
    }

    private void switchColoringOfButtons(Button lastSelected, Button currBtn) {

        Context context = getContext();

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
    }

    private void colorButtonAccent(Button currBtn) {

        Context context = getContext();

        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.accent_dark, null));
                currBtn.setTextColor(context.getColor(R.color.text_dark));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.accent_light, null));
                currBtn.setTextColor(context.getColor(R.color.text_dark));
                break;
        }
    }

    private void colorButtonRegular(Button currBtn) {

        Context context = getContext();

        int nightModeFlags = getResources().getConfiguration().uiMode & Configuration.UI_MODE_NIGHT_MASK;
        switch (nightModeFlags) {
            case Configuration.UI_MODE_NIGHT_YES:
                currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.bottom_layer_dark, null));
                currBtn.setTextColor(context.getColor(R.color.text_dark));
                break;
            case Configuration.UI_MODE_NIGHT_NO:
                currBtn.setBackgroundTintList(context.getResources().getColorStateList(R.color.bottom_layer_light, null));
                currBtn.setTextColor(context.getColor(R.color.text_light));
                break;
        }
    }


    /**
     * Handles onClickListeners for menu buttons.
     */
    public void HandleButtonsMenu() {

        Button organy_Button = view.findViewById(R.id.organy_Button_StrukturaFragment);
        Button organizacja_Button = view.findViewById(R.id.organizacja_Button_StrukturaFragment);

        LinearLayout organizacja_LinearLayout = view.findViewById(R.id.organizacja_LinearLayout_StrukturaFragment);
        LinearLayout organy_LinearLayout = view.findViewById(R.id.organy_LinearLayout_StrukturaFragment);
        ScrollView struktura_Scrollview = view.findViewById(R.id.struktura_Scrollview_StrukturaFragment);

        organizacja_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(OrganizacjaShown){
                    // If organizacja open, close it
                    organizacja_LinearLayout.setVisibility(View.GONE);
                    OrganizacjaShown = false;
                    colorButtonRegular(organizacja_Button);

                }else if(OrganyShown){
                    // id organy open close it, open organizacja and scroll down
                    organy_LinearLayout.setVisibility(View.GONE);
                    OrganyShown = false;
                    organizacja_LinearLayout.setVisibility(View.VISIBLE);
                    OrganizacjaShown = true;
                    switchColoringOfButtons(organy_Button, organizacja_Button);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            struktura_Scrollview.smoothScrollTo(0, struktura_Scrollview.getBottom());
                        }
                    }, 10);
                }else{
                    // if nothing open, open organizacja and scroll down
                    organizacja_LinearLayout.setVisibility(View.VISIBLE);
                    colorButtonAccent(organizacja_Button);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            struktura_Scrollview.smoothScrollTo(0, struktura_Scrollview.getBottom());
                        }
                    }, 10);
                    OrganizacjaShown = true;
                }
            }
        });

        organy_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // If organy open, close it
                if(OrganyShown){
                    organy_LinearLayout.setVisibility(View.GONE);
                    OrganyShown = false;
                    colorButtonRegular(organy_Button);

                }else if(OrganizacjaShown){
                    // if organizacja open, close it, open rogany and scroll down
                    organizacja_LinearLayout.setVisibility(View.GONE);
                    OrganizacjaShown = false;
                    switchColoringOfButtons(organizacja_Button, organy_Button);

                    organy_LinearLayout.setVisibility(View.VISIBLE);
                    OrganyShown = true;

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            struktura_Scrollview.smoothScrollTo(0, struktura_Scrollview.getBottom());
                        }
                    }, 10);
                }else{
                    // if nothing open, open organy
                    organy_LinearLayout.setVisibility(View.VISIBLE);
                    colorButtonAccent(organy_Button);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            struktura_Scrollview.smoothScrollTo(0, struktura_Scrollview.getBottom());

                        }
                    }, 10);
                    OrganyShown = true;
                }
            }
        });
    }

    /**
     * Handles background button that closes the popUp layout.
     */
    public void HandleBackgroundButton(){

        Button struktura_background_button = view.findViewById(R.id.strukturaBg_Button_StrukturaFragment);
        ConstraintLayout Struktura_PopUp_Layout = view.findViewById(R.id.popUp_ConstraintLayout_StrukturaFragment);

        struktura_background_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_up_to_down);
                Struktura_PopUp_Layout.startAnimation(animation);

                struktura_background_button.setVisibility(View.GONE);
                Struktura_PopUp_Layout.setVisibility(View.GONE);
                close_all_customPopUp_elements();

                PopUpOpen = false;
            }
        });
    }


    /**
     * Handles opening popUp layout and displaying background close button.
     */
    public void HandleMenuOpenAction() {
        Button struktura_background_button = view.findViewById(R.id.strukturaBg_Button_StrukturaFragment);
        ConstraintLayout Struktura_PopUp_Layout = view.findViewById(R.id.popUp_ConstraintLayout_StrukturaFragment);

        NestedScrollView struktura_opis_scrollview = view.findViewById(R.id.desc_ScrollView_StrukturaFragment);
        LinearLayout struktura_opis_layout = view.findViewById(R.id.desc_LinearLayout_StrukturaFragment);

        struktura_opis_scrollview.scrollTo(0, struktura_opis_layout.getTop());

        struktura_background_button.setVisibility(View.VISIBLE);
        Struktura_PopUp_Layout.setVisibility(View.VISIBLE);


        Animation animation = AnimationUtils.loadAnimation(getContext(), R.anim.slide_down_to_up);
        Struktura_PopUp_Layout.startAnimation(animation);

        PopUpOpen = true;
    }

    /**
     * Closes last opened popUp layout.
     */
    public void close_all_customPopUp_elements() {
        lastOpen.setVisibility(View.GONE);
    }


    /**
     * Handles onClicks.Listeners for list buttons.
     */
    public void HandleOnClickListeners() {

        TextView name_TextView = view.findViewById(R.id.name_TextView_StrukturaFragment);
        TextView desc_TextView = view.findViewById(R.id.desc_TextView_StrukturaFragment);

        LinearLayout naczelnik_LinearLayout = view.findViewById(R.id.naczelnik_LinearLayout_StrukturaFragment);
        LinearLayout gk_LinearLayout_StrukturaFragment = view.findViewById(R.id.glownaKwatera_LinearLayout_StrukturaFragment);
        LinearLayout chorogiew_LinearLayout = view.findViewById(R.id.chorogiew2_LinearLayout_StrukturaFragment);
        LinearLayout hufiec_LinearLayout = view.findViewById(R.id.hufiec_LinearLayout_StrukturaFragemnt);
        LinearLayout druzyna_LinearLayout = view.findViewById(R.id.druzyna_LinearLayout_StrukturaFragment);
        LinearLayout rewizjaZwiazku_LinearLayout = view.findViewById(R.id.rewizjaZwiazku_LinearLayout_StrukturaFragment);
        LinearLayout radaNaczelna_LinearLayout = view.findViewById(R.id.radaNaczelna_LinearLayout_StrukturaFragment);
        LinearLayout sad_LinearLayout = view.findViewById(R.id.sad_LinearLayout_StrukturaFragment);
        LinearLayout przewodniczacy_LinearLayout = view.findViewById(R.id.przewodniczacy_LinearLayout_StrukturaFragment);
        LinearLayout rewizjaOkregu_LinearLayout = view.findViewById(R.id.rewizjaOkregu_LinearLayout_StrukturaFragment);
        LinearLayout okreg_LinearLayout = view.findViewById(R.id.okreg_LinearLayout_StrukturaFragment);
        LinearLayout naczelnictwo_LinearLayout = view.findViewById(R.id.naczelnictwo_LinearLayout_StrukturaFragment);

        Button naczelnik_Button = view.findViewById(R.id.naczelnik_Button_StrukturaFragment);
        Button gk_Button = view.findViewById(R.id.gk_Button_StrukturaFragment);
        Button choragiew_Button = view.findViewById(R.id.choragiew_Button_StrukturaFragment);
        Button hufce_Button = view.findViewById(R.id.hufce_Button_StrukturaFragment);
        Button druzyny_Button = view.findViewById(R.id.druzyny_Button_StrukturaFragment);
        Button walnyZjazd_Button = view.findViewById(R.id.walnyZjazd_Button_StrukturaFragment);
        Button komiskaRewizyjnaZwiazku_Button = view.findViewById(R.id.komiskaRewizyjnaZwiazku_Button_StrukturaFragment);
        Button radaNaczelna_Button = view.findViewById(R.id.redaNaczelna_Button_StrukturaFragment);
        Button sadHarcerski_Button = view.findViewById(R.id.sadHarcerski_Button_StrukturaFragment);
        Button rewizjaOkregow_Button = view.findViewById(R.id.komisjaRewizyjnaOkregow_Button_StrukturaFragment);
        Button przewodniczacy_Button = view.findViewById(R.id.przewodniczacy_Button_StrukturaFragment);
        Button naczelnictwo_Button = view.findViewById(R.id.naczelnictwo_Button_StrukturaFragment);
        Button okregi_Button = view.findViewById(R.id.okregi_Button_StrukturaFragment);
        Button obwody_Button = view.findViewById(R.id.obwody_Button_StrukturaFragment);


        naczelnik_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleMenuOpenAction();
                naczelnik_LinearLayout.setVisibility(View.VISIBLE);
                lastOpen = naczelnik_LinearLayout;

                name_TextView.setText("Naczelnik Harcerzy");
                desc_TextView.setText(R.string.struktura_naczelnik_harcerzy);
            }
        });

        gk_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gk_LinearLayout_StrukturaFragment.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = gk_LinearLayout_StrukturaFragment;

                name_TextView.setText("Główna Kwatera Harcerzy");
                desc_TextView.setText(R.string.struktura_glowna_kwatera);
            }
        });

        choragiew_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chorogiew_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = chorogiew_LinearLayout;

                name_TextView.setText("Chorągiew");
                desc_TextView.setText(R.string.struktura_chorgwie);
            }
        });

        hufce_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hufiec_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = hufiec_LinearLayout;

                name_TextView.setText("Hufiec");
                desc_TextView.setText(R.string.struktura_hufiec);
            }
        });

        druzyny_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                druzyna_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = druzyna_LinearLayout;

                name_TextView.setText("Drużyna");
                desc_TextView.setText(R.string.struktura_druzyny);
            }
        });

        walnyZjazd_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleMenuOpenAction();
                lastOpen = rewizjaOkregu_LinearLayout;

                name_TextView.setText("Walny Zjazd");
                desc_TextView.setText(R.string.struktura_walny_zjazd);
            }
        });

        komiskaRewizyjnaZwiazku_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rewizjaZwiazku_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = rewizjaZwiazku_LinearLayout;

                name_TextView.setText("Komisja Rewizyjna Związku");
                desc_TextView.setText(R.string.struktura_komisja_rewizyjna_zwiazku);
            }
        });

        radaNaczelna_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                radaNaczelna_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = radaNaczelna_LinearLayout;

                name_TextView.setText("Rada Naczelna");
                desc_TextView.setText(R.string.struktura_rada_naczelna);
            }
        });

        sadHarcerski_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sad_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = sad_LinearLayout;

                name_TextView.setText("Sąd Harcerski");
                desc_TextView.setText(R.string.struktura_sad_harcerski);
            }
        });

        rewizjaOkregow_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rewizjaOkregu_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = rewizjaOkregu_LinearLayout;

                name_TextView.setText("Komisja Rewizyjna Okręgu");
                desc_TextView.setText(R.string.struktura_komisje_rewizyjne_okregow);
            }
        });

        przewodniczacy_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                przewodniczacy_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = przewodniczacy_LinearLayout;

                name_TextView.setText("Przewodniczący");
                desc_TextView.setText(R.string.struktura_przewodniczacy);
            }
        });

        naczelnictwo_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                naczelnictwo_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = naczelnictwo_LinearLayout;

                name_TextView.setText("Naczelnictwo");
                desc_TextView.setText(R.string.struktura_naczelnictwo);
            }
        });

        okregi_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                okreg_LinearLayout.setVisibility(View.VISIBLE);
                HandleMenuOpenAction();
                lastOpen = okreg_LinearLayout;

                name_TextView.setText("Okręgi");
                desc_TextView.setText(R.string.struktura_okregi);
            }
        });

        obwody_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HandleMenuOpenAction();
                lastOpen = okreg_LinearLayout;

                name_TextView.setText("Obwody");
                desc_TextView.setText(R.string.struktura_obwody);
            }
        });
    }
}