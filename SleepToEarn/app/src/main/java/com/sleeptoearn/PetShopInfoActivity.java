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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.github.mikephil.charting.*;
import com.google.android.material.button.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class PetShopInfoActivity extends AppCompatActivity {
	
	SharedPreferences.OnSharedPreferenceChangeListener listener;
	private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color
	private String pet_name = "";
	private String pet_nick_name = "";
	private String sleepCoinAmount = "";
	private int bg_type = 0;
	
	private LinearLayout linear1;
	private ScrollView vscroll3;
	private ImageView action_bar;
	private LinearLayout linear2;
	private ImageView option;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private TextView pet_nick_name_textview;
	private TextView pet_name_textview;
	private LinearLayout linear7;
	private LinearLayout linear5;
	private ImageView img_coin;
	private TextView sleepCoinBalance;
	private CardView bg_full_container;
	private RelativeLayout bg_img;
	private CardView bg_top_full_container;
	private CardView characteristics_full_container;
	private CardView extra_boost_container;
	private LinearLayout buy_and_close_full_container;
	private LinearLayout bg_tops;
	private LinearLayout linear9;
	private TextView characteristics_textview;
	private LinearLayout linear10;
	private TextView extra_boost_textview;
	private MaterialButton materialbutton1;
	private LinearLayout linear15;
	private MaterialButton materialbutton2;
	
	private SharedPreferences prefs;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.pet_shop_info);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		vscroll3 = findViewById(R.id.vscroll3);
		action_bar = findViewById(R.id.action_bar);
		linear2 = findViewById(R.id.linear2);
		option = findViewById(R.id.option);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		pet_nick_name_textview = findViewById(R.id.pet_nick_name_textview);
		pet_name_textview = findViewById(R.id.pet_name_textview);
		linear7 = findViewById(R.id.linear7);
		linear5 = findViewById(R.id.linear5);
		img_coin = findViewById(R.id.img_coin);
		sleepCoinBalance = findViewById(R.id.sleepCoinBalance);
		bg_full_container = findViewById(R.id.bg_full_container);
		bg_img = findViewById(R.id.bg_img);
		bg_top_full_container = findViewById(R.id.bg_top_full_container);
		characteristics_full_container = findViewById(R.id.characteristics_full_container);
		extra_boost_container = findViewById(R.id.extra_boost_container);
		buy_and_close_full_container = findViewById(R.id.buy_and_close_full_container);
		bg_tops = findViewById(R.id.bg_tops);
		linear9 = findViewById(R.id.linear9);
		characteristics_textview = findViewById(R.id.characteristics_textview);
		linear10 = findViewById(R.id.linear10);
		extra_boost_textview = findViewById(R.id.extra_boost_textview);
		materialbutton1 = findViewById(R.id.materialbutton1);
		linear15 = findViewById(R.id.linear15);
		materialbutton2 = findViewById(R.id.materialbutton2);
		prefs = getSharedPreferences("Inventory", Activity.MODE_PRIVATE);
		
		action_bar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		
		materialbutton1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				//Initialize and purchase sleepCoin
				final InitiatePurchase initiatePurchase = new InitiatePurchase(PetShopInfoActivity.this,sleepCoinAmount,pet_name,pet_nick_name,true);
			}
		});
		
		materialbutton2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
	}
	
	private void initializeLogic() {
		pet_name = getIntent().getStringExtra("pet_name");
		pet_nick_name = getIntent().getStringExtra("pet_nick_name");
		sleepCoinAmount = getIntent().getStringExtra("sleepCoinAmount");
		pet_name_textview.setText(pet_name);
		pet_nick_name_textview.setText(pet_nick_name);
		extra_boost_textview.setText(sleepCoinAmount);
		
		RippleUtils.setRippleEffect(action_bar, rippleColor);
		RippleUtils.setRippleEffect(option, rippleColor);
		if (pet_name.equals("Smugglepuff")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_3);
		}
		if (pet_name.equals("Snonezilly")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_4);
		}
		if (pet_name.equals("Slumberfluff")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_5);
		}
		if (pet_name.equals("Moorbeam")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_1);
		}
		if (pet_name.equals("Dreamwhiskey")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_6);
		}
		if (pet_name.equals("Slloeprotandust")) {
			BackgroundUtils.setBackgroundImage(PetShopInfoActivity.this,bg_img,R.drawable.pet_shop_img_2);
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		_unRegisterSharedPreference();
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_registerSharedPreference();
	}
	public void _registerSharedPreference() {
		
		listener =
		    new SharedPreferences.OnSharedPreferenceChangeListener() {
			        @Override
			        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
				            // Handle the preference change here
				            if (key.equals("sleepCoinBalance")) {
					                // Handle the change of a specific preference
					
					ToastUtils.CustomToast(getApplicationContext(), "Purchase went successfull", 16, 0xFF293340, 10, 1);
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