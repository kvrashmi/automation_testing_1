package regular_expressions;

import java.util.regex.Pattern;

public class Demo1 {

	public static void main(String[] args) {
		boolean match = Pattern.matches("[a-d[m-p]]","b");
		if(match==true)
		{
			System.out.println("Matched");
		}
		else
		{
			System.out.println("No match");
		}
		
	}

}
