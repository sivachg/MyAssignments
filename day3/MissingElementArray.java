package week1.day3;

public class MissingElementArray {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,7,6,9};
		for (int i = 0; i <= arr.length; i++) {
			if(i+1 != arr[i])
			{
				System.out.println("Missing Number in the given Array " + (i+1));
				break;
			}
		}

	}

}
