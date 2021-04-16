package renani.com.trianglewordsfunctional;



public class TriangleWordUtil {
	public static final int ASCII_OFFSET = 96;
	public static final int ASCII_END =122;
	
 
	
	public static int calculateWordValue (String value) {
		return value.chars().reduce(0,
				(s, e) -> s + e - ASCII_OFFSET);
	
	}
	
	public static int getTriangleNumber (String value) {
			int wordValue=calculateWordValue(value);
			double number =(Math.sqrt(wordValue*8 +1)-1)/2;
			if (number%1==0)
				return (int) number;
			else
				return -1;
			
	}
 
}
