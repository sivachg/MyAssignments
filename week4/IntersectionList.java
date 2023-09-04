package week4.day2;

import java.util.ArrayList;
import java.util.List;

public class IntersectionList {

	public static void main(String[] args) {
		int[] a={3,2,11,4,6,7};
		int[] b={1,2,8,4,9,7};
		List<Integer> note = new ArrayList<Integer>();
		List<Integer> book = new ArrayList<Integer>();
		List<Integer> notebook = new ArrayList<Integer>();
		for (int i = 0; i < a.length; i++) {
			note.add(a[i]);
		}
		for (int i = 0; i < b.length; i++) {
			book.add(b[i]);
		}
		System.out.println(note);
		System.out.println(book);
		for (int i = 0; i < note.size(); i++) {
			for (int j = 0; j < book.size(); j++) {
				if(note.get(i)==book.get(j)) {
					notebook.add(note.get(i));
					//System.out.println(note.get(i));
				}
			}
		}
		System.out.println("Intersection integers between two lists are : " + notebook);

	}

}
