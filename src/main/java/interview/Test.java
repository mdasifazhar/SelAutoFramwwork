package interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import interview.sub.MyClass;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 2;
		method(a);
		// System.out.println(a);
	}

	public static void method(int a) {

		a = 5;
		System.out.println(a);
		System.out.println("--");
		System.out.println(String.valueOf('c').getClass());

		List<String> al = new ArrayList<String>();
		al.add("a");
		al.add("b");
		al.remove(0);
		System.out.println(al);

		String[] sa = { "a", "b", "c" };
		List<String> al1 = Arrays.asList(sa);

		System.out.println(al1);
		sa[2] = "d";
		System.out.println(al1);
		al1.set(2, "e");

		for (String s : sa) {
			System.out.println(s);
		}

		List<String> al2 = Arrays.asList("x","y","z");
		
		StringBuilder sb = new StringBuilder();
		sb.append("aaa").insert(1, "bb").insert(4,"ccc");
		System.out.println(sb.toString());
		String str1="abbccca";
		str1+='c';
		System.out.println(str1);
		
		String st1="a";
		st1+='c';
		st1+=true;
		System.out.println(st1);
		System.out.println(st1.hashCode());
		System.out.println("actrue".hashCode());
		System.out.println(st1=="actrue");
		
		ArrayList<Integer> ali=new ArrayList<>();
		ali.add(4);
		ali.add(5);
		ali.set(1,6);	
		ali.remove(0);
		System.out.println(ali);
		List<String> hex = Arrays.asList("30", "8", "3A", "FF");
		Collections.sort(hex);
		System.out.println(hex);
		
		String str2="acbcac";
		String[] strarr=str2.split("");
		HashMap<String,Integer> hm= new HashMap<>();
		
	}
}

class A{
	
	boolean swim;
	
	MyClass myclass= new MyClass("Asif");
	public void method() {
		return ;
	}
	
	public int method1() {
		return 1;
	}
	
}

