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

public class MyPetShopActivity extends AppCompatActivity {
	
	SharedPreferences.OnSharedPreferenceChangeListener listener;
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	
	private ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout vscroll1;
	private ImageView action_bar;
	private LinearLayout linear2;
	private ImageView option;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView textview2;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView img_coin;
	private TextView sleepCoinBalance;
	private GridView gridview1;
	
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.my_pet_shop);
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
		linear4 = findViewById(R.id.linear4);
		textview2 = findViewById(R.id.textview2);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		img_coin = findViewById(R.id.img_coin);
		sleepCoinBalance = findViewById(R.id.sleepCoinBalance);
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
		
		RippleUtils.setRippleEffect(action_bar, rippleColor);
		RippleUtils.setRippleEffect(option, rippleColor);
		_addGridViewAdapter();
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		sleepCoinBalance.setText(String.valueOf(prefs.getInt("sleepCoinBalance", 0)));
		_registerSharedPreference();
	}
	
	@Override
	public void onPause() {
		super.onPause();
		_unRegisterSharedPreference();
	}
	public void _addGridViewAdapter() {
		// Create an ArrayList to store the pet items
		ArrayList<HashMap<String, Object>> listMap = new ArrayList<>();
		
		// Define an array of pet data
		String[] sleepCoinAmounts = {"1000", "100000", "45000", "15000", "19000", "300000"};
		String[] petNames = {"Smugglepuff", "Snonezilly", "Slumberfluff", "Moorbeam", "Dreamwhiskey", "Slloeprotandust"};
		String[] petNickNames = {"common", "epic", "none", "uncommon", "uncommon", "legendary"};
		
		// Loop through the data and add it to listMap
		for (int i = 0; i < sleepCoinAmounts.length; i++) {
			    HashMap<String, Object> item = new HashMap<>();
			    item.put("sleepCoinAmount", sleepCoinAmounts[i]);
			    item.put("pet_name", petNames[i]);
			    item.put("pet_nick_name", petNickNames[i]);
			    listMap.add(item);
		}
		
		// Create the adapter and set it to your GridView
		PetsShopCustomGridAdapter adapter = new PetsShopCustomGridAdapter(this, listMap);
		gridview1.setAdapter(adapter);
		
	}
	
	
	public void _registerSharedPreference() {
		
		listener =
		    new SharedPreferences.OnSharedPreferenceChangeListener() {
			        @Override
			        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
				            // Handle the preference change here
				            if (key.equals("sleepCoinBalance")) {
					                // Handle the change of a specific preference
					               
					sleepCoinBalance.setText(String.valueOf(prefs.getInt("sleepCoinBalance", 0))); ToastUtils.CustomToast(getApplicationContext(), "Purchase went successfull", 16, 0xFF293340, 10, 1);
					                // Do something with the updated value
					            }
				        }
			    };
		prefs.registerOnSharedPreferenceChangeListener(listener);
	}
	
	
	public void _unRegisterSharedPreference() {
		prefs.unregisterOnSharedPreferenceChangeListener(listener);
	}
	
}