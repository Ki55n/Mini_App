package com.sleeptoearn;
import android.content.Context;
import android.content.SharedPreferences;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import android.preference.PreferenceDataStore;

/*Achievement Task class checks all achievement task at the first
launch of this app if there are completed or not*/

public class AchievementTask {
    
  private Context context;
  private Calendar callendar;
  private SharedPreferences preference;
  private SharedPreferences.Editor editor;
  
    public AchievementTask(Context context){
	  this.context = context;
	  preference = this.context.getSharedPreferences("Inventory", this.context.MODE_PRIVATE);
	  checkAchievementTask1();
	}
	
	private void checkAchievementTask1(){
	  //Sleeping Beauty achievement task logic here
	 boolean isAchievementTask1Finished = checkCompletedAchievementTask1();
	 if(isAchievementTask1Finished == false){
	  int achievedTask1 = preference.getInt("Sleeping Beauty", 0);
	  
	  callendar = Calendar.getInstance();
	  
	  int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
	   if(hours_sleept >= 8){
		  if(achievedTask1 < 6){
		  editor = preference.edit();
		  editor.putInt("Sleeping Beauty", achievedTask1 + 1);
		  editor.putInt("sleepingBeautyProgress", achievedTask1 * 10);
		  editor.apply();
		  }else if(achievedTask1 == 6){
			int sleepCoinBalance = preference.getInt("sleepCoinBalance", 0);
			int token_awarded = achievedTask1 * 10;
			editor = preference.edit();
			editor.putInt("Sleeping Beauty", achievedTask1 + 1);
			editor.putInt("sleepingBeautyProgress", 100);
			editor.putInt("sleepCoinBalance", sleepCoinBalance + token_awarded);
			editor.apply();
		  }
	   }
	   }
	   
	   checkAchievementTask2();
	}

	private boolean checkCompletedAchievementTask1() {
	  int finishedAchievementTask = preference.getInt("Sleeping Beauty", 0);
	  boolean isFinished = false;
	  if(finishedAchievementTask == 7){
		isFinished = true;
		}
	  return isFinished;
	}
	
  private void checkAchievementTask2(){
	//Deep Diver achievement task logic here
	boolean isAchievementTask2Finished = checkCompletedAchievementTask2();
	if(isAchievementTask2Finished == false){
	  callendar = Calendar.getInstance();
	String dayOfWeek =  new SimpleDateFormat("EEE").format(callendar.getTime()).toLowerCase();
	int isNightTimeHour = preference.getInt("hours_" + dayOfWeek, 0);
	
	if(isNightTimeHour >= 18 && isNightTimeHour >= 24){
	  //Is Night hour time
	  int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
	   if(hours_sleept >= 8){
		 int achievedTask2 = preference.getInt("Deep Diver", 0);
		 if(achievedTask2 < 2){
		   editor = preference.edit();
		   editor.putInt("Deep Diver", achievedTask2 + 1);
		   editor.putInt("deepDiverProgress", achievedTask2 * 20);
		   editor.apply();
		 }else if(achievedTask2 == 2){
		   int sleepCoinBalance = preference.getInt("sleepCoinBalance", 0);
		   int token_awarded = achievedTask2 * 10;
		   editor = preference.edit();
		   editor.putInt("Deep Diver", achievedTask2 + 1);
		   editor.putInt("deepDiverProgress", 100);
		   editor.putInt("sleepCoinBalance", sleepCoinBalance + token_awarded);
		   editor.apply();
		 }
	   }
	}
	}
	
	//3
	checkAchievementTask3();
  }

  private boolean checkCompletedAchievementTask2() {
	int finishedAchievementTask = preference .getInt("Deep Diver", 0);
	boolean isFinished = false;
	if(finishedAchievementTask == 3){
	  isFinished = true;
	}
	return isFinished;
  }
  
  private void checkAchievementTask3(){
	//Night owl achievement task logic here
	boolean isAchievementTask3Finished = checkCompletedAchievementTask3();
	if(isAchievementTask3Finished == false){
	  callendar = Calendar.getInstance();
	  String dayOfWeek =  new SimpleDateFormat("EEE").format(callendar.getTime()).toLowerCase();
	  int hours_sleept = (int) CalendarUtils.calculateToHours(preference.getString("date", ""), new SimpleDateFormat("dd/MM/yyyy").format(callendar.getTime()));
	  int hours_sleept_for_the_day = preference.getInt("sleep_hours_" + dayOfWeek, 0);
	  if(hours_sleept == 7 && hours_sleept_for_the_day <= 5){
		int achievedTask2 = preference.getInt("Night Owl", 0);
		if(achievedTask2 == 0){
		  int sleepCoinBalance = preference.getInt("sleepCoinBalance", 0);
		  int token_awarded = achievedTask2 * 10;
		  editor = preference.edit();
		  editor.putInt("Night Owl", achievedTask2 + 1);
		  editor.putInt("nightOwlProgress", 100);
		  editor.putInt("sleepCoinBalance", sleepCoinBalance + token_awarded);
		  editor.apply();
		}
	  }
	}
	
	//4
	checkAchievementTask4();
  }

