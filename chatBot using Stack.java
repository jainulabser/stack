package com.zsgs.student;

import java.util.Scanner;
import java.util.Stack;

/* POJO CLASS */
class Choice { // Store its Objects to Stack
	private int level; // levels of operation we perform
	private int choice; // choices make the level set

	public void setLevel(int level) {
		this.level = level; // store level
	}

	public void setChoice(int choice) {
		this.choice = choice; // store choice
	}

	public int getLevel() { // retrieve level count
		return level;
	}

	public int getChoice() { // retrieve choices
		return choice;
	}
}// End of Choice Class

/* AbsNet Work Class */
public class AbsNetwork { //
	private Stack<Choice> mStackCollection = new Stack<>();// Stack Collection for store objects of Choice Classes
	private Scanner mScanner = new Scanner(System.in);// Scanner object
	/* Level 0 */

	enum Index { // Index Page Enumeration Class
		option1("1 -> English"), option2("2 -> Tamil"), option3("0 -> exit");// Level 1 Objects

		private String text; // get String values we pass to the Constructor

		Index(String text) { // Index Constructor with String Parameter why because we pass arguments through
								// constructor
			this.text = text;
		}
	}// end of Index Page Enumeration Class //end of *Level 0
	/* Choice 1 on Level 1 */

	enum EnglishIndex {// EnglishIndex Enumeration Class
		option1("1 -> Recharge"), option2("2 -> Dth"), option3("3 -> Service"), option4("9 -> back"),
		option5("0 -> exit");

		private String text;

		EnglishIndex(String text) {
			this.text = text;
		}
	}// end of EnglishIndex Enumeration Class

	/* Choice 2 on Level 1 */
	enum TamilIndex {// Tamil Index Enumeration Class
		option1("1 -> ரிச்சார்ஜ்"), option2("2 -> டிடிஹச்"), option3("3 ->  சேவை "), option4("9 -> பின் செல்ல "),
		option5("0 -> exit");

		private String text;

		TamilIndex(String text) {
			this.text = text;
		}
	}// end of Tamil Index Enumeration Class //end of *Level 1
		// Level 3 started
	/* Choice 1 on Level 2 */

	enum Recharge {// Recharge Enumeration Class
		option1("1 ->  106. 1GB Data for 84 Days"), option2("2 -> 197. 2GB/DAY Data for 100 Days"),
		option3("3 -> ₹22 for 90 Days Pack"), option4("9 -> back"), option5("0 -> exit");

		private String text;

		Recharge(String text) {
			this.text = text;
		}
	}// end of Recharge Enumeration Class
	/* Choice 2 on Level 2 */

	enum Dth {// Dth Enumeration Class
		option1("1 ->  ₹100 for 50 Channels"), option2("2 -> ₹180 for 70 Channels"),
		option3("3 -> ₹216 for 88 Channels"), option4("9 -> back"), option5("0 -> exit");

		private String text;

		Dth(String text) {
			this.text = text;
		}
	}// end of Enumeration Class
	/* Choice 3 on Level 2 */

	enum Service {// Service Enumeration Class
		option1("1 ->  Call 1001 for Recharge Complaint"), option2("2 -> Call 1002 for DTH Complaint"),
		option3("9 -> back"), option4("0 -> exit");

		private String text;

		Service(String text) {
			this.text = text;
		}
	}// end of Enumeration Class //end of *Level 2
//End of all Enum Classes
	// method Area
	/*
	 * printDetails method get the level from index Details method by using
	 * Stackname.peek() method
	 */

	private void printDetails(int level) {
		if (level == 0) {// print all Elements inside level 0 Enum
			System.out.println(Index.option1.text);
			System.out.println(Index.option2.text);
			System.out.println(Index.option3.text);

		} else if (level == 1) {// level 1 enum
			switch (mStackCollection.peek().getChoice()) {// get top element choice value
			case 1: // print all Elements inside level 1 Choice 1
				System.out.println(EnglishIndex.option1.text);
				System.out.println(EnglishIndex.option2.text);
				System.out.println(EnglishIndex.option3.text);
				System.out.println(EnglishIndex.option4.text);
				System.out.println(EnglishIndex.option5.text);
				break;
			case 2:// print all Elements inside level 1 Choice 2
				System.out.println(TamilIndex.option1.text);
				System.out.println(TamilIndex.option2.text);
				System.out.println(TamilIndex.option3.text);
				System.out.println(TamilIndex.option4.text);
				System.out.println(TamilIndex.option5.text);
				break;
			}
		} else if (level == 2) {// level 2
			switch (mStackCollection.peek().getChoice()) {// get top element choice value
			case 1:// print all Elements inside level 2 Choice 1
				System.out.println(Recharge.option1.text);
				System.out.println(Recharge.option2.text);
				System.out.println(Recharge.option3.text);
				System.out.println(Recharge.option4.text);
				System.out.println(Recharge.option5.text);
				break;
			case 2:// print all Elements inside level 2 Choice 2
				System.out.println(Dth.option1.text);
				System.out.println(Dth.option2.text);
				System.out.println(Dth.option3.text);
				System.out.println(Dth.option4.text);
				System.out.println(Dth.option5.text);
				break;
			case 3:// print all Elements inside level 2 Choice 3
				System.out.println(Service.option1.text);
				System.out.println(Service.option2.text);
				System.out.println(Service.option3.text);
				System.out.println(Service.option4.text);
				break;
			}
		} else {// out of range in level and choices
			System.out.println("Successfull Operations");
			System.out.println("Bye");
			System.exit(0);
		}
	}// end of printDetails method
	/* indexDetails Method */

	private void indexDetails() {
		int choice;// local variable choice
		Choice choiceObj = new Choice();// create Objects for Choice class to store in to Stack
		mStackCollection.push(choiceObj);// perform *PUSH operation
		printDetails(mStackCollection.peek().getLevel());// call printDetails method to print level 0 Elements
		do {// start looping statement end by click 0
			Choice newChoiceObj = new Choice();// create new Object for Choice Class
			System.out.println("Enter Your Choice");
			choice = mScanner.nextInt();// get choice value
			if (choice == 0) { // if choice is 0 it means Exit
				System.out.println("Thank you for using our network");
				System.exit(0);
			} else if (choice == 9) {// 9 should be perform pop
				mStackCollection.pop();// performing popping decrease level value by 1
				if (mStackCollection.empty())// check after popping Stack is empty
				{
					System.out.println("Thank You for choose our network Bye");
					System.exit(0);// if yes then exit
				}
				printDetails(mStackCollection.peek().getLevel());// if not Then print previous stack element
			} else if (choice != 9) {// if not 0 and not 9 then
				newChoiceObj.setChoice(choice);// set the choice the class Choice
				newChoiceObj.setLevel(mStackCollection.peek().getLevel() + 1);// Increasing the level value by 1
				mStackCollection.push(newChoiceObj);// after successfully change level and choice push it to stack
				printDetails(mStackCollection.peek().getLevel());// print next page elements
			}
		} while (choice != 0);// condition for stop looping
	}// end of indexDetails Method
	/* main method */

	public static void main(String args[]) {
		AbsNetwork absNetwork = new AbsNetwork();// create object for AbsNetwork Class
		absNetwork.indexDetails();// call indexDetails method perform operaions
	}// end of main method
}// end of AbsNetwork Class
