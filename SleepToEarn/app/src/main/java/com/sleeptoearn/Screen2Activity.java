package com.sleeptoearn;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.os.Bundle;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import com.google.android.material.button.*;
import java.io.*;
import java.io.InputStream;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;

public class Screen2Activity extends AppCompatActivity {
	
	SharedPreferences.OnSharedPreferenceChangeListener listener;
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	
	private LinearLayout linear1;
	private ScrollView vscroll1;
	private ImageView action_bar;
	private LinearLayout linear2;
	private ImageView option;
	private TextView textview1;
	private LinearLayout linear3;
	private TextView textview2;
	private ImageView img_coin;
	private TextView sleepCoin_textview;
	private MaterialButton materialbutton1;
	private MaterialButton materialbutton2;
	private MaterialButton materialbutton3;
	private LinearLayout linear4;
	private LinearLayout linear5;
	private BarChart barChart;
	private TextView textview4;
	private ImageView option2;
	
	private Intent intent = new Intent();
	private SharedPreferences preference;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.screen2);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll1 = findViewById(R.id.vscroll1);
		action_bar = findViewById(R.id.action_bar);
		linear2 = findViewById(R.id.linear2);
		option = findViewById(R.id.option);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		textview2 = findViewById(R.id.textview2);
		img_coin = findViewById(R.id.img_coin);
		sleepCoin_textview = findViewById(R.id.sleepCoin_textview);
		materialbutton1 = findViewById(R.id.materialbutton1);
		materialbutton2 = findViewById(R.id.materialbutton2);
		materialbutton3 = findViewById(R.id.materialbutton3);
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		barChart = findViewById(R.id.barChart);
		textview4 = findViewById(R.id.textview4);
		option2 = findViewById(R.id.option2);
		preference = getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
		
		action_bar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				// Example usage:
				// To move to Another Activity, call:
				// ActivityUtils.moveToActivity(this, MySecondActivity.class);
				
				ActivityUtils.moveToActivity(Screen2Activity.this, MyPetShopActivity.class);
				
				// Replace MySecondActivity.class with the class of the activity you want to start.
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				// Example usage:
				// To move to Another Activity, call:
				// ActivityUtils.moveToActivity(this, MySecondActivity.class);
				
				ActivityUtils.moveToActivity(Screen2Activity.this, AchievementActivity.class);
				
				// Replace MySecondActivity.class with the class of the activity you want to start.
			}
		});
		
		materialbutton3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				// Example usage:
				// To move to Another Activity, call:
				// ActivityUtils.moveToActivity(this, MySecondActivity.class);
				
				ActivityUtils.moveToActivity(Screen2Activity.this, MyPetsActivity.class);
				
				// Replace MySecondActivity.class with the class of the activity you want to start.
			}
		});
		
		option2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Open SleepGoalDialogFragmentActivity DialogFragment
				_open_another_DialogFrag();
			}
		});
	}
	
	private void initializeLogic() {
		
		RippleUtils.setRippleEffect(action_bar, rippleColor);
		RippleUtils.setRippleEffect(option, rippleColor);
		RippleUtils.setRippleEffect(option2, rippleColor);
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		_registerSharedPreference();
		_getSharedPreferenceData();
		//Check all achievement task
		AchievementTask obj = new AchievementTask(Screen2Activity.this);
	}
	
	@Override
	public void onPause() {
		super.onPause();
		_unRegisterSharedPreference();
	}
	public void _InitiateAndAddBarChart() {
		  // Create some sample data
		        ArrayList<BarEntry> entries = new ArrayList<>();
		        entries.add(new BarEntry(0, 10)); // 0th position, value 10
		        entries.add(new BarEntry(1, 20)); // 1st position, value 20
		        entries.add(new BarEntry(2, 15)); // 2nd position, value 15
		        entries.add(new BarEntry(3, 25)); // 3rd position, value 25
		entries.add(new BarEntry(4, 20)); // 1st position, value 20
		        entries.add(new BarEntry(5, 15)); // 2nd position, value 15
		        entries.add(new BarEntry(6, 25)); // 3rd position, value 25
		
		        BarDataSet dataSet = new BarDataSet(entries, "Sleep data");
		        int color = Color.parseColor("#5B9ED9"); // Replace with your desired color
		dataSet.setColor(color); // Set the color
		
		        BarData barData = new BarData(dataSet);
		
		        barChart.setData(barData);
		
		        // Customize chart settings
		        barChart.getDescription().setEnabled(false); // Disable chart description
		
		        XAxis xAxis = barChart.getXAxis();
		        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X-axis position
		        xAxis.setDrawGridLines(false); // Hide vertical grid lines
		        xAxis.setGranularity(1f); // Set the granularity to 1 (integer values)
		        
		        // Set custom labels for each data point
		        final List<String> labels = new ArrayList<>();
		        labels.add("Mon");
		        labels.add("Tue");
		        labels.add("Wed");
		        labels.add("Thu");
		        labels.add("Fri");
		        labels.add("Sat");
		        labels.add("Sun");
		        
		        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
		
		        barChart.invalidate(); // Refresh the chart
		    
	}
	
	
	public void _open_another_DialogFrag() {
		   // Create an instance of your DialogFragment
		SleepGoalDialogFragmentActivity dialogFragment = new SleepGoalDialogFragmentActivity();
		
		        // Get the FragmentManager
		        FragmentManager fragmentManager = getSupportFragmentManager();
		
		        // Show the DialogFragment
		        dialogFragment.show(fragmentManager, "SleepGoalDialogFragmentActivity");
		    
	}
	
	
	public void _getSharedPreferenceData() {
		//Get my sleep coin balance and set it to the textview
		
		int amount = preference.getInt("sleepCoinBalance", 0);
		sleepCoin_textview.setText(String.valueOf((int)(amount)));
		int mon = preference.getInt("sleep_hours_mon", 0);
		
		int tue = preference.getInt("sleep_hours_tue", 0);
		
		int wed = preference.getInt("sleep_hours_wed", 0);
		
		int thu = preference.getInt("sleep_hours_thu", 0);
		
		int fri = preference.getInt("sleep_hours_fri", 0);
		
		int sat = preference.getInt("sleep_hours_sat", 0);
		
		int sun = preference.getInt("sleep_hours_sun", 0);
		_initiateAndAddBarChartData(mon* 10, tue * 10, wed * 10, thu * 10, fri * 10, sat * 10, sun * 10);
	}
	
	
	public void _initiateAndAddBarChartData(final int _mon, final int _tue, final int _wed, final int _thu, final int _fri, final int _sat, final int _sun) {
		  // Create some sample data
		        ArrayList<BarEntry> entries = new ArrayList<>();
		        entries.add(new BarEntry(0, _mon)); // 0th position, value 10
		        entries.add(new BarEntry(1, _tue)); // 1st position, value 20
		        entries.add(new BarEntry(2, _wed)); // 2nd position, value 15
		        entries.add(new BarEntry(3, _thu)); // 3rd position, value 25
		entries.add(new BarEntry(4, _fri)); // 1st position, value 20
		        entries.add(new BarEntry(5, _sat)); // 2nd position, value 15
		        entries.add(new BarEntry(6, _sun)); // 3rd position, value 25
		
		        BarDataSet dataSet = new BarDataSet(entries, "Sleep data");
		        int color = Color.parseColor("#5B9ED9"); // Replace with your desired color
		dataSet.setColor(color); // Set the color
		
		        BarData barData = new BarData(dataSet);
		
		        barChart.setData(barData);
		
		        // Customize chart settings
		        barChart.getDescription().setEnabled(false); // Disable chart description
		
		        XAxis xAxis = barChart.getXAxis();
		        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM); // X-axis position
		        xAxis.setDrawGridLines(false); // Hide vertical grid lines
		        xAxis.setGranularity(1f); // Set the granularity to 1 (integer values)
		        
		        // Set custom labels for each data point
		        final List<String> labels = new ArrayList<>();
		        labels.add("Mon");
		        labels.add("Tue");
		        labels.add("Wed");
		        labels.add("Thu");
		        labels.add("Fri");
		        labels.add("Sat");
		        labels.add("Sun");
		        
		        xAxis.setValueFormatter(new IndexAxisValueFormatter(labels));
		
		        barChart.invalidate(); // Refresh the chart
		    
	}
	
	
	public void _registerSharedPreference() {
		
		listener =
		    new SharedPreferences.OnSharedPreferenceChangeListener() {
			        @Override
			        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
				            // Handle the preference change here
				            if (key.equals("sleepCoinBalance")) {
					                // Handle the change of a specific preference
					               
					
					ToastUtils.CustomToast(Screen2Activity.this, "You have been awarded some SleepCoin token", 16, 0xFF293340, 10, 1); 
					                // Do something with the updated value
					            }
				        }
			    };
		preference.registerOnSharedPreferenceChangeListener(listener);
	}
	
	
	public void _unRegisterSharedPreference() {
		preference.unregisterOnSharedPreferenceChangeListener(listener);
	}
	
}