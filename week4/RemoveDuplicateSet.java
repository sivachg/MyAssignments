package week4.day2;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateSet {

	public static void main(String[] args) {
		String s = "PayPal India";
		char[] charArray = s.toCharArray();
		Set<Character> name = new HashSet<Character>();
		Set<Character> nameDup = new HashSet<Character>();
		for (char ch : charArray) {
			if(name.contains(ch)) {
				nameDup.add(ch);
			}
			else
				name.add(ch);
		}
		System.out.println("After removing duplicates" + nameDup + "from" + name);
		name.removeAll(nameDup);
		System.out.println(name);
		for (char ch : name) {
			if(ch != ' ')
				System.out.println(ch);
		}

	}

}
