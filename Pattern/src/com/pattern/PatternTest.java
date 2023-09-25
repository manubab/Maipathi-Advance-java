package com.pattern;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternTest
{
	public static void main(String[] args) {
		
		Pattern p=Pattern.compile(".m");
		Matcher m=p.matcher("am");
		Boolean b=m.matches();
		
		System.out.println(b);
		
		boolean b1=Pattern.matches(".m.", "amu");
		System.out.println(b1);
		
		System.out.println(Pattern.matches("[^amn]", "c"));
	}

}
