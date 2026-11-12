package com.ted.farmguide;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

final class Ui {
    static final int BG = 0xFF1B1B1B;
    static final int CARD = 0xFF2E2E2E;
    static final int GREEN = 0xFF6ABF40;
    static final int TEXT = 0xFFFFFFFF;
    static final int MUTED = 0xFFB0B0B0;

    private Ui() {}

    static int dp(Context c, int v) {
        return Math.round(v * c.getResources().getDisplayMetrics().density);
    }

    static TextView text(Context c, String s, int sp, int color, boolean bold) {
        TextView t = new TextView(c);
        t.setText(s);
        t.setTextSize(sp);
        t.setTextColor(color);
        if (bold) t.setTypeface(Typeface.DEFAULT_BOLD);
        return t;
    }

    static GradientDrawable box(Context c, int color) {
        GradientDrawable d = new GradientDrawable();
        d.setColor(color);
        d.setCornerRadius(dp(c, 12));
        return d;
    }

    static TextView checkStep(Context c, String s) {
        final TextView t = text(c, s, 13, TEXT, false);
        t.setBackground(box(c, CARD));
        int p = dp(c, 10);
        t.setPadding(p, p, p, p);
        final boolean[] done = {false};
        t.setOnClickListener(v -> {
            done[0] = !done[0];
            if (done[0]) {
                t.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                t.setTextColor(MUTED);
            } else {
                t.setPaintFlags(t.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                t.setTextColor(TEXT);
            }
        });
        return t;
    }

    static LinearLayout.LayoutParams lp(Context c, int topMarginDp) {
        LinearLayout.LayoutParams l = new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);
        l.topMargin = dp(c, topMarginDp);
        return l;
    }
}
