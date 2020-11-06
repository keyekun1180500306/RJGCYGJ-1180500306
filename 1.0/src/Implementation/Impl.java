package Implementation;

import java.util.Random;

public class Impl {

	public Impl() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String argv[]){
		Impl impl1 = new Impl();
		for(int i=0;i<=12;i++) {
			int a = impl1.createRandomNumber(100);
			//System.out.println(a);
		}
		Integer a = new Integer(3313);
		Integer b = new Integer(3313);
		System.out.println(a.equals(b));
	}
	/**
	 * Give a number in the range of 0-x randomly 
	 * @param x must be greater than or equal to 0 
	 * @return a random number in the range of 0-x
	 */
	public int createRandomNumber(int x) {
		int result;
		Random random = new Random();
		result = random.nextInt(x);
		return result;
	}
}
