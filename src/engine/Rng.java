package engine;

import java.util.Random;

public class Rng {

	private static final Random rnd = new Random();
	
	static int randomRange (int min, int max) {
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return  min + rnd.nextInt(max - min + 1);
	}
	
}
