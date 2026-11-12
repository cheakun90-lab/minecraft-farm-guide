package com.ted.farmguide;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.os.IBinder;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class OverlayService extends Service {

    private WindowManager wm;
    private WindowManager.LayoutParams params;
    private FrameLayout rootView;
    private LinearLayout panel;
    private ImageView bubble;
    private ScrollView scroll;
    private LinearLayout content;
    private int panelW, panelH, bubbleSize;

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        startForeground(1, buildNotification());
        if (rootView == null) createOverlay();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        if (rootView != null && wm != null) {
            try {
                wm.removeView(rootView);
            } catch (Exception ignored) {
            }
            rootView = null;
        }
        super.onDestroy();
    }

    private Notification buildNotification() {
        String ch = "farm_overlay";
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel c = new NotificationChannel(ch, "Farm Guide overlay", NotificationManager.IMPORTANCE_LOW);
            getSystemService(NotificationManager.class).createNotificationChannel(c);
        }
        Notification.Builder b = Build.VERSION.SDK_INT >= 26
                ? new Notification.Builder(this, ch)
                : new Notification.Builder(this);
        b.setSmallIcon(R.drawable.ted)
                .setContentTitle("Farm Guide is floating")
                .setContentText("Tap X on the overlay to close it");
        return b.build();
    }

    private void createOverlay() {
        wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        panelW = Math.min(Ui.dp(this, 300), (int) (dm.widthPixels * 0.8f));
        panelH = Math.min(Ui.dp(this, 420), (int) (dm.heightPixels * 0.8f));
        bubbleSize = Ui.dp(this, 72);

        int type = Build.VERSION.SDK_INT >= 26
                ? WindowManager.LayoutParams.TYPE_APPLICATION_OVERLAY
                : WindowManager.LayoutParams.TYPE_PHONE;

        params = new WindowManager.LayoutParams(
                panelW, panelH, type,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);
        params.gravity = Gravity.TOP | Gravity.START;
        params.x = Ui.dp(this, 16);
        params.y = Ui.dp(this, 48);

        rootView = new FrameLayout(this);

        panel = new LinearLayout(this);
        panel.setOrientation(LinearLayout.VERTICAL);
        panel.setBackground(Ui.box(this, Ui.BG));
        int pp = Ui.dp(this, 8);
        panel.setPadding(pp, pp, pp, pp);

        LinearLayout header = new LinearLayout(this);
        header.setOrientation(LinearLayout.HORIZONTAL);
        header.setGravity(Gravity.CENTER_VERTICAL);

        TextView titleView = Ui.text(this, "Farm Guide (drag me)", 14, Ui.GREEN, true);
        titleView.setPadding(pp, pp, pp, pp);
        header.addView(titleView, new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT, 1f));
        makeDraggable(titleView);

        TextView minBtn = Ui.text(this, "–", 20, Ui.TEXT, true);
        minBtn.setPadding(pp * 2, 0, pp * 2, 0);
        minBtn.setOnClickListener(v -> setMinimized(true));
        header.addView(minBtn);

        TextView closeBtn = Ui.text(this, "X", 16, Ui.TEXT, true);
        closeBtn.setPadding(pp * 2, 0, pp * 2, 0);
        closeBtn.setOnClickListener(v -> stopSelf());
        header.addView(closeBtn);

        panel.addView(header);

        scroll = new ScrollView(this);
        content = new LinearLayout(this);
        content.setOrientation(LinearLayout.VERTICAL);
        scroll.addView(content);
        panel.addView(scroll, new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, 0, 1f));

        bubble = new ImageView(this);
        bubble.setImageResource(R.drawable.ted);
        bubble.setBackground(Ui.box(this, Ui.BG));
        bubble.setVisibility(View.GONE);
        bubble.setOnClickListener(v -> setMinimized(false));
        makeDraggable(bubble);

        rootView.addView(panel, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        rootView.addView(bubble, new FrameLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        wm.addView(rootView, params);
        showList();
    }

    private void setMinimized(boolean min) {
        panel.setVisibility(min ? View.GONE : View.VISIBLE);
        bubble.setVisibility(min ? View.VISIBLE : View.GONE);
        params.width = min ? bubbleSize : panelW;
        params.height = min ? bubbleSize : panelH;
        wm.updateViewLayout(rootView, params);
    }

    private void makeDraggable(View handle) {
        handle.setOnTouchListener(new View.OnTouchListener() {
            int startX, startY;
            float touchX, touchY;
            boolean moved;

            @Override
            public boolean onTouch(View v, MotionEvent e) {
                switch (e.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        startX = params.x;
                        startY = params.y;
                        touchX = e.getRawX();
                        touchY = e.getRawY();
                        moved = false;
                        return true;
                    case MotionEvent.ACTION_MOVE:
                        int dx = (int) (e.getRawX() - touchX);
                        int dy = (int) (e.getRawY() - touchY);
                        if (Math.abs(dx) > 10 || Math.abs(dy) > 10) moved = true;
                        params.x = startX + dx;
                        params.y = startY + dy;
                        wm.updateViewLayout(rootView, params);
                        return true;
                    case MotionEvent.ACTION_UP:
                        if (!moved) v.performClick();
                        return true;
                }
                return false;
            }
        });
    }

    private void showList() {
        content.removeAllViews();
        for (int i = 0; i < Guides.ALL.length; i++) {
            final int index = i;
            Guides.Guide g = Guides.ALL[i];
            TextView t = Ui.text(this, g.name, 15, Ui.TEXT, true);
            t.setBackground(Ui.box(this, Ui.CARD));
            int p = Ui.dp(this, 12);
            t.setPadding(p, p, p, p);
            t.setOnClickListener(v -> showGuide(index));
            content.addView(t, Ui.lp(this, 6));
        }
        scroll.scrollTo(0, 0);
    }

    private void showGuide(int i) {
        Guides.Guide g = Guides.ALL[i];
        content.removeAllViews();
        int p = Ui.dp(this, 8);

        TextView back = Ui.text(this, "< All farms", 14, Ui.GREEN, true);
        back.setPadding(0, p, p * 2, p);
        back.setOnClickListener(v -> showList());
        content.addView(back);

        content.addView(Ui.text(this, g.name, 18, Ui.TEXT, true));
        content.addView(Ui.text(this, "You need", 14, Ui.GREEN, true), Ui.lp(this, 10));
        for (String m : g.materials) {
            content.addView(Ui.text(this, "• " + m, 13, Ui.TEXT, false), Ui.lp(this, 2));
        }
        content.addView(Ui.text(this, "Steps (tap to check off)", 14, Ui.GREEN, true), Ui.lp(this, 10));
        int n = 1;
        for (String s : g.steps) {
            content.addView(Ui.checkStep(this, n + ". " + s), Ui.lp(this, 6));
            n++;
        }
        scroll.scrollTo(0, 0);
    }
}
