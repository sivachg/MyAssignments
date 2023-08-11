package week1.day2;

public class PosNeg {

	public static void main(String[] args) {
		int num1=-40,num2=35;
		if(num1<0) {
			System.out.println("The Number is Negative:"+num1);
			num1=-num1;
			System.out.println("Converted to positive number:"+num1);
		}
		else 
			System.out.println("The Number is Positive:"+num1);
		if(num2<0) 
			System.out.println("The Number is Negative:"+num2);
		else 
			System.out.println("The Number is Positive:"+num2);	
	}
}
