package com.poomgames.catfore.presentation.see;

import android.net.Uri;
import android.webkit.ValueCallback;

public interface Cam {
    void cam(ValueCallback<Uri[]> filePat, Boolean cam);
}
