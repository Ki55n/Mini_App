package com.sleeptoearn;

import android.widget.TextView;
import android.graphics.Color;

public class TextViewColorUtility {

  // Static method to set text color for a TextView
  public static void setTextColor(TextView textView, String colorHex) {
	try {
	  if(textView != null){
	  // Parse the color string in hexadecimal format
	  int color = Color.parseColor(colorHex);

	  // Set the text color for the TextView
	  textView.setTextColor(color);
	  }
	} catch (IllegalArgumentException e) {
	  // Handle invalid color format gracefully
	  e.printStackTrace();
	}
  }
}

