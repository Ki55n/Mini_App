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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import android.preference.PreferenceManager;

public class MyPetsActivity extends AppCompatActivity {
	
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	private int numberOfKeys = 0;
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear3;
	private ImageView action_bar;
	private LinearLayout linear2;
	private ImageView option;
	private TextView textview1;
	private LinearLayout linear4;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private GridView gridview1;
	
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.my_pets);
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
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		gridview1 = findViewById(R.id.gridview1);
		prefs = getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
		
		action_bar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		_addGridViewAdapter();
		
		RippleUtils.setRippleEffect(action_bar, rippleColor);
		RippleUtils.setRippleEffect(option, rippleColor);
	}
	
	public void _addGridViewAdapter() {
		
		// Get all keys from SharedPreferences
		Map<String, ?> allKeys = prefs.getAll();
		
		// Iterate through the keys and count them
		for (String key : allKeys.keySet()) {
			    // Check if the key matches the pattern you expect, e.g., "key0", "key1", "key2", etc.
			    if (key.matches("pet_name\\d+")) {
				        numberOfKeys++;
				    }
		}
		
		// Now, 'numberOfKeys' contains the count of keys matching the pattern
		
		for (int i = 0; i < numberOfKeys; i++) {
			    String pet_name_key = "pet_name" + i;
			    String pet_nick_name_key = "pet_nick_name" + i;
			    String sleepCoin = "sleepCoin" + i;
			    String pet_name_value = prefs.getString(pet_name_key, "");
			    String pet_nick_name_value = prefs.getString(pet_nick_name_key, "");
			    int sleepCoin_value = prefs.getInt(sleepCoin, 0);
			
			    // Create a HashMap to store the key-value pair
			    HashMap<String, Object> item = new HashMap<>();
			    item.put("pet_name", pet_name_value);
			    item.put("pet_nick_name", pet_nick_name_value);
			    item.put("sleepCoinAmount", sleepCoin_value);
			
			    // Add the HashMap to your listMap
			    listMap.add(item);
		}
		
		MyPetsCustomGridViewAdapter adapter = new MyPetsCustomGridViewAdapter(this, listMap);
		        gridview1.setAdapter(adapter);
	}
	
}