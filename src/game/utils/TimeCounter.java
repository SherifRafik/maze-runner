package game.utils;

import java.util.Timer;
import java.util.TimerTask;

public class TimeCounter  {
	
	public static long counter = 0;
	public static String time;
    public static String strHours;
    public static String strMins; 
    public static String strSecs; 

	 Timer timer = new Timer();
	 TimerTask task = new TimerTask() {
		public void run(){
		 time = getTime(counter);
			counter++;
		}	
	};
	
	public  String getTime(long sec){
		long hours = 0 , remainderOfHours = 0 , minutes = 0 , seconds = 0;
		if(sec>=3600) { //if time exceeds 1 hour
			hours = sec / 3600;
			remainderOfHours = hours%3600;   //could be less or more than a minute
			if(remainderOfHours >= 60) { //more than or equal a minute
				minutes = remainderOfHours / 60;
				seconds = remainderOfHours % 60;
			}else {
				seconds = remainderOfHours; // less than a minute
			}
		}else if(sec >= 60) {
			minutes = sec / 60;
			seconds = sec % 60;
		}else if(sec < 60) {
			seconds = sec;
		}
		String time = getTimeAsString(seconds,minutes,hours);
		return time;
	}
	
	public   String getTimeAsString(long seconds , long minutes , long hours) {
	    strSecs = Long.toString(seconds);
	    if(minutes < 10)
	   	 strMins = "0" + Long.toString(minutes);
	   else
		   strMins = Long.toString(minutes);
	    if(hours < 10)
	    	strHours = "0" + Long.toString(hours);
	    else
	    	strHours = Long.toString(hours);
	    String time = strHours + ":" + strMins + ":" + strSecs;
	    return time;
	}

	public  void runTimer() {
		timer.schedule(task,0,1000);
	}
	
	
	public  void stoptimer() {
		task.cancel();
		timer.cancel();
		timer.purge();
	}
	
	//SETTERS GETTERS
	
	
	
	
		

}
