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

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MorsFragment extends Fragment {

    public MorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment MorsFragment.
     */
    public static MorsFragment newInstance(String param1, String param2) {
        return new MorsFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_mors, container, false);


        // Set variables for objects in this fragment
        TextView encoded_TextView = view.findViewById(R.id.encoded_TextView_MorsFragment);
        EditText toEncode_EditText = view.findViewById(R.id.toEncode_EditText_MorsFragment);


        // Set on click listeners
        toEncode_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = String.valueOf(s);
                text = mors(text);
                encoded_TextView.setText(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });


        // Inflate the layout for this fragment
        return view;
    }

    /**
     * Encodes given input to morse code.
     * @param txt given string
     * @return {@code txt} encoded to morse code in string representation
     */
    static private String mors(String txt) {
        String o = "";
        txt = txt.toLowerCase();

        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);

            if (c == 'a') { o = o + ".-"; }
            else if (c == 'b') { o = o + "-..."; }
            else if (c == 'c') {
                if (i < txt.length() - 1) {
                    if (txt.charAt(i + 1) == 'h') {
                        o = o + "----";
                        i++;
                    } else {
                        o = o + "-.-.";
                    }
                } else {
                    o = o + "-.-.";
                }
            }
            else if (c == 'd') { o = o + "-.."; }
            else if (c == 'e') { o = o + "."; }
            else if (c == 'f') { o = o + "..-."; }
            else if (c == 'g') { o = o + "--."; }
            else if (c == 'h') { o = o + "...."; }
            else if (c == 'i') { o = o + ".."; }
            else if (c == 'j') { o = o + ".---"; }
            else if (c == 'k') { o = o + "-.-"; }
            else if (c == 'l') { o = o + ".-.."; }
            else if (c == 'm') { o = o + "--"; }
            else if (c == 'n') { o = o + "-."; }
            else if (c == 'o') { o = o + "---"; }
            else if (c == 'p') { o = o + ".--."; }
            else if (c == 'r') { o = o + ".-."; }
            else if (c == 's') { o = o + "..."; }
            else if (c == 't') { o = o + "-"; }
            else if (c == 'u') { o = o + "..-"; }
            else if (c == 'w') { o = o + ".--"; }
            else if (c == 'y') { o = o + "-.--"; }
            else if (c == 'z') { o = o + "--.."; }
            else if (c == ' ') {  }
            else { o = o + c; }
            o = o + "/";
        }

        return "/" + o + "/";
    }
}