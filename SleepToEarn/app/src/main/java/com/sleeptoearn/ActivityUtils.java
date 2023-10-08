package com.sleeptoearn;

import android.content.Context;
import android.content.Intent;

public class ActivityUtils {

  /**
   * Start a new activity.
   *
   * @param context The current context.
   * @param targetActivityClass The class of the target activity.
   */
  public static void moveToActivity(Context context, Class<?> targetActivityClass) {
	Intent intent = new Intent(context, targetActivityClass);
	context.startActivity(intent);
  }
}

