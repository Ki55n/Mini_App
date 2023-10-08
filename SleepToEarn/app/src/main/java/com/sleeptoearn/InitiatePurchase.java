package com.sleeptoearn;
import android.content.Context;
import android.content.SharedPreferences;

public class InitiatePurchase {

  // Define a SharedPreferences file name (you can use any name you like)
  private String PREFS_NAME = "Inventory";
  // Get a reference to the SharedPreferences object
  private SharedPreferences sharedPreferences;
  // Edit the SharedPreferences using an Editor
  private SharedPreferences.Editor editor;
  private Context context;
  private int pet_bought_count = 0;
  private String pet_name = "";
  private String pet_nick_name = "";
  private int sleepCoinAmount = 0;
  private int sleepCoinBalance= 0;
  private boolean buyScreen2 = false;


  public InitiatePurchase(Context context, String sleepCoinAmount, String pet_name, String pet_nick_name, boolean buyscreen2) {
	this.context = context;
	this.buyScreen2 = buyscreen2;
	this.pet_name = pet_name;
	this.pet_nick_name = pet_nick_name;
	this.sleepCoinAmount = Integer.parseInt(sleepCoinAmount);
	sharedPreferences = this.context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
	doLogic();
  }

  private void doLogic() {
	//First get the pet count bought on the past in SharedPrefernce
	pet_bought_count = sharedPreferences.getInt("pet_count", 0);
	
	//Get my sleepCoin balance
	sleepCoinBalance = sharedPreferences.getInt("sleepCoinBalance", 0);

	//Calls to perform buy operations
	buy();
  }

  private void buy() {
	editor = sharedPreferences.edit();
	/*Added pet_bought_count variable to some keys so it can be unique to each
	 purchase so i can recover it as a History */
	editor.putString("pet_nick_name" + pet_bought_count, pet_nick_name);
	editor.putString("pet_name" + pet_bought_count, pet_name);
	editor.putInt("sleepCoin" + pet_bought_count, sleepCoinAmount);
	/*Added +1 to its value so the pet_bought_count variable could be unique to 
	 every purchase successfull*/
	editor.putInt("pet_count", pet_bought_count + 1);
    
	//Added the sleepCoinAmount on my sleepCoinBalance
    editor.putInt("sleepCoinBalance", sleepCoinBalance + sleepCoinAmount );

	// Apply the changes
	editor.apply();
    
  }

}
