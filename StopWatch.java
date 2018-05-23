package project1;

import java.io.*;

import java.util.Scanner;

/************************************************************************
 * This class makes the functionalities of a stopwatch and lets 
 * the user add, subtract, or reset time. 
 * They can also save or load files.
 *
 * @author Kelly Hancox and Isfar Baset
 * @version May 22, 2018
 ************************************************************************/
public class StopWatch {

	/** This variable holds minutes for the stop watch */
	private int minutes;

	/** This variable holds the amount of seconds of the stop watch */
	private int seconds;

	/** This variable holds the amount of milliseconds of the stop watch */
	private int milliseconds;

	/** Status of the stop watch */
	private static boolean suspended = false;

	/**********************************************************************
	 * This is the default constructor that sets the StopWatch to zero
	 ***********************************************************************/
	public StopWatch() {

		//sets all time to 0
		minutes = 0;
		seconds = 0;
		milliseconds = 0;
	}

	/************************************************************************
	 * This is a constructor that initializes the instance variables with the
	 * provided values
	 * @param minutes minutes of the stopwatch
	 * @param seconds seconds of the stopwatch
	 * @param milliseconds milliseconds of the stopwatch
	 ************************************************************************/
	public StopWatch(int minutes, int seconds, int milliseconds) {

		//time cannot be negative or have invalid numbers
		if (minutes < 0 || seconds < 0 || seconds > 59 || 
				milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException("Error: minutes and seconds must be "
					+ "between 0 and 59 and milliseconds must be between 0 and 999");
		} 

		//sets the time to the parameters
		else {
			this.minutes = minutes;
			this.seconds = seconds;
			this.milliseconds = milliseconds;
		}
	}

	/************************************************************************
	 * A constructor that initializes the instance variables with the provided
	 * values
	 * @param seconds seconds of the stopwatch
	 * @param milliseconds milliseconds of the stopwatch
	 ************************************************************************/
	public StopWatch(int seconds, int milliseconds) {

		//time cannot be negative or have invalid numbers
		if (seconds < 0 || seconds > 59 || milliseconds < 0 || milliseconds > 999) {
			throw new IllegalArgumentException(
					"Error: seconds must be between 0 and 59" + " "
							+ "and milliseconds must be between 0 and 999");
		} 

		//sets seconds and milliseconds to parameter values
		else {
			this.seconds = seconds;
			this.milliseconds = milliseconds;
		}
	}

	/************************************************************************
	 * A constructor that initializes the instance variables with the provided
	 * values
	 * @param milliseconds milliseconds of the stopwatch
	 ************************************************************************/
	public StopWatch(int milliseconds) {

		//time cannot be negative or have invalid numbers
		if (milliseconds >= 0 && milliseconds <= 999) {
			convertFromMilliseconds(milliseconds);
		} 

		//throws an error for invalid time
		else {
			throw new IllegalArgumentException("Error: milliseconds "
					+ "must be between 0 and 999");
		}
	}

	/************************************************************************
	 * A constructor that accepts a string as a parameter with the 
	 * following format: “1:21:300” where 1 indicates minutes, 21 
	 * indicates seconds, and 300 indicates milliseconds. OR the 
	 * format “15:200” where the 15 indicates seconds, and 200
	 * indicates milliseconds, OR the format “300” where 300 indicates
	 * milliseconds.If a value is not specified, then it is set to zero. 
	 * We assumed that the input has no errors (i.e., a valid set 
	 * of numbers) contained within.
	 * @param startTime is the start time of the stopwatch in a 0:00:000 
	 * format
	 ************************************************************************/
	public StopWatch(String startTime) {

		// the string must exist
		if (startTime != null) {

			//intermediate values represent the time before they are tested
			//to become the true time values
			int minAttempt = -1;
			int secAttempt = -1;
			int milliAttempt = -1;

			//checks the last digit of the string
			char c = startTime.charAt(startTime.length()-1);
			if(Character.isDigit(c)==false) {
				throw new NumberFormatException();
			}

			//the string splits to be seperated into minute, second, and
			//millisecond values to be assessed serperately
			String pieces[] = startTime.split(":");

			try {
				
				//there is only one number
				if (pieces.length == 1) {
					milliAttempt = Integer.parseInt(pieces[0]);
					secAttempt = 0;
					minAttempt = 0;
				}

				//there is a second and millisecond value
				else if (pieces.length == 2) {
					secAttempt = Integer.parseInt(pieces[0]);
					milliAttempt = Integer.parseInt(pieces[1]);
					minAttempt = 0;
				}

				//there are time values for all values
				else if (pieces.length == 3) {
					minAttempt = Integer.parseInt(pieces[0]);
					secAttempt = Integer.parseInt(pieces[1]);
					milliAttempt = Integer.parseInt(pieces[2]);
				}

				//throws error for numbers out of bounds
				else {
					throw new IllegalArgumentException();
				}

				//if the chracters are not numbers
			} catch (NumberFormatException e) {
				throw new NumberFormatException();
			}

			//checks for valid numbers then allows the intermediate values
			//to become the actual time values
			if (minAttempt >= 0 && secAttempt >= 0 && secAttempt <= 59 && 
					milliAttempt >= 0 && milliAttempt <= 999) {
				this.minutes = minAttempt;
				this.seconds = secAttempt;
				this.milliseconds = milliAttempt;
			}

			//throws error
			else {
				throw new IllegalArgumentException();

			}
		}
	}

