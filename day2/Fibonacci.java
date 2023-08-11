package week1.day2;

import java.util.Iterator;

public class Fibonacci {

	public static void main(String[] args) {
		int input=8,num1=0,num2=1,sum;
		System.out.println(num1);
		for (int i = 1; i < input; i++) {
			sum=num1+num2;
			num1=num2;
			num2=sum;
			System.out.println(sum);
		}
	}
}
