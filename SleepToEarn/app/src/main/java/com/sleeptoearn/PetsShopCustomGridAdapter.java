package com.sleeptoearn;

//This is the class for our pet shop GridView adapter

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import android.widget.RelativeLayout;
import android.widget.LinearLayout;
import com.google.android.material.animation.Positioning;

public class PetsShopCustomGridAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<HashMap<String, Object>> dataList;
  private LayoutInflater inflater;
  private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color

  public PetsShopCustomGridAdapter(Context context, ArrayList<HashMap<String, Object>> dataList) {
	this.context = context;
	this.dataList = dataList;
	inflater = LayoutInflater.from(context);
  }

  @Override
  public int getCount() {
	return dataList.size();
  }

  @Override
  public Object getItem(int position) {
	return dataList.get(position);
  }

  @Override
  public long getItemId(int position) {
	return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
	if (convertView == null) {
	  convertView = inflater.inflate(R.layout.pet_shop_customview, null);
	}

	// Bind data to the grid item layout
	HashMap<String, Object> item = dataList.get(position);
	TextView textView = convertView.findViewById(R.id.sleep_coin); // Replace with your TextView's ID
	TextView pet_name = convertView.findViewById(R.id.pet_name);
	LinearLayout buy = convertView.findViewById(R.id.buy);
	LinearLayout info = convertView.findViewById(R.id.info);
	RelativeLayout container = convertView.findViewById(R.id.background_img);
	TextView pet_shop_nick_name = convertView.findViewById(R.id.pet_shop_nick_name);
    
    
    //Added ripple effect color to the buy and info LinearLayout
    RippleUtils.setRippleEffect(buy, rippleColor);
RippleUtils.setRippleEffect(info, rippleColor);
	
	//Set the buy LinearLayout button onClickListener and info
	buy.setOnClickListener(new BuyButtonClickListener(context,item));
	info.setOnClickListener(new InfoButtonClickListener(context,item));
	
	
	//If its the right key it should set it value sleep coin, pet name and also its background image
	if (position == 0) {
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_3);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
      TextViewColorUtility.setTextColor(pet_shop_nick_name, "#5B9ED9");
	} else if (position == 1) {
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_4);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
	  TextViewColorUtility.setTextColor(pet_shop_nick_name, "#FF9800");
	} else if(position == 2){
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_5);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
	  TextViewColorUtility.setTextColor(pet_shop_nick_name, "#8BC34A");
	} else if(position == 3){
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_1);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
	  TextViewColorUtility.setTextColor(pet_shop_nick_name, "#4CAF50");
	} else if(position == 4){
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_6);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
	  TextViewColorUtility.setTextColor(pet_shop_nick_name, "#00E676");
	} else if(position == 5){
	  textView.setText(item.get("sleepCoinAmount").toString());
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_2);
	  pet_name.setText(item.get("pet_name").toString());
	  pet_shop_nick_name.setText(item.get("pet_nick_name").toString());
	  TextViewColorUtility.setTextColor(pet_shop_nick_name, "#F44336");
	}
	// Add more cases for other keys as needed according to your keys

	return convertView;
  }
}