	/************************************************************************
	 * This method returns whether or not the stopwatch is suspended
	 * @param none
	 * @return the suspended boolean 
	 ************************************************************************/
	public boolean getSuspended() {
		return suspended;
	}

	/************************************************************************
	 * This method tells the user the amount of minutes on the stopwatch
	 * @param none
	 * @return the minutes on the stopwatch
	 ************************************************************************/
	public int getMinutes() {
		return minutes;
	}

	/************************************************************************
	 * This method allows the user to set the number of minutes on the
	 * stopwatch object
	 * @param minutes the minutes the user will place on the stopwatch
	 * @return none
	 ************************************************************************/
	public void setMinutes(int minutes) {

		//checks if it's suspended 
		if (suspended == false) {

			//checks for valid amount of minutes
			if (minutes < 0) {
				throw new IllegalArgumentException();
			} 

			//sets minute vlaue
			else {
				this.minutes = minutes;
			}
		}
	}

	/************************************************************************
	 * This method tells the user the amount of seconds on the stopwatch
	 * @param none
	 * @return the seconds on the stopwatch
	 ************************************************************************/
	public int getSeconds() {
		return seconds;
	}

	/************************************************************************
	 * This method allows the user to set the number of seconds on the
	 * stopwatch object
	 * @param seconds the user will place on the stopwatch
	 * @return none
	 ************************************************************************/
	public void setSeconds(int seconds) {

		//checks for valid time
		if (suspended == false) {
			if (seconds > 59 || seconds < 0) {
				throw new IllegalArgumentException();
			} else {
				this.seconds = seconds;
			}
		}
	}

	/************************************************************************
	 * This method tells the user the amount of milliseconds on 
	 * the stopwatch object
	 * @param none
	 * @return the milliseconds on the stopwatch
	 ************************************************************************/
	public int getMilliseconds() {
		return milliseconds;
	}

	/************************************************************************
	 * This method allows the user to set the number of milliseconds 
	 * on the stopwatch object
	 * @param milliseconds the user will add to the stopwatch
	 * @return none
	 ************************************************************************/
	public void setMilliseconds(int milliseconds) {

		//checks if the thing is 
		if (suspended == false) {

			//time cannot be negative or have invalid numbers
			if (milliseconds > 999 || milliseconds < 0) {
				throw new IllegalArgumentException();
			} 

			//sets millisecond value
			else {
				this.milliseconds = milliseconds;
			}
		}
	}

	/************************************************************************
	 * This method converts the amount of milliseconds in total from a 
	 * stopwatch to minutes and seconds 
	 * @param milliseconds that will be converted to seconds and minutes
	 * @return none
	 ************************************************************************/
	public void convertFromMilliseconds(int milliseconds) {

		//calculates minutes from milliseconds
		this.minutes = milliseconds / 60000;

		//calculates seconds from milliseconds
		this.seconds = (milliseconds - (minutes * 60000)) / 1000;

		//collects remaining milliseconds
		this.milliseconds = milliseconds - (minutes * 60000) - 
				(seconds * 1000);
	}

	/************************************************************************
	 * This method converts the total amount of minutes, seconds, and
	 * milliseconds from a stopwatch to only milliseconds
	 * @param minutes the amount of minutes on the stopwatch
	 * @param seconds the amount of seconds on the stopwatch
	 * @param milliseconds the amount of milliseconds on the stopwatch
	 * @return the amount of milliseconds in total from the minutes, seconds, 
	 * and milliseconds
	 ************************************************************************/
	public int convertToMilliseconds(int minutes, int seconds, int milliseconds) {
		int milli = minutes * 60000 + seconds * 1000 + milliseconds;
		return milli;
	}

	/************************************************************************
	 * This method tests whether or not one stopwatch equals another
	 * @param other another stopwatch that can be compared to the original
	 * @return whether the two stopwatches match one another
	 ************************************************************************/
	public boolean equals(StopWatch other) {

		//checks for equivalent values
		if (this.minutes == other.minutes && this.seconds == other.seconds && 
				this.milliseconds == other.milliseconds) {
			return true;
		} else {
			return false;
		}
	}

