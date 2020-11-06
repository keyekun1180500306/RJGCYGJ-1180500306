package Implementation;

import java.util.Random;

public class Impl {

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
