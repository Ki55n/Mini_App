package com.sleeptoearn;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import java.util.HashMap;

public class InfoButtonClickListener implements View.OnClickListener {

  private Context context;
  private String pet_name = "";
  private String pet_nick_name = "";
  private String sleepCoinAmount = "";
  private HashMap<String, Object> item;
  

  @Override
  public void onClick(View p1) {
	// This code will be executed when the view is clicked
	sleepCoinAmount = item.get("sleepCoinAmount").toString();
	pet_name = item.get("pet_name").toString();
	pet_nick_name = item.get("pet_nick_name").toString();
	//move to another activity
	moveToAnotherActivity();
	}

  public InfoButtonClickListener(Context context, HashMap<String, Object> item){
  this.context = context;
  this.item = item;
	}
	
	private void moveToAnotherActivity(){
	  Intent Intent = new Intent(context,PetShopInfoActivity.class);
	  Intent.putExtra("pet_nick_name", pet_nick_name);
	  Intent.putExtra("pet_name", pet_name);
	  Intent.putExtra("sleepCoinAmount", sleepCoinAmount);
	  context.startActivity(Intent);
	}


  }
