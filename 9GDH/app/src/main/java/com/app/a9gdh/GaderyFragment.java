package com.app.a9gdh;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link GaderyFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GaderyFragment extends Fragment {

    // the fragment initialization parameters
    private static final String ARG_PARAM1 = "szyfr";

    private String type;

    public GaderyFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameter.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment GaderyFragment.
     */
    public static GaderyFragment newInstance(String param1) {
        GaderyFragment fragment = new GaderyFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gadery, container, false);


        // Set variables for objects in this fragment
        TextView encoded_TextView = view.findViewById(R.id.encoded_TextView_GaderyFragment);
        EditText toEncode_EditText = view.findViewById(R.id.toEncode_EditText_GaderyFragment);

        toEncode_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = String.valueOf(s);
                text = encode(text, type);
                encoded_TextView.setText(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    static private String encode(String txt, String type) {

        String o = "";
        txt = txt.toLowerCase();

        if (type == null) {
            type = "gadery";
        }

        if (type.equals("gadery")) {

            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);

                if (c == 'g') { o = o + "a"; }
                else if (c == 'a') { o = o + "g"; }
                else if (c == 'd') { o = o + "e"; }
                else if (c == 'e') { o = o + "d"; }
                else if (c == 'r') { o = o + "y"; }
                else if (c == 'y') { o = o + "r"; }
                else if (c == 'p') { o = o + "o"; }
                else if (c == 'o') { o = o + "p"; }
                else if (c == 'l') { o = o + "u"; }
                else if (c == 'u') { o = o + "l"; }
                else if (c == 'k') { o = o + "i"; }
                else if (c == 'i') { o = o + "k"; }
                else { o = o + String.valueOf(c); }
            }
        } else if (type.equals("malinowe")) {

            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);

                if (c == 'm') { o = o + "a"; }
                else if (c == 'a') { o = o + "m"; }
                else if (c == 'l') { o = o + "i"; }
                else if (c == 'i') { o = o + "l"; }
                else if (c == 'n') { o = o + "o"; }
                else if (c == 'o') { o = o + "n"; }
                else if (c == 'w') { o = o + "e"; }
                else if (c == 'e') { o = o + "w"; }
                else if (c == 'b') { o = o + "u"; }
                else if (c == 'u') { o = o + "b"; }
                else if (c == 't') { o = o + "y"; }
                else if (c == 'y') { o = o + "t"; }
                else { o = o + String.valueOf(c); }
            }
        } else if (type.equals("polityka")) {

            for (int i = 0; i < txt.length(); i++) {
                char c = txt.charAt(i);

                if (c == 'p') { o = o + "o"; }
                else if (c == 'o') { o = o + "p"; }
                else if (c == 'l') { o = o + "i"; }
                else if (c == 'i') { o = o + "l"; }
                else if (c == 't') { o = o + "y"; }
                else if (c == 'y') { o = o + "t"; }
                else if (c == 'k') { o = o + "a"; }
                else if (c == 'a') { o = o + "k"; }
                else if (c == 'r') { o = o + "e"; }
                else if (c == 'e') { o = o + "r"; }
                else if (c == 'n') { o = o + "u"; }
                else if (c == 'u') { o = o + "n"; }
                else { o = o + String.valueOf(c); }
            }
        } else {
            return txt;
        }

        return o;
    }
}