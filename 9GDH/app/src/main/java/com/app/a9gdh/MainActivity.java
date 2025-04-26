package com.app.a9gdh;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.OnBackPressedCallback;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private Button bgMain;
    private LinearLayout info;
    private AnimationManager animationManager;
    private ImageView logo;

    public boolean is_info_open = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        // Objects in the main activity
        FragmentManager fragmentManager = getSupportFragmentManager();


        // Back press function
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {

            }
        };
        getOnBackPressedDispatcher().addCallback(this, callback);


        bgMain = findViewById(R.id.bgMain);
        info = findViewById(R.id.info_Main);
        logo = findViewById(R.id.logo_ImageView_MainActivity);

        animationManager = new AnimationManager(this);

        logo.setOnClickListener(v -> {
            if (!is_info_open) {
                openInfo();
            }
        });

        bgMain.setOnClickListener(v -> {
            if (is_info_open) {
                closeInfo();
            }
        });
    }

    public void openInfo() {
        is_info_open = true;
        info.startAnimation(animationManager.getFadeIn());
        info.setVisibility(View.VISIBLE);
        bgMain.startAnimation(animationManager.getFadeIn());
        bgMain.setVisibility(View.VISIBLE);
    }

    public void closeInfo() {
        is_info_open = false;
        info.startAnimation(animationManager.getFadeOut());
        info.setVisibility(View.INVISIBLE);
        bgMain.startAnimation(animationManager.getFadeOut());
        bgMain.setVisibility(View.INVISIBLE);
    }
}