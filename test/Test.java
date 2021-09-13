package test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = 10;
		System.out.println(Math.toDegrees(Math.atan2(1, 1)));
		System.out.println(Math.atan2(1, 1));
		System.out.println(Math.toRadians(45));
		System.out.println(Math.sin(Math.toRadians(45)));
		System.out.println(Math.sin(Math.toRadians(60)));
		System.out.println(Math.sin(Math.toRadians(30)));
		
		System.out.println("==================================");
		int x = 1;
		int y = 1;
		double z = Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2));
		        
		        
//		double sin = Math.asin(y/z);
//		System.out.println(sin);
//		        
//		double cos = Math.acos(x/z);
//		System.out.println(cos);
//		        
//		double tan = Math.atan((double)y/x);
//		System.out.println(tan);
		
		double sin = Math.toDegrees(Math.asin(y/z));
		System.out.println(sin);
		        
		double cos = Math.toDegrees(Math.acos(x/z));
		System.out.println(cos);
		        
		double tan = Math.toDegrees(Math.atan((double)y/x));
		System.out.println(tan);
	}

}
