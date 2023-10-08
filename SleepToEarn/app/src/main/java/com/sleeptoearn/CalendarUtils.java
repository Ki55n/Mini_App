package com.sleeptoearn;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class CalendarUtils {
    
  /*This class converts the sleept date time and wakeup date time now
  into hours to determine the hours sleept*/
    
    public static long calculateToHours(String dateSaved, String dateNow){
	  String startDateString = dateSaved;
        String endDateString = dateNow;
	  long hoursDifference = 0;

	  SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parse the start and end dates into Date objects
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = dateFormat.parse(endDateString);

            // Calculate the time difference in milliseconds
            long timeDifferenceMillis = endDate.getTime() - startDate.getTime();

            // Convert milliseconds to hours
            hoursDifference = TimeUnit.MILLISECONDS.toHours(timeDifferenceMillis);
        } catch (ParseException e) {
            e.printStackTrace();
        }
	  return hoursDifference;
	}
}
