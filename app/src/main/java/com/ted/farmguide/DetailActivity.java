package com.ted.farmguide;

import android.app.Activity;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        int index = getIntent().getIntExtra("i", 0);
        if (index < 0 || index >= Guides.ALL.length) index = 0;
        Guides.Guide g = Guides.ALL[index];

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Ui.BG);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        int pad = Ui.dp(this, 16);
        root.setPadding(pad, pad, pad, pad * 2);
        scroll.addView(root);

        TextView back = Ui.text(this, "< Back", 16, Ui.GREEN, true);
        back.setPadding(0, Ui.dp(this, 8), Ui.dp(this, 16), Ui.dp(this, 8));
        back.setOnClickListener(v -> finish());
        root.addView(back);

        root.addView(Ui.text(this, g.name, 26, Ui.TEXT, true), Ui.lp(this, 8));
        root.addView(Ui.text(this, g.tagline, 14, Ui.MUTED, false), Ui.lp(this, 4));

        root.addView(Ui.text(this, "You need", 18, Ui.GREEN, true), Ui.lp(this, 20));
        for (String m : g.materials) {
            root.addView(Ui.text(this, "• " + m, 15, Ui.TEXT, false), Ui.lp(this, 4));
        }

        root.addView(Ui.text(this, "Steps (tap to check off)", 18, Ui.GREEN, true), Ui.lp(this, 20));
        int n = 1;
        for (String s : g.steps) {
            final TextView t = Ui.text(this, n + ". " + s, 15, Ui.TEXT, false);
            t.setBackground(Ui.box(this, Ui.CARD));
            int cp = Ui.dp(this, 12);
            t.setPadding(cp, cp, cp, cp);

            final boolean[] done = {false};
            t.setOnClickListener(v -> {
                done[0] = !done[0];
                if (done[0]) {
                    t.setPaintFlags(t.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
                    t.setTextColor(Ui.MUTED);
                } else {
                    t.setPaintFlags(t.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
                    t.setTextColor(Ui.TEXT);
                }
            });

            root.addView(t, Ui.lp(this, 8));
            n++;
        }

        setContentView(scroll);
    }
}
