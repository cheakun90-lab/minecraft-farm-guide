package com.ted.farmguide;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.Gravity;
import android.widget.Toast;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ScrollView scroll = new ScrollView(this);
        scroll.setBackgroundColor(Ui.BG);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(LinearLayout.VERTICAL);
        int pad = Ui.dp(this, 16);
        root.setPadding(pad, pad, pad, pad);
        scroll.addView(root);

        ImageView pic = new ImageView(this);
        pic.setImageResource(R.drawable.ted);
        pic.setScaleType(ImageView.ScaleType.FIT_CENTER);
        LinearLayout.LayoutParams pl = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, Ui.dp(this, 200));
        pl.topMargin = Ui.dp(this, 8);
        root.addView(pic, pl);

        TextView title = Ui.text(this, "Minecraft Farm Guide", 26, Ui.GREEN, true);
        root.addView(title, Ui.lp(this, 12));

        TextView sub = Ui.text(this, "Tap a farm to see what you need and how to build it.", 14, Ui.MUTED, false);
        root.addView(sub, Ui.lp(this, 4));

        TextView overlayBtn = Ui.text(this, "Show over Minecraft", 16, 0xFF000000, true);
        overlayBtn.setGravity(Gravity.CENTER);
        overlayBtn.setBackground(Ui.box(this, Ui.GREEN));
        int bp = Ui.dp(this, 14);
        overlayBtn.setPadding(bp, bp, bp, bp);
        overlayBtn.setOnClickListener(v -> startOverlay());
        root.addView(overlayBtn, Ui.lp(this, 16));

        for (int i = 0; i < Guides.ALL.length; i++) {
            final int index = i;
            Guides.Guide g = Guides.ALL[i];

            LinearLayout card = new LinearLayout(this);
            card.setOrientation(LinearLayout.VERTICAL);
            card.setBackground(Ui.box(this, Ui.CARD));
            int cp = Ui.dp(this, 14);
            card.setPadding(cp, cp, cp, cp);

            card.addView(Ui.text(this, g.name, 18, Ui.TEXT, true));
            card.addView(Ui.text(this, g.tagline, 13, Ui.MUTED, false), Ui.lp(this, 2));

            card.setOnClickListener(v -> {
                Intent it = new Intent(MainActivity.this, DetailActivity.class);
                it.putExtra("i", index);
                startActivity(it);
            });

            root.addView(card, Ui.lp(this, 12));
        }

        setContentView(scroll);
    }

    private void startOverlay() {
        if (Build.VERSION.SDK_INT >= 23 && !Settings.canDrawOverlays(this)) {
            Toast.makeText(this, "Turn on 'Display over other apps', then tap the button again", Toast.LENGTH_LONG).show();
            startActivity(new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName())));
            return;
        }
        if (Build.VERSION.SDK_INT >= 33
                && checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS) != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(new String[]{Manifest.permission.POST_NOTIFICATIONS}, 1);
        }
        Intent s = new Intent(this, OverlayService.class);
        if (Build.VERSION.SDK_INT >= 26) startForegroundService(s);
        else startService(s);
        Toast.makeText(this, "Overlay started. Open Minecraft.", Toast.LENGTH_SHORT).show();
        moveTaskToBack(true);
    }
}
