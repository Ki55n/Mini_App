package com.sleeptoearn;

import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.view.View;

public class RippleUtils {
//Method to set a ripple effect on a View with the color
  public static void setRippleEffect(View view, int rippleColor) {
	if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && view != null && rippleColor != 0) {
	  Drawable drawable = view.getBackground();
	  ColorStateList colorStateList = ColorStateList.valueOf(rippleColor);
	  Drawable rippleDrawable = new RippleDrawable(colorStateList, drawable, null);
	  view.setBackground(rippleDrawable);
	}
  }
}

