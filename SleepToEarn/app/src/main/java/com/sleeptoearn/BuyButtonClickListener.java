package com.sleeptoearn;
import android.content.Context;
import android.view.View;
import java.util.HashMap;

public class BuyButtonClickListener implements View.OnClickListener {

  private Context context;
  private HashMap<String, Object> item;
  
  public BuyButtonClickListener(Context context, HashMap<String, Object> item){
	this.context = context;
	this.item = item;
  }
  @Override
  public void onClick(View v) {
	// This code will be executed when the view is clicked
	// You can add your desired actions here
	// I Initiated purchase with valid Context in my InitiatePurchase class so it can buy or purchase sleepcoin
	final String sleepCoinValue = item.get("sleepCoinAmount").toString();
	final String pet_name = item.get("pet_name").toString();
	final String pet_nick_name = item.get("pet_nick_name").toString();
	final InitiatePurchase initiatePurchase = new InitiatePurchase(context,sleepCoinValue,pet_name,pet_nick_name,false);
  }
}
