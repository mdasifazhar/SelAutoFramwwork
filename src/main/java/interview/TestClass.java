package interview;

import java.util.Arrays;

public class TestClass {
	
	static Interview one;	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		one = new Interview();
		one = new Interview();
		
		String str= "abcdefedcbA";
		System.out.println(isPalindrome(str));
		byte[] bytes= convertByArray(str);
		System.out.println(bytes);
		String newStr=converBytesToString(bytes);
		System.out.println(newStr);
	}
	
	public static boolean isPalindrome(String str) {
		
		for(int i=0; i<str.length()/2;i++) {
			if(str.toLowerCase().charAt(i)!=str.toLowerCase().charAt(str.length()-i-1)) {
				return false;
			}
		}
		
		return true;
	}
	
	public static String converBytesToString(byte[] arr) {
		return Arrays.toString(arr);
		
	}
	public static byte[] convertByArray(String str) {
		return str.getBytes();
		
	}
	
	public void main(String args) {
		
	}

}
