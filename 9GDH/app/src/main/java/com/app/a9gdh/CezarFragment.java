package com.app.a9gdh;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CezarFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CezarFragment extends Fragment {

    private int shift = 3;
    static private String alphabet = "abcdefghijklmnoprstuwyz";

    private Button encode_Button;
    private TextView encoded_TextView;
    private EditText toEncode_EditText;
    private ImageButton left_Button;
    private ImageButton right_Button;
    private TextView shift_TextView;

    public CezarFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment.
     *
     * @return A new instance of fragment CezarFragment.
     */
    public static CezarFragment newInstance(String param1, String param2) {
        return new CezarFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_cezar, container, false);


        // Set variables for objects in this fragment
        encoded_TextView = view.findViewById(R.id.encoded_TextView_CezarFragment);
        toEncode_EditText = view.findViewById(R.id.toEncode_EditText_CezarFragment);
        left_Button = view.findViewById(R.id.left_Button_CezarFragment);
        right_Button = view.findViewById(R.id.right_Button_CezarFragment);
        shift_TextView = view.findViewById(R.id.shift_TextView_CezarFragment);


        // Set on click listeners
        handleOnClickListeners();


        // Inflate the layout for this fragment
        return view;
    }


    private void handleOnClickListeners() {

        toEncode_EditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String text = String.valueOf(s);
                text = cezar(text, shift);
                encoded_TextView.setText(text);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        right_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shift < alphabet.length() - 1) {
                    shift++;

                    setShiftTextView(shift, shift_TextView);
                    String text = String.valueOf(toEncode_EditText.getText());
                    text = cezar(text, shift);
                    encoded_TextView.setText(text);
                }
            }
        });

        left_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (shift > -alphabet.length() + 1) {
                    shift--;

                    setShiftTextView(shift, shift_TextView);
                    String text = String.valueOf(toEncode_EditText.getText());
                    text = cezar(text, shift);
                    encoded_TextView.setText(text);
                }
            }
        });
    }


    private void setShiftTextView(int shift, TextView textView) {
        if (shift == 0) {
            textView.setText("Brak przesunięcia");
        } else if (shift < 0) {
            textView.setText("W lewo o " + String.valueOf(-shift));
        } else {
            textView.setText("W prawo o " + String.valueOf(shift));
        }
    }


    private String cezar(String txt, int shift) {
        String alphabet = "abcdefghijklmnoprstuwyz";
        String o = "";
        txt = txt.toLowerCase();

        for (int i = 0; i < txt.length(); i++) {
            char c = txt.charAt(i);
            if (alphabet.indexOf(c) != -1) {

                int pos = alphabet.indexOf(c);

                pos = pos + shift;

                if (pos > alphabet.length() - 1) {
                    pos = pos % alphabet.length();
                } else if (pos < 0) {
                    pos = alphabet.length() + pos;
                }

                o = o + alphabet.charAt(pos);
            } else {
                o = o + c;
            }
        }

        return o;
    }
}