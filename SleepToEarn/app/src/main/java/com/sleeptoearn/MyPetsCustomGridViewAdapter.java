package com.sleeptoearn;

//This is the class for my pets GridView adapter

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

public class MyPetsCustomGridViewAdapter extends BaseAdapter {
  private Context context;
  private ArrayList<HashMap<String, Object>> dataList;
  private LayoutInflater inflater;
  private int rippleColor = 0xFF9E9E9E; // Change this to your desired ripple color

  public MyPetsCustomGridViewAdapter(Context context, ArrayList<HashMap<String, Object>> dataList) {
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
	  convertView = inflater.inflate(R.layout.my_pets_customview, null);
	}

	// Bind data to the grid item layout
	HashMap<String, Object> item = dataList.get(position);
	TextView pet_name = convertView.findViewById(R.id.pet_name); //ID reference to the gridView pet name TextView
	TextView my_pet_nick_name = convertView.findViewById(R.id.my_pet_nick_name);
	LinearLayout info = convertView.findViewById(R.id.info);
	RelativeLayout container = convertView.findViewById(R.id.background_img);//ID reference to the gridView background_imgRelativeLayout
	
	//set it value sleep coin, pet name and also its background image with ClickListener and ripple color effect
	info.setOnClickListener(new InfoButtonClickListener(context,item));
	RippleUtils.setRippleEffect(info, rippleColor);
	pet_name.setText(item.get("pet_name").toString());
	my_pet_nick_name.setText(item.get("pet_nick_name").toString());
	setBackgroundDrawableWithTextColor(item,container,my_pet_nick_name);
	
	return convertView;
  }
  
  private void setBackgroundDrawableWithTextColor(HashMap<String, Object> item, RelativeLayout container, TextView my_pet_nick_name){
	if(item.get("pet_name").toString().equals("Smugglepuff")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#5B9ED9");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_3);
	}else if(item.get("pet_name").toString().equals("Snonezilly")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#FF9800");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_4);
	}else if(item.get("pet_name").toString().equals("Slumberfluff")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#8BC34A");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_5);
	}else if(item.get("pet_name").toString().equals("Moorbeam")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#4CAF50");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_1);
	}else if(item.get("pet_name").toString().equals("Dreamwhiskey")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#00E676");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_6);
	}else if(item.get("pet_name").toString().equals("Slloeprotandust")){
	  TextViewColorUtility.setTextColor(my_pet_nick_name, "#F44336");
	  BackgroundUtils.setBackgroundImage(context,container,R.drawable.pet_shop_img_2);
	}
  }
}

