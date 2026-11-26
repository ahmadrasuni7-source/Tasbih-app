package com.ahmad.tasbih;

import android.view.KeyEvent;
import com.getcapacitor.BridgeActivity;

public class MainActivity extends BridgeActivity {
    private boolean isVol(int k) {
        return k == KeyEvent.KEYCODE_VOLUME_UP || k == KeyEvent.KEYCODE_VOLUME_DOWN;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (isVol(keyCode)) {
            if (event.getRepeatCount() == 0 && getBridge() != null && getBridge().getWebView() != null) {
                getBridge().getWebView().evaluateJavascript(
                    "window.dispatchEvent(new KeyboardEvent('keydown',{key:'AudioVolumeUp'}))", null);
            }
            return true; // tombol volume tidak mengubah volume sistem, hanya menghitung
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (isVol(keyCode)) return true;
        return super.onKeyUp(keyCode, event);
    }
}
