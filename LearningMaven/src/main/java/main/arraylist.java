package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class arraylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<String> a = new ArrayList<String>();
		a.add("alpha");
		a.add("beta");
		a.add("gamma");
		a.add("Rogers");
		//a.remove(1);
		//System.out.println(a);
		for (int i=0;i<a.size();i++)
		{
			System.out.println(a.get(i));
		}
		
		System.out.println("****************");
		
		for (String enhancedfor :a)
		{
			System.out.println(enhancedfor);
		}

		System.out.println("****************");
		String[] names = {"alpha","beta","gamma","Rogers"};
		List<String> namesArrayList = Arrays.asList(names);
//		namesArrayList.add("Space");
		for (int i=0;i<namesArrayList.size();i++)
		{
			System.out.println(namesArrayList.get(i));
		}
		
//		System.out.println("****************");
//		
//		String[] name = {"alpha","beta","gamma","Rogers"};
//		List<String> nameArrayList = Arrays.asList(name);
//		for (int i=0;i<nameArrayList.size();i++)
//		{
//			System.out.println(nameArrayList.contains("Rogers"));
//		}
	}

}
