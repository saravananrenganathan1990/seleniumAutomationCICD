package main;

public class javalearning {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr = new int[4];
		arr[0] = 12;
		arr[1] = 99;
		arr[2] = 31;
		arr[3] = 90;
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] % 2==0)
			{
				System.out.println(arr[i]);	
			}
			else {
				System.out.println(arr[i]+"not divisible by 2");
			}

		}

	}

}
