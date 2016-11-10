package misc;

import java.util.Random;
import data.*;

public class Rand {
	
	private static final Random rnd = new Random();
	
	public static byte randomRange (int min, int max) {
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return (byte) (min + rnd.nextInt(max - min + 1));
	}
	
	public static int[] shufflePokemonIDs() {
		
		int[] fusionIDs = new int[Pokemon.CELEBI.ordinal() - Pokemon.BULBASAUR.ordinal()];
		
		for (int i = Pokemon.BULBASAUR.ordinal() - 1 ; i <= Pokemon.CELEBI.ordinal() ; i ++ )
			fusionIDs[i] = i + 1;
		
		for (int i = Pokemon.BULBASAUR.ordinal() - 1 ; i <= Pokemon.CELEBI.ordinal() ; i ++ ) {
			
			int rand = randomRange(Pokemon.BULBASAUR.ordinal() - 1, Pokemon.BULBASAUR.ordinal()) - 1;
			int temp = fusionIDs[rand];
			fusionIDs[rand] = fusionIDs[i];
			fusionIDs[i] = temp;
		}
		
		return fusionIDs;
	}

}
