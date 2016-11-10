package engine;

import java.util.Random;
import data.*;

public class Rand {
	
	private static final Random rnd = new Random();
	
	static int randomRange (int min, int max) {
		
		if (min > max) {
			int temp = min;
			min = max;
			max = temp;
		}
		return  min + rnd.nextInt(max - min + 1);
	}
	
	static int[] shufflePokemonIds() {
		
		int[] fusionIds = new int[Constants.NUM_POKEMON];
		
		for (int i = Pokemon.BULBASAUR.ordinal() ; i <= Pokemon.CELEBI.ordinal() ; i ++ )
			fusionIds[i] = i;
		
		for (int i = Pokemon.BULBASAUR.ordinal(), rand ; i <= Pokemon.CELEBI.ordinal() ; i ++ ) {
			
			do {
				do {
					rand = randomRange(Pokemon.BULBASAUR.ordinal(), Pokemon.CELEBI.ordinal());
				} while (i != rand);
			} while (Pokemon.values()[i].getEvoType() != Pokemon.values()[rand].getEvoType());
			
			int temp = fusionIds[rand];
			fusionIds[rand] = fusionIds[i];
			fusionIds[i] = temp;
		}
		
		return fusionIds;
	}

}
