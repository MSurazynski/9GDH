package com.app.a9gdh;

import android.content.Context;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class AnimationManager {

    private Animation slideDownToUp;
    private Animation slideUpToDown;
    private Animation fadeIn;
    private Animation fadeOut;
    private Animation slideCenterToTop;
    private Animation slideBottomToCenter;

    AnimationManager(Context context) {
        slideDownToUp = AnimationUtils.loadAnimation(context, R.anim.slide_down_to_up);
        slideUpToDown = AnimationUtils.loadAnimation(context, R.anim.slide_up_to_down);
        fadeIn = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        fadeOut = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        slideCenterToTop = AnimationUtils.loadAnimation(context, R.anim.slide_center_to_top);
        slideBottomToCenter = AnimationUtils.loadAnimation(context, R.anim.slide_bottom_to_center);
    }

    public Animation getSlideDownToUp() {
        return slideDownToUp;
    }

    public Animation getSlideUpToDown() {
        return slideUpToDown;
    }

    public Animation getFadeIn() {
        return fadeIn;
    }

    public Animation getFadeOut() {
        return fadeOut;
    }

    public Animation getSlideCenterToTop() {
        return slideCenterToTop;
    }

    public Animation getSlideBottomToCenter() {
        return slideBottomToCenter;
    }
}
