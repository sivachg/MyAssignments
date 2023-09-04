package week4.day2;

import java.util.HashSet;
import java.util.Set;



public class PrintDuplicateNumberSet {

	public static void main(String[] args) {
		int[] data = {4,3,6,8,29,1,2,4,7,8};
		Set<Integer> nums = new HashSet<Integer>();
		for (int i = 0; i < data.length; i++) {
			for (int j = i+1; j < data.length; j++) {
				if(data[i]==data[j]) {
					System.out.println(data[i]);
				}
			}
			nums.add(data[i]);
			}
		System.out.println(nums);

	}

}
