package com.sleeptoearn;

import android.content.Context;
import android.view.View;

public class BackgroundUtils {

  // Method to set the background image for a View
  public static void setBackgroundImage(Context context, View view, int drawableResourceId) {
	if (view != null) {
	  view.setBackgroundResource(drawableResourceId);
	}
  }
}

