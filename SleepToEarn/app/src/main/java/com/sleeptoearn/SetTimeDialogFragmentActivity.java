package com.sleeptoearn;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import java.io.*;
import java.text.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;
import androidx.viewpager2.widget.*;

/*This is the class to set the hours time that you want to sleep,
it shows it as a DialogFragment*/

public class SetTimeDialogFragmentActivity extends DialogFragment {
	
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	private String hours = "";
	private int sleep_hours = 0;
	private int hours2 = 0;
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private CardView cardview1;
	private LinearLayout linear1;
	private TextView time;
	private LinearLayout layout;
	private LinearLayout linear2;
	private TimePicker timePicker;
	private TextView hours_texview;
	private TextView cancel;
	private TextView ok;
	
	private SharedPreferences preference;
	private Calendar callendar = Calendar.getInstance();
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.set_time_dialog_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		 // Get the dialog's window attributes
		    Window window = getDialog().getWindow();
		    if (window != null) {
			        WindowManager.LayoutParams params = window.getAttributes();
			
			        // Set the desired width and height for the dialog
			        params.width = SketchwareUtil.getDisplayWidthPixels(getContext().getApplicationContext()) - 8; // Set your desired width
			        params.height = 550; // Set your desired height
			        window.setAttributes(params);
		}
		cardview1 = _view.findViewById(R.id.cardview1);
		linear1 = _view.findViewById(R.id.linear1);
		time = _view.findViewById(R.id.time);
		layout = _view.findViewById(R.id.layout);
		linear2 = _view.findViewById(R.id.linear2);
		timePicker = _view.findViewById(R.id.timePicker);
		hours_texview = _view.findViewById(R.id.hours_texview);
		cancel = _view.findViewById(R.id.cancel);
		ok = _view.findViewById(R.id.ok);
		preference = getContext().getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
		
		timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
			@Override
			public void onTimeChanged(TimePicker _timePicker, int _hour, int _minute) {
				hours2 = _hour;
				hours = String.valueOf((int)(_hour));
				hours_texview.setText("Sleeping hours:- ".concat(hours.concat(" hours")));
			}
		});
		
		cancel.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Dismisses the DialogFragment
				_dismiss_DialogFragment();
			}
		});
		
		ok.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_saveData();
			}
		});
	}
	
	private void initializeLogic() {
		if (getDialog() != null) { 
			int width = ViewGroup.LayoutParams.MATCH_PARENT;
			int height = ViewGroup.LayoutParams.MATCH_PARENT; 
			 getDialog().getWindow().setLayout(width, height);
			getDialog().getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
		}
		
		RippleUtils.setRippleEffect(ok, rippleColor);
		RippleUtils.setRippleEffect(cancel, rippleColor);
		cardview1.setCardBackgroundColor(0xFF2E3A4A);
	}
	
	public void _dismiss_DialogFragment() {
		//Code to dismiss this DialogFragment
		dismiss();
	}
	
	/*This code performs this action after you clicked the OK button
	it checks the time you picked, if the time you picked isn't greater than
	0 it show a toast message else it saves the data to SharedPreference,
	this data would be used in the achievementTask amd also in the BarChart View*/
	public void _saveData() {
		callendar = Calendar.getInstance();
		if (!preference.getString("date", "").equals(new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()))) {
			if (hours2 > 0) {
				preference.edit().putBoolean("isChanged", true).commit();
				
				long currentTimeMillis = callendar.getTimeInMillis();
				   
				preference.edit().putLong("bedtimeMillis", currentTimeMillis).commit();
				
				preference.edit().putBoolean("alreadyTicked", false).commit();

				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Mon")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_mon", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_mon", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Tue")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_tue", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_tue",Integer.parseInt( new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Wed")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_wed", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_wed", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Thu")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_thu", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_thu", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Fri")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_fri", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_fri", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Sat")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_sat", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_sat", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
				if (new SimpleDateFormat("EEE").format(callendar.getTime()).equals("Sun")) {
					preference.edit().putString("dayOfWeek", new SimpleDateFormat("EEE").format(callendar.getTime())).commit();
					preference.edit().putString("date", new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime())).commit();
					preference.edit().putInt("sleep_hours_sun", Integer.parseInt(hours)).commit();
					
					preference.edit().putInt("hours_sun", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
				}
			}
			else {
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "Please set the time hours or press the cancel button");
			}
		}
		else {
			if (hours2 > 0) {
				preference.edit().putBoolean("isChanged", true).commit();
				
				long currentTimeMillis = callendar.getTimeInMillis();
				
				preference.edit().putLong("bedtimeMillis", currentTimeMillis).commit();

				if (preference.getString("dayOfWeek", "").equals("Mon")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_mon", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_mon", 0);
					
					preference.edit().putInt("sleep_hours_mon", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_mon", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Tue")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_tue", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_tue", 0);
					
					preference.edit().putInt("sleep_hours_tue", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_tue", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Wed")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_wed", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_wed", 0);
					
					preference.edit().putInt("sleep_hours_wed", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_wed", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Thu")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_thu", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_thu", 0);
					
					preference.edit().putInt("sleep_hours_thu", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_thu", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Fri")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_fri", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_fri", 0);
					
					preference.edit().putInt("sleep_hours_fri", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_fri", Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Sat")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_sat", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_sat", 0);
					
					preference.edit().putInt("sleep_hours_sat", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_sat",Integer.parseInt( new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
				if (preference.getString("dayOfWeek", "").equals("Sun")) {
					int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
					
					int token_awarded = hours_sleept * 10;
					
					preference.edit().putInt("sleep_hours_sun", hours_sleept).commit();
					
					int balance = preference.getInt("sleepCoinBalance", 0);
					
					
					if(hours_sleept > 0){
						preference.edit().putInt("sleepCoinBalance", balance + token_awarded).commit();
					}
					
					sleep_hours = preference.getInt("sleep_hours_sun", 0);
					
					preference.edit().putInt("sleep_hours_sun", Integer.parseInt(hours) + sleep_hours).commit();
					
					preference.edit().putInt("hours_sun",Integer.parseInt( new SimpleDateFormat("HH").format(callendar.getTime()))).commit();
					
					if(hours_sleept > 0){
						SketchwareUtil.showMessage(getContext().getApplicationContext(), "Awarded " + String.valueOf(token_awarded) + " SleepCoin token");
					}
				}
			}
			else {
				SketchwareUtil.showMessage(getContext().getApplicationContext(), "Please set the time hour or press the cancel button");
			}
		}
		_dismiss_DialogFragment();
	}
	
}