  private boolean checkCompletedAchievementTask3() {
	  int finishedAchievementTask = preference .getInt("Night Owl", 0);
	  boolean isFinished = false;
	  if(finishedAchievementTask == 1){
		isFinished = true;
	  }
	return isFinished;
  }
  
  private void checkAchievementTask4(){
	//Early Riser achievement task logic here
	boolean isAchievementTask4Finished = checkCompletedAchievementTask4();
	if(isAchievementTask4Finished == false){
	  callendar = Calendar.getInstance();
	  String dayOfWeek =  new SimpleDateFormat("EEE").format(callendar.getTime()).toLowerCase();
	  int hours_sleept_for_the_day = preference.getInt("sleep_hours_" + dayOfWeek, 0);
	  if(hours_sleept_for_the_day >= 18 && hours_sleept_for_the_day <= 24){
		int hour_waken_up = Integer.parseInt(new SimpleDateFormat("HH").format(callendar.getTime()));
		if(hour_waken_up < 6){
		  int achievedTask4 = preference.getInt("Early Riser", 0);
		  if(achievedTask4 > 6){
			editor = preference.edit();
			editor.putInt("Early Riser", achievedTask4 + 1);
			editor.putInt("earlyRiserProgress", achievedTask4 * 10);
			editor.apply();
		  }else if(achievedTask4 == 6){
			int sleepCoinBalance = preference.getInt("sleepCoinBalance", 0);
			int token_awarded = achievedTask4 * 10;
			editor = preference.edit();
			editor.putInt("Early Riser", achievedTask4 + 1);
			editor.putInt("earlyRiserProgress",100);
			editor.putInt("sleepCoinBalance", sleepCoinBalance + token_awarded);
			editor.apply();
		  }
		}
	  }
	  
	}
	
	//5
	checkAchievementTask5();
  }

  private boolean checkCompletedAchievementTask4() {
	int finishedAchievementTask = preference .getInt("Early Riser", 0);
	boolean isFinished = false;
	if(finishedAchievementTask == 7){
	  isFinished = true;
	}
	return isFinished;
  }
  
  // ... (Previous code)
  
  private static final long MILLIS_IN_15_MINUTES = 15 * 60 * 1000; // 15 minutes in milliseconds
  private static final int CONSECUTIVE_DAYS_REQUIRED = 14; // Number of consecutive days required

  private int consecutiveDays;
  
  private void checkAchievementTask5() {
	//Consistent sleeper achievement task logic here
    boolean isAchievementTask5Finished = checkCompletedAchievementTask5();
    if (!isAchievementTask5Finished) {
	 callendar = Calendar.getInstance();
	  long currentTimeMillis = callendar.getTimeInMillis();

	  // Retrieve the stored bedtime and wake-up time from SharedPreferences
	  long storedBedtimeMillis = preference.getLong("bedtimeMillis", 0);
	  long storedWakeUpTimeMillis = callendar.getTimeInMillis();

	  if (storedBedtimeMillis != 0 && storedWakeUpTimeMillis != 0) {
		// Calculate the difference between current time and stored times
		long bedtimeDiff = currentTimeMillis - storedBedtimeMillis;
		long wakeUpTimeDiff = currentTimeMillis - storedWakeUpTimeMillis;

		// Check if the difference is within a 15-minute window
		if (Math.abs(bedtimeDiff) <= MILLIS_IN_15_MINUTES && Math.abs(wakeUpTimeDiff) <= MILLIS_IN_15_MINUTES) {
		  consecutiveDays++;
		} else {
		  consecutiveDays = 0; // Reset consecutive days if not within the window
		}

		// Check if the achievement is achieved
		if (consecutiveDays >= CONSECUTIVE_DAYS_REQUIRED) {
		  int achievedTask5 = preference.getInt("Consistent Sleeper", 0);
		  if (achievedTask5 < 6) {
			editor = preference.edit();
			editor.putInt("Consistent Sleeper", achievedTask5 + 1);
			editor.putInt("consistentSleeperProgress", achievedTask5 * 10);
			editor.apply();
		  } else if (achievedTask5 == 6) {
			int sleepCoinBalance = preference.getInt("sleepCoinBalance", 0);
			int token_awarded = achievedTask5 * 10;
			editor = preference.edit();
			editor.putInt("Consistent Sleeper", achievedTask5 + 1);
			editor.putInt("consistentSleeperProgress", 100);
			editor.putInt("sleepCoinBalance", sleepCoinBalance + token_awarded);
			editor.apply();
		  }
		}
	  }
    }
  }

  private boolean checkCompletedAchievementTask5() {
	int finishedAchievementTask = preference .getInt("Consistent Sleeper", 0);
	boolean isFinished = false;
	if(finishedAchievementTask == 7){
	  isFinished = true;
	}
	return isFinished;
  }
    
}
