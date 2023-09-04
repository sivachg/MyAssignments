package week4.day2;

import java.util.HashSet;
import java.util.Set;

public class UniqueCharSet {

	public static void main(String[] args) {
		String name = "sivachidambaram";
		char[] charArray = name.toCharArray();
		System.out.println(charArray);
		Set<Character> nameSet = new HashSet<Character>();
		for (int i = 0; i < charArray.length; i++) {
			nameSet.add(charArray[i]);
		}
		System.out.println(nameSet);
	}

}