	/************************************************************************
	 * This method tests whether or not one stopwatch equals another
	 * @param other another object that can be compared to the original
	 * @return whether the two stopwatches match one another
	 ************************************************************************/
	public boolean equals(Object other) {

		//checks for equivalent values
		if (this.minutes == ((StopWatch) other).minutes && this.seconds == 
				((StopWatch) other).seconds
				&& this.milliseconds == ((StopWatch) other).milliseconds) {
			return true;
		} else {
			return false;
		}
	}

	/************************************************************************
	 * This is a static method that returns true if StopWatch 
	 * object s1 is exactly the same as StopWatch object s2.
	 * @param s1 the first stopwatch
	 * @param s2 the seconds stopwatch
	 * @return whether or not the two stopwatches in the parameter equal 
	 * one another
	 ************************************************************************/
	public static boolean equals(StopWatch s1, StopWatch s2) {

		//checks for equivalent values
		if (s1.minutes == s2.minutes && s1.seconds == s2.seconds && 
				s1.milliseconds == s2.milliseconds) {
			return true;
		} else {

			return false;
		}
	}

	/************************************************************************
	 * A method that returns 1 the time represented by “this” StopWatch 
	 * object is greater than the time represented by the other StopWatch; 
	 * returns -1 if the time represented by “this” StopWatch object is 
	 * less than the other StopWatch; returns 0 if the time represented 
	 * by “this” StopWatch object is equal to the other StopWatch object.
	 * @param other this is a stopwatch object that will be compared to 
	 * the original
	 * @int this is a positive number if the original stopwatch has
	 * more time than the second one, it's zero if they had the same
	 * amount of time, and negative if the second stopwatch had more
	 * time than the first
	 ************************************************************************/
	public int compareTo(StopWatch other) {

		//intermediate variable to represent the milliseconds of first watch
		int th = this.convertToMilliseconds(getMinutes(), getSeconds(), 
				getMilliseconds());

		//intermediate variable to represent the milliseconds of second watch
		int ot = other.convertToMilliseconds(other.getMinutes(), 
				other.getSeconds(), other.getMilliseconds());

		//compares watches' overall milliseconds
		if (th > ot) {
			return 1;
		} else if (th < ot) {
			return -1;
		} else {
			return 0;
		}
	}

	/************************************************************************
	 * This adds milliseconds to the stopwatch's time
	 * @param milliseconds the amount of milliseconds added to the original 
	 * stopwatch
	 * @return none
	 ************************************************************************/
	public void add(int milliseconds) {

		//checks if suspended
		if (suspended == false) {

			//valid milliseconds
			if (milliseconds < 0) {
				throw new IllegalArgumentException();
			}

			//converts to total milliseconds on stopwatch and adds the
			//milliseconds given to the total time then converts back
			else {
				int temp = this.convertToMilliseconds(minutes, seconds, 
						this.milliseconds);
				temp += milliseconds;
				this.convertFromMilliseconds(temp);
			}
		}

	}

	/************************************************************************
	 * This adds the time of another stopwatch to another stopwatch's time 
	 * @param other the second added to the original stopwatch's time
	 * @return none
	 ************************************************************************/
	public void add(StopWatch other) {

		//checks if suspended
		if (suspended == false) {
			int otherMilliseconds = other.convertToMilliseconds(other.getMinutes(), 
					other.getSeconds(),
					other.getMilliseconds());
			int thisMilliseconds = convertToMilliseconds(minutes, 
					seconds, milliseconds);

			//adds total milliseconds of one stopwatch to another
			this.milliseconds = thisMilliseconds + otherMilliseconds;


			//converts the time
			convertFromMilliseconds(milliseconds);
		}
	}

	/************************************************************************
	 * Add one millisecond to the stopwatch's time
	 * @param none
	 * @return none
	 ************************************************************************/
	public void inc() {

		//checks if suspended
		if (suspended == false) {

			//checks if time will increase seconds
			if (milliseconds == 999 && (seconds >= 0 && seconds < 59)) {
				seconds++;
				milliseconds = 000;
			}

			//checks if time will change minute
			else if (milliseconds == 999 && seconds == 59) {
				minutes++;
				seconds = 00;
				milliseconds = 000;
			} 

			//increments milliseconds
			else {
				milliseconds++;
			}
		}
	}

