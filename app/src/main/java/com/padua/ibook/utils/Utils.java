package com.padua.ibook.utils;

import android.view.View;

import com.thekhaeng.pushdownanim.PushDownAnim;

public class Utils {

    public static void setPushDownAnimation(View view) {
        PushDownAnim.setPushDownAnimTo(view)
                .setDurationPush(PushDownAnim.DEFAULT_PUSH_DURATION)
                .setDurationRelease(PushDownAnim.DEFAULT_RELEASE_DURATION)
                .setInterpolatorPush(PushDownAnim.DEFAULT_INTERPOLATOR)
                .setInterpolatorRelease(PushDownAnim.DEFAULT_INTERPOLATOR);

    }

}
