package week1.day2;

public class Factorial {

	public static void main(String[] args) {
		int input=5,fact=1;
		for(int i=1;i<=5;i++)
		{
			fact=fact*i;
		}
		System.out.println("Factorial of " +input + " is " +fact);
	}
}