	/************************************************************************
	 * Subtract a certain number of milliseconds to the stopwatch's time
	 * @param milliseconds
	 * @return none
	 ************************************************************************/
	public void sub(int milliseconds) {

		//checks if suspended
		if (suspended == false) {

			//checks valid milliseconds
			if (milliseconds > 0) {
				for (int i = 0; i < milliseconds; i++) {
					this.dec();
				}
			} 

			//occurs when trying to subtract to negative time
			else {
				throw new IllegalArgumentException();
			}
		}
	}

	/************************************************************************
	 * Subtract time of one stopwatch from another stopwatch 
	 * @param other the second stopwatch
	 * @return none
	 ************************************************************************/
	public void sub(StopWatch other) {

		//checks for suspended
		if (suspended == false) {
			int otherMilliseconds = convertToMilliseconds(other.getMinutes(), 
					other.getSeconds(),
					other.getMilliseconds());
			int thisMilliseconds = this.convertToMilliseconds(this.getMinutes(), 
					this.getSeconds(),
					this.getMilliseconds());

			//subtract total milliseconds of one watch form another
			this.milliseconds = thisMilliseconds - otherMilliseconds;

			//converts total milliseconds back to time values
			convertFromMilliseconds(this.milliseconds);
		}
	}

	/************************************************************************
	 * Decrement one millisecond to the stopwatch's time
	 * @param none
	 * @return none
	 ************************************************************************/
	public void dec() {

		//checks if suspended
		if (suspended == false) {
			if (minutes == 0 && seconds == 0 && milliseconds <= 0) {
				throw new IllegalArgumentException();
			}

			//occurs to change minute value 
			else if (milliseconds == 0 && seconds == 0 && minutes > 0) {
				minutes--;
				seconds = 59;
				milliseconds = 999;
			}

			//occurs if changes second
			else if (milliseconds == 0 && seconds > 0) {
				seconds--;
				milliseconds = 999;
			}

			//goes down one millisecond
			else {
				milliseconds--;
			}
		}
	}

	/************************************************************************
	 * Put the time of a string into a "0:00:000" format
	 * @param none
	 * @return none
	 ************************************************************************/
	public String toString() {
		String time = null;

		//these intermediate values represent the time for testing 
		String minuteAttempt = "0";
		String secondAttempt = "00";
		String milliAttempt = "000";

		//set the minutes to the intermediate variable
		if (minutes >= 0) {
			minuteAttempt = Integer.toString(minutes);
		}

		//set the seconds to the intermediate variable
		if (seconds >= 0 && seconds <= 9) {
			secondAttempt = "0" + seconds;
		} if (seconds >= 10 && seconds <= 59) {
			secondAttempt = Integer.toString(seconds);
		}

		//set the milliseconds to the intermediate variable
		if (milliseconds >= 0 && milliseconds <= 9) {
			milliAttempt = "00" + this.getMilliseconds();
		}if (milliseconds >= 10 && milliseconds <= 99) {
			milliAttempt = "0" + milliseconds;
		}if (milliseconds >= 100 && milliseconds <= 999) {
			milliAttempt = Integer.toString(milliseconds);
		}

		//combine all time pieces if they are valid and return
		time = minuteAttempt + ":" + secondAttempt + ":" + milliAttempt;
		return time;
	}

	/************************************************************************
	 * Save the time from one stopwatch object
	 * @param fileName the name of the file
	 * @return none
	 ************************************************************************/
	public void save(String fileName) {
		PrintWriter out = null;
		try {

			//save to a file
			out = new PrintWriter(new BufferedWriter(new FileWriter(fileName)));
		} 

		//problem reading file
		catch (Exception e) {
			e.printStackTrace();
		}
		out.println(minutes);
		out.println(seconds);
		out.println(milliseconds);
		out.close();
	}

	/************************************************************************
	 * Load the time of a saved stopwatch to the interface
	 * @param fileName the name of the file where the information is saved
	 * @return none
	 ************************************************************************/
	public void load(String fileName) {
		if (suspended == false) {
			try {

				// open the data file
				Scanner fileReader = new Scanner(new File(fileName));

				// read one int
				minutes = fileReader.nextInt();
				seconds = fileReader.nextInt();
				milliseconds = fileReader.nextInt();

				System.out.println(minutes);
				System.out.println(seconds);
				System.out.println(milliseconds);
			}

			// problem reading the file
			catch (Exception error) {
				System.out.println("Something went wrong");
			}
		}
	}

	/************************************************************************
	 * Suspend the stopwatch changes like adding or subtracting or loading
	 * @param flag the true or false value that controls whether the 
	 * entire stopwatch will suspend fuction or not
	 * @return none
	 ************************************************************************/
	public static void suspend(boolean flag) {

		//if given a true, then all mutator operations suspend
		if (flag == true) {
			suspended = true;
		} 

		//if false, then the stopwatch resumes
		else if (flag == false) {
			suspended = false;
		}
	}

}
