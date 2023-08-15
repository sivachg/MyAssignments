package week1.day3;

import java.util.Arrays;
import java.util.Iterator;

public class SecondLarge {

	public static void main(String[] args) {
		int[] data = {3,2,11,4,6,7};
		int len = data.length;
		Arrays.sort(data);
		System.out.println("Second Largest Number is " +data[len-2]);
		
	}

}
