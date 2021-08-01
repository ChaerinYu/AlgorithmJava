package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

/*
 * [D2] 1928. Base64 Decoder
 */
public class SWEA_1928 {

	public static void main(String args[]) throws Exception
	{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(reader.readLine());

		for(int test_case=1; test_case<=tc; test_case++) {
			String encode = reader.readLine();
			
			String decode = new String(Base64.getDecoder().decode(encode));
			
			System.out.println("#"+test_case+" "+decode);
		}
    }
}
