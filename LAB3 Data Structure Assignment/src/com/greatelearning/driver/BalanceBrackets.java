package com.greatelearning.driver;

import java.util.Scanner;
import java.util.Stack;

public class BalanceBrackets {
	//Function checkingBalanceBrackets will check input string and validate the matching
	//braces by POP and PUSH function of stack data structure
	static boolean checkingBalanceBrackets(String brac) {
		
		Stack <Character> inputString = new Stack<Character>();
		
		for(int i=0;i<brac.length();i++) {
			char bracChar = brac.charAt(i);
			if(bracChar == '(' || bracChar == '{' || bracChar == '[') {
				inputString.push(bracChar);
				continue;
			}	
			if(inputString.isEmpty()) {
				return false;
			}
			//Check if we had inputed closing braces and start check for matching Open braces
			char localChar;
			switch(bracChar) 
			{
				case')' :
				{
					localChar = inputString.pop();
					if(localChar == '{' || localChar == '[') {
						return false;
					}
					break;	
				}
				case '}' :
				{
					localChar = inputString.pop();
					if(localChar == '(' || localChar == '[') 
					{
						return false;
					}
					break;   
				}
				case ']' :
				{
					localChar = inputString.pop();
					if(localChar == '(' || localChar == '{') 
					{
						return false;
					}
					break;   
				}
			}
		}	
		
		return (inputString.isEmpty());
	}

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your String of Brackets");
		String brackets = sc.next();
		
		//After calling method validate the call is true or false
		if(checkingBalanceBrackets(brackets)) {
			System.out.println("The entered String has Balanced Brackets");
		} else {
			System.out.println("The entered Strings do not contain Balanced Brackets");
		}
		
		sc.close();
	}

}
