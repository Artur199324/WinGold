package com.poomgames.catfore.presentation.see;

import android.annotation.SuppressLint;

import com.poomgames.catfore.presentation.activities.WorldCupActivity;

public class WeSeee {

    private final WorldCupActivity worldCupActivity;

    public WeSeee(WorldCupActivity worldCupActivity) {
        this.worldCupActivity = worldCupActivity;
    }

    @SuppressLint("SetJavaScriptEnabled")
    protected void wee() {
        worldCupActivity.webView.getSettings().setMixedContentMode(0);
        worldCupActivity.webView.getSettings().setJavaScriptEnabled(true);
        worldCupActivity.webView.getSettings().setDomStorageEnabled(true);
        worldCupActivity.webView.getSettings().setLoadsImagesAutomatically(true);
        worldCupActivity.webView.getSettings().setDatabaseEnabled(true);
        worldCupActivity.webView.getSettings().setUseWideViewPort(true);
        worldCupActivity.webView.getSettings().setAllowFileAccess(true);
        worldCupActivity.webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
    }

    protected void eeww() {
        worldCupActivity.webView.getSettings().setLoadWithOverviewMode(true);
        worldCupActivity.webView.getSettings().setAllowContentAccess(true);
        worldCupActivity.webView.getSettings().setSupportMultipleWindows(false);
        worldCupActivity.webView.getSettings().setBuiltInZoomControls(true);
        worldCupActivity.webView.getSettings().setDisplayZoomControls(false);
    }
}
