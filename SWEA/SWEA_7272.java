package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
   7272. 안경이 없어!
 */
class SWEA_7272
{

    private static final String zeroHole = "CEFGHIJKLMNSTUVWXYZ";
    private static final String oneHole = "ADOPQR";
    private static final String twoHole = "B";
    
	public static void main(String args[]) throws Exception
	{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case = 1; test_case <= tc; test_case++)
		{
            
			String[] input = reader.readLine().split(" ");
			String str1 = input[0];
            String str2 = input[1];
            
            String ans = "";
            if(str1.length() != str2.length()) {
            	ans = "DIFF";
            } else {
            	for(int i=0; i<str1.length(); i++) {
            		String str1Char = String.valueOf(str1.charAt(i));
            		String str2Char = String.valueOf(str2.charAt(i));
            		
            		if((getZerohole().contains(str1Char) && getZerohole().contains(str2Char))
            				|| (getOnehole().contains(str1Char) && getOnehole().contains(str2Char))
            				|| (getTwohole().contains(str1Char) && getTwohole().contains(str2Char))) {
            			ans = "SAME";
            		} else {
            			ans = "DIFF";
            			break;
            		}
            	}
            }
            
            System.out.println("#"+test_case+ " " + ans);
            
		}
	}

	public static String getZerohole() {
		return zeroHole;
	}
	public static String getOnehole() {
		return oneHole;
	}
	public static String getTwohole() {
		return twoHole;
	}
}