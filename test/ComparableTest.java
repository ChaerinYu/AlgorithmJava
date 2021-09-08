package test;

import java.util.Arrays;
import java.util.Comparator;
/**
 * qpwoeirutyalskdjfhgzmxncbv 정렬
 * @author 
 *
 */
public class ComparableTest {

	static final String regex = "qpwoeirutyalskdjfhgzmxncbv";
	
	public static void main(String[] args) {
		String[] arr = {"c", "csharp", "java", "python"};
		
		Arrays.sort(arr, new Comparator<String>() {

//			char[] newSort = {'q', 'p', 'w', 'o', 'e', 'i', 'r', 'u'
//					, 't', 'y', 'a', 'l', 's', 'k', 'd', 'j', 'f'
//					, 'h', 'g', 'z', 'm', 'x', 'n', 'c', 'b', 'v'};

			@Override
			public int compare(String o1, String o2) {
				int minLen = Math.min(o1.length(), o2.length());
				char[] arr1 = o1.toCharArray();
				char[] arr2 = o2.toCharArray();
				
				for (int i = 0; i < minLen; i++) {
					if(arr1[i] == arr2[i]) {
						continue;
					}
					System.out.println(arr1[i]+", "+arr2[i]);
					return regex.indexOf(arr1[i])-regex.indexOf(arr2[i]);
				}
				return arr1.length-arr2.length;
			}
			
		});
		
		System.out.println(Arrays.toString(arr));
	}

}
