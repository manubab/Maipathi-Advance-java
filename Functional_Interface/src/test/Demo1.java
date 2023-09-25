package test;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Function;
import java.util.function.Supplier;


public class Demo1 {
	
	static boolean b;
	public static boolean stringReverse(String s)
	{
		for(int i=0;i<s.length();i++)
		{
			b=s.contains("z");
		}
		
		if(b==true)
		{
			System.out.println("charter exits ");
		}
		return false;
		
	}
	public static void main(String[] args) {
		
		Consumer<String> ob=Demo1::stringReverse;
		ob.accept("Manu Babu");
		
	System.out.println(	stringReverse("Manu"));
		
		
	
		
		
	}

}
