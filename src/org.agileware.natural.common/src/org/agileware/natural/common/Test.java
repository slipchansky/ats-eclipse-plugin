package org.agileware.natural.common;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
	
	
	public static void main(String[] args) {
		
		String str1 = "new snippet \"s1\"";
		String str2 = "new snippet \"s2\":";
		String str3 = "alias \"s3\"";
		
		Pattern p = Pattern.compile(".*[new snippet|alias] \"([^\"]*)\"");
		Matcher matcher1 = p.matcher(str1);
		matcher1.find();
		Matcher matcher2 = p.matcher(str2);
		Matcher matcher3 = p.matcher(str3);
		boolean ok2 = matcher2.find();
		boolean ok3 = matcher3.find();
		String m1 = matcher1.group (0);
		String m2 = matcher1.group (1);
		
		m1 = matcher2.group (0);
		m2 = matcher2.group (1);
		
		m1 = matcher3.group (0);
		m2 = matcher3.group (1);
		
		int k = 0;
		k++;
			 
		
	}

}
