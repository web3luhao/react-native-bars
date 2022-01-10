package com.rnbarsexample;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.zoontek.rnbars.RNBars;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ReactActivity {
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    new Timer().schedule(new TimerTask() {
      @Override
      public void run() {
        // here goes your code to delay
        runOnUiThread(() -> {
          Window window = getWindow();
          if (window != null) {
            window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING);
          }
        });
      }
    }, 4000L);
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "RNBarsExample";
  }

  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new ReactActivityDelegate(this, getMainComponentName()) {

      @Override
      protected void loadApp(String appKey) {
        super.loadApp(appKey);
        RNBars.init(MainActivity.this, "dark-content");
      }
    };
  }
}
