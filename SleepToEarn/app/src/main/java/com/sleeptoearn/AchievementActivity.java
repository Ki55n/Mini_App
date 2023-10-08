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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class AchievementActivity extends AppCompatActivity {
	
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	private int sleepingBeauty_progress = 0;
	private int deepDiver_progress = 0;
	private int nightOwl_progress = 0;
	private int earlyRiser_progress = 0;
	private int consistentSleeper_progress = 0;
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private ImageView action_bar;
	private LinearLayout linear2;
	private ImageView option;
	private TextView textview1;
	private LinearLayout linear4;
	private TextView textview2;
	private ListView listview1;
	
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.achievement);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear3 = findViewById(R.id.linear3);
		action_bar = findViewById(R.id.action_bar);
		linear2 = findViewById(R.id.linear2);
		option = findViewById(R.id.option);
		textview1 = findViewById(R.id.textview1);
		linear4 = findViewById(R.id.linear4);
		textview2 = findViewById(R.id.textview2);
		listview1 = findViewById(R.id.listview1);
		prefs = getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
		
		action_bar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		sleepingBeauty_progress = prefs.getInt("Sleeping Beauty", 0);
		deepDiver_progress = prefs.getInt("Deep Diver", 0);
		nightOwl_progress = prefs.getInt("Night Owl", 0);
		earlyRiser_progress = prefs.getInt("Early Riser", 0);
		consistentSleeper_progress = prefs.getInt("Consistent Sleeper", 0);
		RippleUtils.setRippleEffect(action_bar, rippleColor);
		RippleUtils.setRippleEffect(option, rippleColor);
		_addListViewAdapter();
	}
	
	public void _addListViewAdapter() {
		//Add the data to listMap
		List<Map<String, Object>> listMap = new ArrayList<>();
		
		// Add the first item with position 0
		HashMap<String, Object> item1 = new HashMap<>();
		item1.put("key0", "Sleeping Beauty");
		item1.put("key1", "Achieve 7 consecutive days of meeting the recommended amount of sleep.");
		item1.put("key2", prefs.getInt("sleepingBeautyProgress", 0));
		item1.put("key3", sleepingBeauty_progress + "/7");
		listMap.add(item1);
		
		// Add second item with position 1
		HashMap<String, Object> item2 = new HashMap<>();
		item2.put("key0", "Deep Diver");
		item2.put("key1", "Reach the deepest stage of sleep, REM, for at least 50% of your total sleep time three nights in a row.");
		item2.put("key2", prefs.getInt("deepDiverProgress", 0));
		item2.put("key3", deepDiver_progress + "/3");
		listMap.add(item2);
		
		// Add third item with position 2
		HashMap<String, Object> item3 = new HashMap<>();
		item3.put("key0", "Night Owl");
		item3.put("key1", "Successfully stay awake until 2:00 AM and still achieve a minimum of 7 hours of sleep.");
		item3.put("key2", prefs.getInt("nightOwlProgress", 0));
		item3.put("key3", nightOwl_progress + "/1");
		listMap.add(item3);
		
		// Add fourth item with position 3
		HashMap<String, Object> item4 = new HashMap<>();
		item4.put("key0", "Early Riser");
		item4.put("key1", "Wake up before 6:00 AM consistently for one week, indicating an early and productive start to the day.");
		item4.put("key2", prefs.getInt("earlyRiserProgress", 0));
		item4.put("key3", earlyRiser_progress + "/7");
		listMap.add(item4);
		
		HashMap<String, Object> item5 = new HashMap<>();
		item5.put("key0", "Consistent Sleeper");
		item5.put("key1", "Maintain a consistent bedtime and wake-up time within a 15-minute window for 14 consecutive days.");
		item5.put("key2", prefs.getInt("consistentSleeperProgress", 0));
		item5.put("key3", consistentSleeper_progress + "/7");
		listMap.add(item5);
		
		//Assign the listMap data to ListView in the AchievementAdapter class
		AchievementAdapter adapter = new AchievementAdapter(this, listMap);
		        listview1.setAdapter(adapter);
		    
	}
	
}
