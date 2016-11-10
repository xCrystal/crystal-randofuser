package engine;

import java.util.Random;
import data.*;

public class Rand {
	
	private static final Random rnd = new Random();
	
	static byte randomRange (int min, int max) {
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return (byte) (min + rnd.nextInt(max - min + 1));
	}
	
	static int[] shufflePokemonIds() {
		
		int[] fusionIds = new int[Constants.NUM_POKEMON];
		
		for (int i = Pokemon.BULBASAUR.ordinal() - 1 ; i <= Pokemon.CELEBI.ordinal() ; i ++ )
			fusionIds[i] = i + 1;
		
		for (int i = Pokemon.BULBASAUR.ordinal() - 1 ; i <= Pokemon.CELEBI.ordinal() ; i ++ ) {
			
			int rand = randomRange(Pokemon.BULBASAUR.ordinal() - 1, Pokemon.BULBASAUR.ordinal()) - 1;
			int temp = fusionIds[rand];
			fusionIds[rand] = fusionIds[i];
			fusionIds[i] = temp;
		}
		
		return fusionIds;
	}

}
