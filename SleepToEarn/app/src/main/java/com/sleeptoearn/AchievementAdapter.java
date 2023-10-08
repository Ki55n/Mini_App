package com.sleeptoearn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import java.util.List;
import java.util.Map;

public class AchievementAdapter extends BaseAdapter {
  private List<Map<String, Object>> listMap;
  private Context context;

  public AchievementAdapter(Context context, List<Map<String, Object>> listMap) {
	this.context = context;
	this.listMap = listMap;
  }

  @Override
  public int getCount() {
	return listMap.size();
  }

  @Override
  public Object getItem(int position) {
	return listMap.get(position);
  }

  @Override
  public long getItemId(int position) {
	return position;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
	ViewHolder holder;
	if (convertView == null) {
	  convertView = LayoutInflater.from(context).inflate(R.layout.achievement_customview, parent, false);
	  holder = new ViewHolder();
	  holder.achievementText = convertView.findViewById(R.id.achievement_text);
	  holder.achievementDescription = convertView.findViewById(R.id.achievement_description); // Corrected ID
	  holder.achievementProgress = convertView.findViewById(R.id.achievement_progress);
	  holder.achievementCount = convertView.findViewById(R.id.achievement_count);
	  holder.bg_img = convertView.findViewById(R.id.bg_img);
	  convertView.setTag(holder);
	} else {
	  holder = (ViewHolder) convertView.getTag();
	}

	Map<String, Object> item = listMap.get(position);

	// Bind data to views and set its value and background image according to its positions
	if (position == 0) {
	  holder.achievementText.setText((String) item.get("key0"));
	  holder.achievementDescription.setText((String) item.get("key1"));
	  holder.achievementProgress.setProgress((int) item.get("key2"));
	  holder.achievementCount.setText((String) item.get("key3"));
	  BackgroundUtils.setBackgroundImage(context, holder.bg_img, R.drawable.achievement_img_3);
	} else if (position == 1) {
	  holder.achievementText.setText((String) item.get("key0"));
	  holder.achievementDescription.setText((String) item.get("key1"));
	  holder.achievementProgress.setProgress((int) item.get("key2"));
	  holder.achievementCount.setText((String) item.get("key3"));
	  BackgroundUtils.setBackgroundImage(context, holder.bg_img, R.drawable.achievement_img_5);
	} else if (position == 2) {
	  holder.achievementText.setText((String) item.get("key0"));
	  holder.achievementDescription.setText((String) item.get("key1"));
	  holder.achievementProgress.setProgress((int) item.get("key2"));
	  holder.achievementCount.setText((String) item.get("key3"));
	  BackgroundUtils.setBackgroundImage(context, holder.bg_img, R.drawable.achievement_img_2);
	} else if (position == 3) {
	  holder.achievementText.setText((String) item.get("key0"));
	  holder.achievementDescription.setText((String) item.get("key1"));
	  holder.achievementProgress.setProgress((int) item.get("key2"));
	  holder.achievementCount.setText((String) item.get("key3"));
	  BackgroundUtils.setBackgroundImage(context, holder.bg_img, R.drawable.achievement_img_4);
	} else if (position == 4) {
	  holder.achievementText.setText((String) item.get("key0"));
	  holder.achievementDescription.setText((String) item.get("key1"));
	  holder.achievementProgress.setProgress((int) item.get("key2"));
	  holder.achievementCount.setText((String) item.get("key3"));
	  BackgroundUtils.setBackgroundImage(context, holder.bg_img, R.drawable.achievement_img_1);
	}

	return convertView;
  }

  static class ViewHolder {
	TextView achievementText;
	TextView achievementDescription;
	ProgressBar achievementProgress;
	TextView achievementCount;
	LinearLayout bg_img;
  }
}

