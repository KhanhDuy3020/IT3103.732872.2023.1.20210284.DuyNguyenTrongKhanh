// Exercises: 6.4 DaysOfAMonth.java
// Nguyễn Trọng Khánh Duy - 20210284
package hust.soict.dsai.lab01;

import java.util.Scanner;

public class DaysOfAMonth {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String monthInput;
		int month, year;
		
		while (true) {
			System.out.println("Enter the year: ");
			year = scanner.nextInt();
			scanner.nextLine();
			if(year < 0) {
				System.out.println("Year doesn't exist. Please enter another year");
				continue;
			}
			System.out.println("Enter the month: ");
			monthInput = scanner.nextLine();
			if (monthInput.equals("January") || monthInput.equals("Jan.") || 
					monthInput.equals("Jan") || monthInput.equals("1")) {
				month = 1;
			} else if (monthInput.equals("February") || monthInput.equals("Feb.") || 
					monthInput.equals("Feb") || monthInput.equals("2")) {
				month = 2;
			} else if (monthInput.equals("march") || monthInput.equals("mar.") || 
					monthInput.equals("mar") || monthInput.equals("3")) {
				month = 3;
			} else if (monthInput.equals("April") || monthInput.equals("Apr.") || 
					monthInput.equals("Apr") || monthInput.equals("4")) {
				month = 4;
			} else if (monthInput.equals("May") || monthInput.equals("5")) {
				month = 5;
			} else if (monthInput.equals("June") || monthInput.equals("Jun.") || 
					monthInput.equals("Jun") || monthInput.equals("6")) {
				month = 6;
			} else if (monthInput.equals("July") || monthInput.equals("Jul.") || 
					monthInput.equals("Jul") || monthInput.equals("7")) {
                month = 7;
            } else if (monthInput.equals("August") || monthInput.equals("Aug.") || 
            		monthInput.equals("Aug") || monthInput.equals("8")) {
                month = 8;
            } else if (monthInput.equals("September") || monthInput.equals("Sep.") || 
            		monthInput.equals("Sep") || monthInput.equals("9")) {
                month = 9;
            } else if (monthInput.equals("October") || monthInput.equals("Oct.") || 
            		monthInput.equals("Oct") || monthInput.equals("10")) {
                month = 10;
            } else if (monthInput.equals("November") || monthInput.equals("Nov.") || 
            		monthInput.equals("Nov") || monthInput.equals("11")) {
                month = 11;
            } else if (monthInput.equals("December") || monthInput.equals("Dec.") || 
            		monthInput.equals("Dec") || monthInput.equals("12")) {
                month = 12;
            } else {
            	System.out.println("Month doesn't exist. Please enter another month");
            	continue;
            }
			
			System.out.println(month + "/" + year + ": " + getDaysInMonth(month, year) + " days");
			break;
		}
		
		scanner.close();
	}
	public static int getDaysInMonth(int month, int year) {
        if (month == 2) {
            if (isLeapYear(year)) {
                return 29;
            } else {
                return 28;
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 400 == 0) {
        	return true;
        }
        if (year % 4 == 0 && year % 100 != 0) {
        	return true;
        }
        return false;
    }
}
